package com.china.hcg.http.utils;

import org.springframework.core.io.ByteArrayResource;

/**
 * @autor hecaigui
 * @date 2020-8-15
 * @description restTemplate传输自己文件要使用该类，因为restTemplate的消息转换器在读取resource资源时会使用到AbstractResource的getfilename
 * https://www.cnblogs.com/paxing/p/11485049.html
 */
public class RestTemplateByteArrayResource extends ByteArrayResource {
    private String fileName;

    public RestTemplateByteArrayResource(byte[] bytes , String fileName){
        super(bytes);
        this.fileName = fileName;
    }
    @Override
    public String getFilename() throws IllegalStateException {
        return this.fileName;
    }
}
