package com.rongji.egov.doc.business.mapper;

import com.rongji.egov.doc.business.model.PrintRecoder;
import com.rongji.egov.utils.api.paging.Page;
import com.rongji.egov.utils.api.paging.PagingRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PrintRecoderMapper {
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
