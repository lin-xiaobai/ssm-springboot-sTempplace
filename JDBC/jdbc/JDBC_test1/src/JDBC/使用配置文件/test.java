package JDBC.使用配置文件;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * @date 2021/4/22 -17:51
 * 对数据库文件进行添加
 */
public class test {
    public static void main(String[] args) {
//        使用配置文件绑定属性配置文件
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String user = bundle.getString("user");

        String password = bundle.getString("password");


        Connection con = null;
        Statement stmt = null;
        try {
//        1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
//         2.获取连接
//           con= DriverManager.getConnection("jdbc:mysql://localhost:3306/class","root","root");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/class", "root", "root");
//           3.获取数据库操作对象
            stmt = con.createStatement();
//            4.执行sql语句
            String sql = "insert into register values(null ,'2500','12312')";
            int count = stmt.executeUpdate(sql);
            System.out.println(count);
            System.out.println(count == 1 ? "插入成功" : "插入失败");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
