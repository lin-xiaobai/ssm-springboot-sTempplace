package JDBC.sql注入;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @date 2021/4/23 -17:38
 * 解决sql注入的问题
 * 1.用户提供的信息不参与sql语句的编译过程，就解决了
 * 即使用户提供的信息中含有Sql语句的关键字，但是没有参与编译，就不起作用
 * 要想用户信息不参与sql语句的编译，那么必须使用java.sql.preparedStatement
 * preparedStatement接口继承了java.sql.Statement
 * preparedStatement是属于预编译的数据库操作对象
 * preparedstatement的原理是：预先对sql语句的框架进行编译，然后再给sql语句传“值”
 * <p>
 * 解决sql注入的关键是：
 * 用户提供的信息中即使含有sql语句的关键字，但是这些关键字并没有参与编译，不起作用
 * <p>
 * 2.对比Statement和PreparedStatement（传入的是一个值）
 * statement存在sql注入问题，preparedStatement解决sql注入问题
 * statement是编译一次执行一次。preparedStatement是编译一次，可执行n次
 * preparedStatement会在编译阶段做类型的安全检查。
 * <p>
 * 3.什么情况下必须使用Statement？
 * statement支持sql注入，业务需求是需要进行sql语句拼接的，必须使用Statement
 * 例如：京东的价格降序和升序
 */
public class solveSql {
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
        PreparedStatement psStmt = null;//这里使用预编译的数据库对象
        ResultSet rs = null;
//
        try {
//            1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
//            2.连接数据库
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "root");
//            3.获取预编译的数据库操作对象
//            将值改为占用符（？）
//            sql语句的框子，其中一个？，表示一个占位符，一个？将来接受预先“值”，
//            占位符不能使用单引号，
            String sql = "select * from login where name = ? and password= ? ";
//            程序执行到这里，会发送sql语句给DBMS，然后DBMS进行sql语句的预先编译
            psStmt = con.prepareStatement(sql);
//            给占位符？传值（第一个问好下标是1，第二个问好下标是2，jdbc的下标都是从1开始的
            psStmt.setString(1, loginName);
            psStmt.setString(2, loginPwd);
//            4.执行sql语句
            rs = psStmt.executeQuery();
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
            if (psStmt != null) {
                try {
                    psStmt.close();
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
