package JDBC.事务机制;

import java.sql.*;

/**
 * @date 2021/4/24 -13:54
 * <p>
 * JDBC事务机制：
 * 1.JDBC的事务是自动提交的，什么是自动提交？
 * 只要执行一条DML(SQL语句)，则自动提交一次。这是JDBC默认的事务行为。
 * <p>
 * 但是在实际的业务中，通常都是N条DML语句共同联合才能的，
 * 必须保证他们这些DML语句在同一个事务中同时成功或者失败。
 */
public class 自动提交机制 {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement ps = null;
//        ResultSet rs=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");

//            添加数据到数据表
//            String sql="insert into t_act values(?,?)";
//            ps=con.prepareStatement(sql);
//            ps.setInt(1,520);
//            ps.setDouble(2,5000.00);
//            int count=ps.executeUpdate();
//            System.out.println(count);
////           这里执行一个异常，查看数据库的情况
//            String sc=null;
//            sc.toString();
//
////            多条sql语句共同处理
//            ps=con.prepareStatement(sql);
//            ps.setInt(1,500);
//            ps.setDouble(2,8000.00);
//            count+=ps.executeUpdate();
//            System.out.println(count);

//            更新数据
            String sql = "update t_act set balance=? where actno=?";
            ps = con.prepareStatement(sql);
            ps.setDouble(1, 501);
            ps.setInt(2, 520);
            int count = ps.executeUpdate();
            System.out.println(count);

//            这里执行一个异常，查看数据库的情况
            String sc = null;
            sc.toString();
//            上面报异常，下面的语句块执行不到
            ps = con.prepareStatement(sql);
            ps.setDouble(1, 250);
            ps.setInt(2, 500);
            count += ps.executeUpdate();
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
