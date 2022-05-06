package com.DBPC;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

/**
 * @date 2021/6/14 -20:36
 * 连接数据库的连接池
 * IDEA中获取DBCP连接池方式的对象
 * 需要导jar包
 * BasicDataSource方式（硬编码）：DasicDataSource对象设置各种数据
 * <p>
 * NoClassDefFoundError:这个异常的意思是缺少jar包
 */
public class DBCPDemo {
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

    public static void main(String[] args) throws Exception {
        System.out.println(getDataSourceBydbcp().getConnection());
        System.out.println(getDataSourceWithDbcpByProperties().getConnection());
    }
}
