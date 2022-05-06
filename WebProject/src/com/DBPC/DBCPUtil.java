package com.DBPC;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @date 2021/6/15 -11:56
 * 结合DBCP和C3P0的工具类
 * 可以通过类名点方法名直接获取
 */
public class DBCPUtil {
    //DBCP
    //    获取dbcp连接池的ds对象
    //方式一：
    public static DataSource getDataSourceBydbcp() {
//      获取dbcp方式的ds对象
        BasicDataSource dbcp = new BasicDataSource();
//        注册驱动
        dbcp.setDriverClassName("com.mysql.jdbc.Driver");
//        设置连接数据库的url
        dbcp.setUrl("jdbc:mysql://localhost:3306/shop");
//        数据库的用户名
        dbcp.setUsername("root");
//        数据库密码
        dbcp.setPassword("root");
//        连接池中的连接数量
        dbcp.setInitialSize(200);
//      连接池中处于活跃状态的数据库连接的最大数量
        dbcp.setMaxActive(10);
        return dbcp;

    }

    //获取连接池dbcp对象的方式二：通过配置文件dbcpconfig.properties配置文件
    public static DataSource getDataSourceWithDbcpByProperties() throws Exception {
        DataSource dbcp = null;
        //1.先把配置文件加载进来
//        获取配置文件dbcpconfig.properties
        Properties pros = new Properties();

//        把字符串变成输入流
        InputStream inputStream = new DBCPDemo().getClass().getClassLoader().getResourceAsStream("dbcpconfig.properties");

//       通过pros对象 加载配置文件dbcpconfig.properties 传参是一个输入流
        pros.load(inputStream);
        //获取配置信息的全部内容
        dbcp = BasicDataSourceFactory.createDataSource(pros);

        return dbcp;
    }

    //    C3P0
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
    public static DataSource getDataSourceWithC3P0ByXml() {
        ComboPooledDataSource c3p0 = new ComboPooledDataSource("wenfeng");
        return c3p0;
    }


}
