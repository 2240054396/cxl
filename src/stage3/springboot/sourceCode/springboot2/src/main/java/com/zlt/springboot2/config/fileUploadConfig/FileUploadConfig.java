package com.zlt.springboot2.config.fileUploadConfig;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;
import javax.servlet.annotation.MultipartConfig;

@Configuration
public class FileUploadConfig {

    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory multipartConfigFactory=new MultipartConfigFactory();
        multipartConfigFactory.setMaxRequestSize(DataSize.ofMegabytes(100));
        multipartConfigFactory.setMaxFileSize(DataSize.ofMegabytes(10));
        return multipartConfigFactory.createMultipartConfig();
    }
}
