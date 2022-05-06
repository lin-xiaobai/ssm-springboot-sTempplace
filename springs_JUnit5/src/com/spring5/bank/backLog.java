package com.spring5.bank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @date 2021/8/1 -15:33
 * 手动 spring日志框架
 */
public class backLog {


    //    参数为当前类的class文件
    private static final Logger log = LoggerFactory.getLogger(backLog.class);

    public static void main(String[] args) {
//       通过log进行不同日志级别
//        手动在控制台进行日志输出
        log.info("heelow");
        log.warn("heelow2");
    }
}
