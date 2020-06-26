package com.rongji.egov.doc.business.dao.impl;


import com.rongji.egov.doc.business.dao.PrintRecoderDao;
import com.rongji.egov.doc.business.mapper.PrintRecoderMapper;

import com.rongji.egov.doc.business.model.PrintRecoder;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 
 * @create
 */
@Repository
public class PrintRecoderDaoImpl implements PrintRecoderDao {

    @Resource
    private PrintRecoderMapper mapper;
    @Override
    public  int insertPrintRecoder(PrintRecoder printRecoder){
        return  this.mapper.insertPrintRecoder(printRecoder);
    }

    @Override
    public  int delPrintRecoder(List<String> list){
        return  this.mapper.delPrintRecoder(list);
    }

    @Override
    public  int updatePrintRecoder(PrintRecoder printRecoder){
        return  this.mapper.updatePrintRecoder(printRecoder);
    }

    @Override
    public  PrintRecoder getPrintRecoderById(String id){
        return  this.mapper.getPrintRecoderById(id);
    }

    @Override
    public  List<PrintRecoder> getPrintRecoderByModel(PrintRecoder printRecoder){
        return  this.mapper.getPrintRecoderByModel(printRecoder);
    }

}
