package com.zlt.springboot2.config.fileUploadConfig;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

@Component
public class MyKeyGenerator implements KeyGenerator {

    @Override
    public Object generate(Object target, Method method, Object... params) {
        StringBuilder key=new StringBuilder();
        key.append(target.getClass().getName()).append(":").append(method.getName());
        for (Object param : params) {
            key.append(":").append(param);
        }
        return key;
    }
}
