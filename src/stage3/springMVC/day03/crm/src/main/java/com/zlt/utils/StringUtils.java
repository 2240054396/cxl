package com.zlt.utils;

import java.util.UUID;

public class StringUtils {
    public static boolean isNotNull(String str){
        return str!=null&&!str.isEmpty();
    }
    public static String uuid(){
        return UUID.randomUUID().toString();
    }
}
