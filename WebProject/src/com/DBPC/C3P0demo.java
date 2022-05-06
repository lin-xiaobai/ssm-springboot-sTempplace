package com.DBPC;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @date 2021/6/15 -11:03
 * 使用C3P0连接数据池
 * 1.需要导包c3p0-0.9.5.2
 * 添加依赖打开Project Structure中的Modules点击Scop右边的＋号liburay
 */
public class C3P0demo {
    //    获取dbcp方式的ds对象
    public static DataSource getDataSourceWithC3P0() {
//   如果是调用ComboPooledDataSource类的无参构造方法，是硬编码格式（采用set方法（））获取对象
        ComboPooledDataSource c3p0 = new ComboPooledDataSource();
        try {
            c3p0.setDriverClass("com.mysql.jdbc.Driver");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        c3p0.setJdbcUrl("jdbc:mysql://localhost:3306/shop");
        c3p0.setUser("root");
        c3p0.setPassword("root");
        //设置初始化，连接池中的连接数量
        c3p0.setInitialPoolSize(200);
//        设置连接池的最大连接数目
        c3p0.setMaxPoolSize(100);
        return c3p0;
    }


    //通过配置文件（固定的配置文件名称c3p0-config.xml)//在src下配置
//    public static  DataSource getDataSourceWithC3P0ByXml(){
//        ComboPooledDataSource c3p0=new ComboPooledDataSource("wenfeng");
//        return  c3p0;
//    }

    public static void main(String[] args) throws Exception {
//        System.out.println(C3P0demo.getDataSourceWithC3P0().getConnection());
//        System.out.println(C3P0demo.getDataSourceWithC3P0ByXml().getConnection());
        System.out.println(DBCPUtil.getDataSourceWithDbcpByProperties().getConnection());
    }
}
