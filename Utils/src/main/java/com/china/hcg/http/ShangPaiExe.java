package com.china.hcg.http;

import com.alibaba.fastjson.JSONObject;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @autor hecaigui
 * @date 2020/6/13
 * @description
 */
public class ShangPaiExe {
    public static void main(String[] args){
        JSONObject dataValidations = new JSONObject();
        String judgeDate = "2020-06-14";
        String robDate = "2020-06-30";
       while (true){
           Date date = new Date();//取时间
           SimpleDateFormat simpleDate=new SimpleDateFormat("yyyy-MM-dd");
           String currentDate = simpleDate.format(date);
           if (judgeDate.equals(currentDate)){
                if (dataValidations.getJSONObject(robDate)!=null){
                    ShangPaiExe.orderShangPai(dataValidations.getJSONObject(robDate),robDate);
                }
                dataValidations.putAll(ShangPaiExe.getValicationOfDate(robDate));

           }
       }
//
    }
    // 上牌预约捡漏小程序
    public  static  void jianLou(){
        // 获取往后延期15天的验证码
        JSONObject dataValidations = new JSONObject();
        Date date = new Date();//取时间
        for (int i = 0; i<15;i++){
            Calendar calendar  =   Calendar.getInstance();
            calendar.setTime(date); //需要将date数据转移到Calender对象中操作
            calendar.add(Calendar.DATE,1);//把日期往后增加n天.正数往后推,负数往前移动
            date = calendar.getTime();
            SimpleDateFormat simpleDate=new SimpleDateFormat("yyyy-MM-dd");
            dataValidations.putAll(ShangPaiExe.getValicationOfDate(simpleDate.format(date)));
        }
        System.out.println(dataValidations);
    }
    /**
     * @description 获取日期验证
     * @author hecaigui
     * @date 2020/6/13
     * @param  * @param date
     * @return {'日期':{'__VIEWSTATE':'','__EVENTVALIDATION':''}}
     */
    public static JSONObject getValicationOfDate(String date){
        JSONObject dataValidations = new JSONObject();
        //SimpleDateFormat simpleDate=new SimpleDateFormat("yyyy-MM-dd");
        //System.out.println(simpleDate.format(date));

        //获取日期验证
        String url = "http://sp.fuzhou.gov.cn/Wechat_SM_Old/channel/wechat/WwyyDetail_WeChat.aspx?DeptName=%u516c%u5b89%u4ea4%u7ba1&YYSX=%u7535%u52a8%u81ea%u884c%u8f66%u65b0%u8f66%u62a5%u724c&YYNO=0100107000&TargetType=0100107000&Pid=&Phone=";
        MultiValueMap<String, String> requestMap = new LinkedMultiValueMap<>();
        requestMap.add("yysj",date);
        String postR = HttpClientUtil.postOfFormUrlencode(url,requestMap);

        String regState = "id=\"__VIEWSTATE\" value=\".*\"{1}";
        String regValidation = "id=\"__EVENTVALIDATION\" value=\".*\"{1}";
        Pattern regStatePattern = Pattern.compile(regState);
        Pattern regValidationPattern = Pattern.compile(regValidation);

        Matcher regStateMatcher = regStatePattern.matcher(postR);
        regStateMatcher.find();
        String regStateR = regStateMatcher.group();
        Matcher regValidationMatcher = regValidationPattern.matcher(postR);
        regValidationMatcher.find();
        String regValidationR = regValidationMatcher.group();

//            System.out.println(regStateR.substring(24,regStateR.length()-1));
//            System.out.println(regValidationR.substring(30,regValidationR.length()-1));
        JSONObject regJson = new JSONObject();
        regJson.put("__VIEWSTATE",regStateR.substring(24,regStateR.length()-1));
        regJson.put("__EVENTVALIDATION",regValidationR.substring(30,regValidationR.length()-1));
        dataValidations.put(date,regJson);
        return dataValidations;
    }
    public static void orderShangPai(JSONObject twoValidation,String orderDate){
        String url = "http://sp.fuzhou.gov.cn/Wechat_SM_Old/channel/wechat/WwyyDetail_WeChat.aspx?DeptName=%u516c%u5b89%u4ea4%u7ba1&YYSX=%u7535%u52a8%u81ea%u884c%u8f66%u65b0%u8f66%u62a5%u724c&YYNO=0100107000&TargetType=1%2c2&Pid=&Phone=";
        MultiValueMap<String, String> requestMap = new LinkedMultiValueMap<>();
        requestMap.add("__EVENTTARGET","");
        requestMap.add("__EVENTARGUMENT","");
        requestMap.add("__LASTFOCUS","");
        requestMap.add("__VIEWSTATE",twoValidation.getString("__VIEWSTATE"));
        requestMap.add("__EVENTVALIDATION",twoValidation.getString("__EVENTVALIDATION"));
        requestMap.add("yysj",orderDate);
        requestMap.add("yysd","14:00-15:00");
        requestMap.add("ddlObjectType","1");
        requestMap.add("entname","");
        requestMap.add("name","%BA%CE%B2%C6%B9%F3");
        requestMap.add("idNo","350181199701141872");
        requestMap.add("telNo","18350027142");
        requestMap.add("deptName","%B9%AB%B0%B2%BD%BB%B9%DC");
        requestMap.add("btnYY","%D4%A4+%D4%BC");
        String postR = HttpClientUtil.postOfFormUrlencode(url,requestMap);
        //您查看的网页异常
        //
        System.err.println(postR);
    }
}
