package com.zlt.controller;

import com.qiniu.util.Auth;

public class QlyController {
    public static void method1() {
        String accessKey = "access key";
        String secretKey = "secret key";
        String bucket = "bucket name";
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        System.out.println(upToken);
    }

    public static void main(String[] args) {
        method1();
    }
}
