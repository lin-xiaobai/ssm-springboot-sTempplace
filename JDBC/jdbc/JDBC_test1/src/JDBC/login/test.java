package JDBC.login;

import java.sql.*;
import java.util.Scanner;

/**
 * @date 2021/4/22 -19:39
 */
public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的账号和密码");
        int user = sc.nextInt();
        String ps = sc.next();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/class", "root", "root");
            stmt = con.createStatement();
            String sql = " select * from register where name ='" + user + "' and passwork ='" + ps + "'";
            rs = stmt.executeQuery(sql);

//            while (rs.next()){
//                int id=rs.getInt(1);
//                int name=rs.getInt(2);
//                String passwork=rs.getString(3);
////                System.out.println(id+" "+name+" "+passwork);
//            }
            if (rs.next()) {
                System.out.println("密码正确");
            } else {
                System.out.println("密码错误");
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
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
