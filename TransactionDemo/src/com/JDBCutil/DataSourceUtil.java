package com.JDBCutil;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import sun.applet.Main;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.SQLException;

/**
 * @date 2021/6/24 -17:18
 * 获取数据源
 */
public class DataSourceUtil {
    public static DataSource getDataSourceWithC3P0() {
        ComboPooledDataSource c3p0 = new ComboPooledDataSource();
        try {
            c3p0.setDriverClass("com.mysql.jdbc.Driver");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        c3p0.setJdbcUrl("jdbc:mysql://127.0.0.1/test");
        c3p0.setUser("root");
        c3p0.setPassword("root");
        c3p0.setInitialPoolSize(200);
        return c3p0;
    }


}
