package JDBC.select;

import java.sql.*;

/**
 * @date 2021/4/22 -19:17
 * 数据库查询结果是以ResultSet类返回的
 */
public class test {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //       1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
//            2.连接数据库
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/class", "root", "root");
//            3.获取数据库操作对象
            stmt = con.createStatement();
//            4.执行sql语句
            String sql = " select id,name,passwork from register";

            rs = stmt.executeQuery(sql);
//            如果数据库有数据的话则返回true，否则返回false
//          处理查询结果集合
//            光标指向的行有数据，则返回true
//            以列的下标形式获取1,2,3代表的是数据库的第几列
//            可以以特定的类型取出，或者都以string类型取出
//            取决与get"Int"中的类型
            while (rs.next()) {
                int id = rs.getInt(1);
                int name = rs.getInt(2);
                String passwork = rs.getString(3);
                System.out.println(id + " " + name + " " + passwork);
            }
//            以列的名字获取
            while (rs.next()) {
                int id = rs.getInt("id");
                int name = rs.getInt("name");
                String passwork = rs.getString("passwork");
                System.out.println(id + " " + name + " " + passwork);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
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
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
