package com.rongji.egov.doc.business.service;

import com.rongji.egov.doc.business.model.PrintRecoder;


import java.util.List;

public interface PrintRecoderDao {
    int insertPrintRecoder(PrintRecoder printRecoder);

    /**
     * 通过多个id批量删除
     * @param list
     * @return
     */
    int delPrintRecoder(List<String> list) ;

    int updatePrintRecoder(PrintRecoder printRecoder);

    PrintRecoder getPrintRecoderById(String id);
    /**
     * 根据域对象查询
     */
    List<PrintRecoder> getPrintRecoderByModel(PrintRecoder printRecoder);



}
