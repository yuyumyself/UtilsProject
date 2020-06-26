package com.rongji.egov.doc.business.service.impl;


import com.rongji.egov.doc.business.service.PrintRecoderMng;
import com.rongji.egov.doc.business.dao.PrintRecoderDao;

import com.rongji.egov.doc.business.model.PrintRecoder;


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
public class PrintRecoderMngImpl implements PrintRecoderMng {

    @Resource
    private PrintRecoderDao dao;
    @Override
    public  int insertPrintRecoder(PrintRecoder printRecoder){
		if (StringUtils.isBlank(printRecoder.getId())) {
            printRecoder.setId(IdUtil.getUID());
        }
		// 初始化默认数据
        SecurityUser securityUser = SecurityUtils.getPrincipal();
        UmsUser umsUser=securityUser.getUmsUser();
        String userNo=securityUser.getUserNo();
		//printRecoder.setCreateTime(new Date());
		//printRecoder.setCreateUesr(umsUser.getUserName());
        //printRecoder.setCreateUesrNo(userNo);
        //printRecoder.setSystemNo(securityUser.getSystemNo());
        return  this.dao.insertPrintRecoder(printRecoder);
    }

    @Override
    public  int delPrintRecoder(List<String> list){
        return  this.dao.delPrintRecoder(list);
    }

    @Override
    public  int updatePrintRecoder(PrintRecoder printRecoder){
        return  this.dao.updatePrintRecoder(printRecoder);
    }

    @Override
    public  PrintRecoder getPrintRecoderById(String id){
        return  this.dao.getPrintRecoderById(id);
    }

    @Override
    public  List<PrintRecoder> getPrintRecoderByModel(PrintRecoder printRecoder){
        return  this.dao.getPrintRecoderByModel(printRecoder);
    }


}
