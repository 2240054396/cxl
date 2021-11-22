package com.zlt.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

public class MD5Util {
    public static String md5(String password,String salt,int time){
        return new Md5Hash(password,salt,time).toString();
    }
}
