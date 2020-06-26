package com.rongji.egov.doc.web.controller;


import com.rongji.egov.doc.business.model.PrintRecoder;
import com.rongji.egov.doc.business.service.PrintRecoderMng;
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
public class PrintRecoderController {

    @Resource
    private PrintRecoderMng printRecoderMng;



    /**
     * 添加
     *
     * @param printRecoder
     * @param bindingResult
     * @return
     */
    @PostMapping("/printRecoder/insertPrintRecoder")
    public PrintRecoder insertPrintRecoder(@RequestBody @Validated({InsertValidate.class}) PrintRecoder printRecoder, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BusinessException(bindingResult.getFieldError().getDefaultMessage());
        }

        int insertFlag = printRecoderMng.insertPrintRecoder(printRecoder);

        if (insertFlag!= 1) {
            throw new BusinessException("添加异常");
        }
        return printRecoderMng.getPrintRecoderById(printRecoder.getId());
    }

    /**
     * 删除多个
     *
     * @param ids
     */
    @PostMapping("/printRecoder/deletePrintRecoder")
    public void deletePrintRecoder(@RequestBody List<String> ids) {
        int deleteFlag = printRecoderMng.delPrintRecoder(ids);
        if (deleteFlag < 1) {
            throw new BusinessException("删除出错");
        }
    }


    /**
     * 更新
     *
     * @param printRecoder
     * @param bindingResult
     * @return
     */
    @PostMapping("/printRecoder/updatePrintRecoder")
    public PrintRecoder updatePrintRecoder(@RequestBody @Validated({UpdateValidate.class}) PrintRecoder printRecoder, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BusinessException(bindingResult.getFieldError().getDefaultMessage());
        }

        if (StringUtils.isBlank(printRecoder.getId())) {
            throw new BusinessException("更新异常，缺少id");
        }
        int updateFlag = printRecoderMng.updatePrintRecoder(printRecoder);
        if (updateFlag != 1) {
            throw new BusinessException("更新错误");
        } else {
            return printRecoderMng.getPrintRecoderById(printRecoder.getId());
        }
    }

    /**
     * 根据model获取list
     * @return
     */
    @GetMapping("/printRecoder/listPrintRecoderByModel")
    public List<PrintRecoder> listPrintRecoder(PrintRecoder printRecoder){
        return printRecoderMng.getPrintRecoderByModel(printRecoder);
    }

    @GetMapping("/printRecoder/getPrintRecoderById")
    public PrintRecoder getPrintRecoderById(String id) {
        return printRecoderMng.getPrintRecoderById(id);
    }


}
