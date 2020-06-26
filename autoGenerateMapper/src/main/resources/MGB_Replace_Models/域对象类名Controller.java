package 包名.web.controller;


import 包名.business.model.域对象类名;
import 包名.business.service.域对象类名Mng;
import com.rongji.egov.utils.exception.BusinessException;
import com.rongji.egov.utils.spring.validation.InsertValidate;
import com.rongji.egov.utils.spring.validation.UpdateValidate;
import org.apache.commons.lang.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * @author  hcg
 * @create  
 * @desc
 **/
@RestController
public class 域对象类名Controller {

    @Resource
    private 域对象类名Mng 对象名Mng;



    /**
     * 添加
     *
     * @param 对象名
     * @param bindingResult
     * @return
     */
    @PostMapping("/对象名/insert域对象类名")
    public 域对象类名 insert域对象类名(@RequestBody @Validated({InsertValidate.class}) 域对象类名 对象名, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BusinessException(bindingResult.getFieldError().getDefaultMessage());
        }

        int insertFlag = 对象名Mng.insert域对象类名(对象名);

        if (insertFlag!= 1) {
            throw new BusinessException("添加异常");
        }
        return 对象名Mng.get域对象类名ById(对象名.getId());
    }

    /**
     * 删除多个
     *
     * @param ids
     */
    @PostMapping("/对象名/delete域对象类名")
    public void delete域对象类名(@RequestBody List<String> ids) {
        int deleteFlag = 对象名Mng.del域对象类名(ids);
        if (deleteFlag < 1) {
            throw new BusinessException("删除出错");
        }
    }


    /**
     * 更新
     *
     * @param 对象名
     * @param bindingResult
     * @return
     */
    @PostMapping("/对象名/update域对象类名")
    public 域对象类名 update域对象类名(@RequestBody @Validated({UpdateValidate.class}) 域对象类名 对象名, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BusinessException(bindingResult.getFieldError().getDefaultMessage());
        }

        if (StringUtils.isBlank(对象名.getId())) {
            throw new BusinessException("更新异常，缺少id");
        }
        int updateFlag = 对象名Mng.update域对象类名(对象名);
        if (updateFlag != 1) {
            throw new BusinessException("更新错误");
        } else {
            return 对象名Mng.get域对象类名ById(对象名.getId());
        }
    }

    /**
     * 根据model获取list
     * @return
     */
    @GetMapping("/对象名/list域对象类名ByModel")
    public List<域对象类名> list域对象类名(域对象类名 对象名){
        return 对象名Mng.get域对象类名ByModel(对象名);
    }

    @GetMapping("/对象名/get域对象类名ById")
    public 域对象类名 get域对象类名ById(String id) {
        return 对象名Mng.get域对象类名ById(id);
    }


}