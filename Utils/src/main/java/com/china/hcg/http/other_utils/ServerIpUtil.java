package com.china.hcg.http.other_utils;


import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.embedded.EmbeddedServletContainerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author hcg
 * @desc 获取服务器地址
 **/
@Component
public class ServerIpUtil implements ApplicationListener<EmbeddedServletContainerInitializedEvent> {
    private int serverPort;
    @Resource
    private Environment env;
    @Override
    public void onApplicationEvent(EmbeddedServletContainerInitializedEvent event) {
        this.serverPort = event.getEmbeddedServletContainer().getPort();
    }

    public int getServerPort() {
        return this.serverPort;
    }

    public String getServerIp() {
        InetAddress address=null;
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            throw new RuntimeException("服务IP获取失败");
        }
        return  address.getHostAddress();
    }
    /**
     * @description 当服务器很纯粹时，可使用该方法获取服务器地址
     * @author hecaigui
     * @date 2020-9-15
     * @param
     * @return 服务器地址 ip:端口
     */
    public String getPureServerAddress() {
        return this.getServerAddress()+":"+this.serverPort;
    }
    /**
     * @description 配合spring配置，来获取服务器地址
     * @author hecaigui
     * @date 2020-8-25
     * @param
     * @return 服务器地址 配置ip:配置端口
     */
    public String getServerAddress() {
        String server = "";
        // 例服务器进行中转了，有专门的对外接口
        if (StringUtils.isNotBlank(env.getProperty("serverIpAddress")) && StringUtils.isNotBlank(env.getProperty("serverPort"))){
            server= env.getProperty("serverIpAddress")+":"+env.getProperty("serverPort");
        }
        // 例有多网卡
        else if (StringUtils.isNotBlank(env.getProperty("serverIpAddress"))){
            server= env.getProperty("serverIpAddress")+":"+env.getProperty("server.port");
        }
        // 例无多网卡纯粹的linux系统
        else {
            server= this.getServerIp()+":"+env.getProperty("server.port");
        }
        return server;
    }

}
