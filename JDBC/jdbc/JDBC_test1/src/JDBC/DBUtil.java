package JDBC;

import java.sql.*;

/**
 * @date 2021/4/24 -14:46
 * JDBC工具类，简化JDBC编程
 */
public class DBUtil {
    /**
     * 工具类的构造方法都是私自的
     * 因为工具类当中的方法都是静态的，不需要new对象，直接采用类名调用
     */
    private DBUtil() {
    }

    //    静态代码块在类加载时执行，并且只执行一次
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接对象
     *
     * @throws SQLException
     * @return连接对象
     */
    public static Connection open() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
    }

    /**
     * 关闭资源
     *
     * @param con连接对象
     * @param stmt数据库操作对象
     * @param rs结果集
     */
    public static void close(Connection con, Statement stmt, ResultSet rs) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
