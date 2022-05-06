package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @date 2021/4/23 -19:02
 * 对数据库进行增删改
 */
public class updateAndInsertAndDelete {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        System.out.print("请输入操作的账号");
//        String loginName=sc.nextLine();
//        System.out.print("密码");
//        String loginPwd=sc.nextLine();

//        System.out.println("请输入要操作的id");
//        int id=sc.nextInt();
//        System.out.println("请输入要操作的账号");
//        String updateName=sc.next();
//        System.out.println("密码");
//        String updatePwd=sc.next();

        System.out.println("请输入要删除的名称");
        String deletName = sc.next();

        Connection con = null;
        PreparedStatement ps = null;
        try {
            // 1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "root");
//            3.获取预编译的数据库操作对象
////            对数据表进行增加用户的账号和密码
//            String sql="insert into login values(null,?,?)";
//            ps=con.prepareStatement(sql);
//            ps.setString(1,loginName);
//            ps.setString(2,loginPwd);

//            对数据表进行修改用户的账号和密码
//            String sql="update login set name =?, password =? where id=?";
//            String sql="update login set name =?,password=? where id=?";
//            ps=con.prepareStatement(sql);
//            ps.setString(1,updateName);
//            ps.setString(2,updatePwd);
//            ps.setInt(3,id);

//            对数据表进行删除用户的账号和密码
//            String sql="update login set name =?, password =? where id=?";
            String sql = "delete from login  where name =?";
            ps = con.prepareStatement(sql);
            ps.setString(1, deletName);

//            4.执行sql
            int count = ps.executeUpdate();
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
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
