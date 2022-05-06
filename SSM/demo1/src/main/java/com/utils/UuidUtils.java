package com.utils;

import java.util.UUID;

/**
 * @date 2021/10/22 -15:46
 */
public class UuidUtils {
//    生成uuid
    public static String getUUID(){
//        返回一个Uuid,并且将uuid的“-”换成“”
        return  UUID.randomUUID().toString().replaceAll("-","");
    }

    public static void main(String[] args) {
        String uuid = UuidUtils.getUUID();
        System.out.println(uuid);
    }
}
