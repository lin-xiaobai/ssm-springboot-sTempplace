package JDBC.sql注入;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @date 2021/4/23 -16:27
 * 当前程序存在的问题
 * 账号：sqle
 * 密码：sqle' or '1'='1
 * 登录成功
 * 账号在数据库是找不到的
 * 这种现象称为sql注入
 * <p>
 * 导致SQL注入的根本原因是：
 * 用户输入的信息中含有sql语句的关键字，并且这些关键字参与sql语句的编译过程
 * 导致sql语句的原意被扭曲，进而达到sql注入
 */
public class sqlTest {
    public static void main(String[] args) {
        Map<String, String> userLoginInfo = initUI();
        boolean loginSuccess = login(userLoginInfo);
        System.out.println(loginSuccess == true ? "登录成功" : "登录失败");
    }

    /**
     * 登录界面
     * 包括登录账号和密码
     *
     * @return
     */
    public static Map<String, String> initUI() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入账号和密码");
        String loginName = sc.nextLine();
        ;
        String loginPwd = sc.nextLine();
//        创建一个map集合
        Map<String, String> userLoginInfo = new HashMap<>();
        userLoginInfo.put("loginName", loginName);
        userLoginInfo.put("loginPwd", loginPwd);
        return userLoginInfo;
    }

    public static boolean login(Map<String, String> userLoginInfo) {
//        单独定义变量
        String loginName = userLoginInfo.get("loginName");
        String loginPwd = userLoginInfo.get("loginPwd");
//        打标记
        boolean flae = false;
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
//
        try {
//            1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
//            2.连接数据库
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "root");
//           3.创建数据库对象
            stmt = con.createStatement();
//            4.执行sql语句
            String sql = "select * from login where name ='" + loginName + "' and password='" + loginPwd + "'";
//            以上正好完成了sql语句的拼接，以下代码的含义是，发送sql语句给DBMS(数据库操作系统)，DBMS进行sql编译
//            正好将用户提供的“非法信息”编译进去，导致了原sql语句的含义被扭曲了
            rs = stmt.executeQuery(sql);
//            5.处理结果集合
            if (rs.next()) {
                flae = true;
            }
        } catch (Exception e) {
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
//        返回变量
        return flae;
    }

}
