package 包名.business.service.impl;


import 包名.business.service.域对象类名Mng;
import 包名.business.dao.域对象类名Dao;

import 包名.business.model.域对象类名;


import javax.annotation.Resource;
import java.util.List;
import com.rongji.egov.utils.common.IdUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.lang.StringUtils;
import com.rongji.egov.user.business.model.SecurityUser;
import com.rongji.egov.user.business.util.SecurityUtils;
import com.rongji.egov.user.business.model.UmsUser;
/**
 * @author 
 * @create
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class 域对象类名MngImpl implements 域对象类名Mng {

    @Resource
    private 域对象类名Dao dao;
    @Override
    public  int insert域对象类名(域对象类名 对象名){
		if (StringUtils.isBlank(对象名.getId())) {
            对象名.setId(IdUtil.getUID());
        }
		// 初始化默认数据
        SecurityUser securityUser = SecurityUtils.getPrincipal();
        UmsUser umsUser=securityUser.getUmsUser();
        String userNo=securityUser.getUserNo();
		//对象名.setCreateTime(new Date());
		//对象名.setCreateUesr(umsUser.getUserName());
        //对象名.setCreateUesrNo(userNo);
        //对象名.setSystemNo(securityUser.getSystemNo());
        return  this.dao.insert域对象类名(对象名);
    }

    @Override
    public  int del域对象类名(List<String> list){
        return  this.dao.del域对象类名(list);
    }

    @Override
    public  int update域对象类名(域对象类名 对象名){
        return  this.dao.update域对象类名(对象名);
    }

    @Override
    public  域对象类名 get域对象类名ById(String id){
        return  this.dao.get域对象类名ById(id);
    }

    @Override
    public  List<域对象类名> get域对象类名ByModel(域对象类名 对象名){
        return  this.dao.get域对象类名ByModel(对象名);
    }


}
