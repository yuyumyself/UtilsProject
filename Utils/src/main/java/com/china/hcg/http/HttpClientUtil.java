package com.china.hcg.http;

//import com.alibaba.fastjson.JSONObject;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import javafx.concurrent.Task;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @autor hecaigui
 * @date 2020-1-19
 * @description HttpClientUtil.java基于spring的RestTemplate实现的。
 */
public class HttpClientUtil {
    public static  RestTemplate rtSimpleFactory(){
        RestTemplate restTemplate = new RestTemplate();
        // 修正返回乱码https://blog.csdn.net/myhAini/article/details/103276726
        List<HttpMessageConverter<?>> httpMessageConverters = restTemplate.getMessageConverters();
        httpMessageConverters.stream().forEach(httpMessageConverter -> {
            if(httpMessageConverter instanceof StringHttpMessageConverter){
                StringHttpMessageConverter messageConverter = (StringHttpMessageConverter) httpMessageConverter;
                messageConverter.setDefaultCharset(Charset.forName("UTF-8"));
            }
        });
        return restTemplate;
    }
    public static String get(String url){
        RestTemplate restTemplate = HttpClientUtil.rtSimpleFactory();
        ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class);
        HttpStatus statusCode = entity.getStatusCode();
        System.out.println("get请求状态："+statusCode.value());
        String body = entity.getBody();
        System.out.println("get请求结果："+body);
        return body;
    }
    /**
     * @description
     * @author hecaigui
     * @date 2020/6/13
     * @param  url
     * @param requestMap  MultiValueMap<String, String> requestMap = new LinkedMultiValueMap<>();
     * @return
     */
    public static String post(String url, MultiValueMap<String, String> requestMap){
        RestTemplate restTemplate = HttpClientUtil.rtSimpleFactory();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity request = new HttpEntity<>(requestMap, headers);
        ResponseEntity<String> entity = restTemplate.postForEntity(url,request, String.class);
        HttpStatus statusCode = entity.getStatusCode();
        System.out.println("post请求状态："+statusCode.value());
        String body = entity.getBody();
        System.out.println("post请求结果："+body);
        return body;
    }
    public static String postOfFormUrlencode(String url, MultiValueMap<String, String> requestMap){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity request = new HttpEntity<>(requestMap, headers);
        ResponseEntity<String> entity = restTemplate.postForEntity(url,request, String.class);
        HttpStatus statusCode = entity.getStatusCode();
        System.out.println("post请求状态："+statusCode.value());
        String body = entity.getBody();
        if (statusCode.is3xxRedirection()){
            String url2 = HttpUtil.getPrefix(url)+entity.getHeaders().getLocation();
            body = HttpClientUtil.get(url2);
        }
        System.out.println("post请求结果："+body);

        return body;
    }
    public static void main(String[] args){
        HttpClientUtil.get("https://www.baidu.com/");
    }
}

//exchange:
//        String resultJsonStr = "";
//        HttpHeaders requestHeaders = new HttpHeaders();
//        requestHeaders.add("Content-Type", "application/json;charset=UTF-8");
//        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(null, requestHeaders);
//
//        ResponseEntity<String> responseEntity=restTemplate.exchange(url, HttpMethod.GET,requestEntity, String.class);
//        resultJsonStr=responseEntity.getBody();
//post：
//		private JSONObject  postForObj (String postUrl , JSONObject postObj){
//			RestTemplate restTemplate = new RestTemplate();
//			String remoteHost = ExCommon.getRequestUrl(this.rmsParamDao, "remoteHost");
//			String url = remoteHost+postUrl;
//			HttpHeaders headers = new HttpHeaders();
//			headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
//			HttpEntity request = new HttpEntity<>(postObj, headers);
//			ResponseEntity<String> response = restTemplate.postForEntity( url, request , String.class );
//			System.out.println(response.getBody());
//			JSONObject jsonResult = JSON.parseObject(response.getBody());
//			return jsonResult;
//		}
//		请求参数格式：
//		post headers{Content-Type：application/json}
//		参数为对象：
//			{
//				"fileUrl":"http://192.168.210.171:6051/egovAtt/downloadEgovAttFile?id=Xp1CAeD_o7WsO1N9",
//				"fileName":"417督办类型数据修改",
//				"ext":"doc",
//				"docId":"XpaEO4SuklmVoZFO"
//			}