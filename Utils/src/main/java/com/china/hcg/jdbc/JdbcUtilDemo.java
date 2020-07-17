package com.china.hcg.jdbc;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rongji.egov.user.business.dao.UserComparisonDao;
import com.rongji.egov.user.business.model.UserComparison;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author  hcg
 * @create  2019/4/24
 * @desc
 **/
@RestController
public class JdbcUtilDemo {

    @Autowired
    private Environment env;

    @Resource
    private UserComparisonDao userComparisonDao;

    /**
     * 旧字段数据迁移成新数据
     * 目的：将表的用户编码和组织编码数据，替换为新的hsf版的用户编码和组织编码
     * 步骤：
     *  建议：备份表 EGOV_NOTICE
     *  1.修改Table参数
     *  2.重写allNoticeQuery的queryOverride方法，在这里用java代码替换完参数后，用sql语句更新表数据。
     *  注：仅需修改少量的代码就可完成数据库表数据替换更新。标识为todo的地方为要进行代码修改的地方。
     *  queryOverride方法中REC_UNIT是替换数组的案例，CREATE_UESR_NO是替换字符串的案例。
     * @param
     * @param
     * @return
     */
    @GetMapping("/hsfUserMove/noticeUserMove")
    public String noticeUserMove() {
        // 获取所有新的hsf版的用户编码和组织编码
        final List<UserComparison> newUsers = userComparisonDao.getUserComparison(null);
        final Map<String, UserComparison> newUsersMaps = new HashMap<>();
        for (UserComparison user : newUsers) {
            newUsersMaps.put(user.getNo(), user);
        }

        final String Table = "EGOV_NOTICE";
        String driver = "com.mysql.jdbc.Driver";
        String url = env.getProperty("spring.datasource.url");
        String user = env.getProperty("spring.datasource.username");
        String password = env.getProperty("spring.datasource.password");


        final JdbcUtil allNoticeQuery = new JdbcUtil(driver,url,user,password) {
            @Override
            void queryOverride(ResultSet lastRowRS) throws SQLException{
                // todo:获取当前行的REC_UNIT字段数据。REC_UNIT数据为：['D0001','D0002']
                String REC_UNIT = lastRowRS.getString("REC_UNIT");
                // todo:获取当前行的CREATE_UESR_NO字段数据.CREATE_UESR_NO 数据为：U000001
                String createUserNo = lastRowRS.getString("CREATE_UESR_NO");
                // 这里获取了两个字段，所以会替换两个字段的数据，并生成对应的sql。

                boolean isUpdate = true;
                boolean isFirtCondition = true;
                String updateSql = "UPDATE "+Table+" SET ";
                // todo：替换REC_UNIT字段的数据，并生成对应的sql。
                if (StringUtils.isNotBlank(REC_UNIT)){
                    JSONArray jsonArray = JSONObject.parseArray(REC_UNIT);
                    JSONArray newJsonArray = new JSONArray();

                    // 更新REC_UNIT
                    for (Object  unit : jsonArray){
                        String unitNo = (String)unit;
                        UserComparison newUsr = newUsersMaps.get(unitNo);
                        if (newUsers == null){
                            isUpdate = false;
                        }
                        newJsonArray.add(newUsr.getOldNo());
                    }
                    // sql拼接
                    if (isFirtCondition){
                        updateSql += "`REC_UNIT` = " + "'"+ newJsonArray.toJSONString() + "'";
                        isFirtCondition = false;
                    } else {
                        updateSql += ","+"`REC_UNIT` = " + "'"+ newJsonArray.toJSONString() + "'";
                    }
                }
                // todo：替换CREATE_UESR_NO字段的数据，并生成对应的sql。
                if (StringUtils.isNotBlank(createUserNo)){
                    String newUserNo = "";
                    UserComparison newUsr = newUsersMaps.get(createUserNo);
                    if (newUsr == null){
                        isUpdate = false;
                    }
                    newUserNo = newUsr.getOldNo();

                    // sql拼接
                    if (isFirtCondition){
                        updateSql += "`CREATE_UESR_NO` = " + "'"+ newUserNo + "'";
                        isFirtCondition = false;
                    } else {
                        updateSql += ","+"`CREATE_UESR_NO` = " + "'"+ newUserNo + "'";
                    }

                }

                if (isUpdate && !isFirtCondition){
                    //
                    updateSql = updateSql + ","+"`HSF_USER_MOVE` = 'success' " + " WHERE `ID` = " + "'"+ lastRowRS.getString("ID")  + "'";
                    new JdbcUtil(driver,url,user,password).update(updateSql);
                }
            }
        };

        JdbcUtil alterTableQuery = new JdbcUtil(driver,url,user,password) {
            @Override
            void queryOverride(ResultSet lastRowRS) {
                try {
                    lastRowRS.getString("HSF_USER_MOVE");
                    System.err.println("HSF用户迁移------表已存在HSF_USER_MOVE字段,开始更新旧数据");
                    allNoticeQuery.query("select * from "+Table+" WHERE HSF_USER_MOVE IS NULL OR HSF_USER_MOVE = '' OR HSF_USER_MOVE = 'failure'");
                }catch (SQLException e){
                    new JdbcUtil(driver,url,user,password).update("ALTER TABLE "+Table+" ADD COLUMN `HSF_USER_MOVE` varchar(12) NULL COMMENT 'HSF用户改造后，旧数据是否已迁移标识'");
                    System.err.println("HSF用户迁移------为表新增HSF_USER_MOVE字段,开始更新旧数据");
                    allNoticeQuery.query("select * from "+Table+" WHERE HSF_USER_MOVE IS NULL OR HSF_USER_MOVE = '' OR HSF_USER_MOVE = 'failure'");
                }
            }
        };
        alterTableQuery.query("select * from "+Table+" limit 1");
        return Table+"更新完毕，表HSF_USER_MOVE的字段为success为成功更新";
    }



//    private String setArray(){
//
//    }
//    private String setString(){
//
//    }
}