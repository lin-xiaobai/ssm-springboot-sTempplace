package com.DBPC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//连接数据库方法
public class DBConnector {
    private final static String URL = "jdbc:mysql://localhost:3306/shop";
    private final static String USER = "root";
    private final static String PASSWORK = "root";
    public static Connection con = null;
    public static Statement stmt = null;
    public static ResultSet rs = null;

    static {
//		注册驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //	定义一个连接数据库的方法
    public static Connection open() throws SQLException {
//		获取连接对象
        return DriverManager.getConnection(URL, USER, PASSWORK);
    }

    //	关闭数据库方法
    public static void close(Connection con, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

	


