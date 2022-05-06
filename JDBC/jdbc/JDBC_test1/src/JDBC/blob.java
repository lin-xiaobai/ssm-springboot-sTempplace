package JDBC;

import java.io.*;
import java.sql.*;

/**
 * @date 2021/5/11 -19:59
 * blob：二进制（万能流）  字节流 （inputstream 和outputstream）
 * 将二进制文件存储到数据库中
 */
public class blob {
    public static void blobDemo() {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myblob", "root", "root");
            String sql = "insert into myblob values(null,?)";
            ps = con.prepareStatement(sql);
            File file = new File("E:\\文本.txt");
            InputStream in = new FileInputStream(file);
            ps.setBinaryStream(1, in, file.length());
            int count = ps.executeUpdate();
            if (count > 0) {
                System.out.println("操作成功");
            }
            in.close();
        } catch (ClassNotFoundException | SQLException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
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

    public static void outBlob() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myblob", "root", "root");
//            String sql="select blob from myblob where id=?";
            String sql = "select Mblob from myblob where id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, 1);
            rs = ps.executeQuery();
            if (rs.next()) {
                InputStream in = rs.getBinaryStream("Mblob");
                OutputStream out = new FileOutputStream("E:\\name.TXT");

                //缓冲区
                byte[] bytes = new byte[100];
                int len = -1;
                while ((len = in.read(bytes)) != -1) {
                    out.write(bytes, 0, len);
                }
                in.close();
                out.close();
            }
            System.out.println("成功");
        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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

    public static void main(String[] args) {
//        blobDemo();
        outBlob();
    }
}
