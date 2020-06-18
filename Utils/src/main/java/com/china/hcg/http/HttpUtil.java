package com.china.hcg.http;

import java.net.URL;

/**
 * @autor hecaigui
 * @date 2020/6/14
 * @description
 */
public class HttpUtil {
    public static  String getPrefix(String url){
        String pre = null;
        try {
            URL a = new URL(url);
            pre = a.getProtocol() + "://";
            pre += a.getHost();
            if (a.getPort() != -1){
               // pre += ":" + a.getPort() + "/";
                pre += ":" + a.getPort() + "";
            } else {
                //pre += "/";
                pre += "";
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return pre;
    }
    public static void main(String[] args){
        System.out.println(HttpUtil.getPrefix("https://fanyi.baidu.com:8080/"));
    }
}
