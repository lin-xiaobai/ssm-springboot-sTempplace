package JDBC.事务机制;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @date 2021/4/24 -14:23
 */
public class 手动提交机制 {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
//            开启事务(将自动提交机制修改为手动提交）
            con.setAutoCommit(false);
//            更新数据
            String sql = "update t_act set balance=? where actno=?";
            ps = con.prepareStatement(sql);

            ps.setDouble(1, 50);
            ps.setInt(2, 500);
            int count = ps.executeUpdate();

//            这里执行一个异常，查看数据库的情况
            String sc = null;
            sc.toString();


//            上面报异常，下面的语句块执行不到

            ps.setDouble(1, 25);
            ps.setInt(2, 520);
            count += ps.executeUpdate();
            System.out.println(count == 2 ? "转账成功" : "转账失败");
//            程序能够走到这里说明以上程序没有异常，事务结束，手动提交数据
            con.commit();//提交事务
        } catch (Exception e) {
//            回滚事务
            if (con != null) {
                try {
//                    恢复原数据
                    con.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
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
