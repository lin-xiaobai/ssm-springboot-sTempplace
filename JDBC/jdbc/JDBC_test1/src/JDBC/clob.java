package JDBC;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

/**
 * @date 2021/5/10 -20:30
 * 通过jdbc存储大文本数据（小说）CLOB
 * 只能存储文本内容
 * 设置CLOB类型
 */
public class clob {
    public static void clobDemo() {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mynovel", "root", "root");
            String sql = "insert into novel values(null ,?)";
            pstmt = con.prepareStatement(sql);

            File file = new File("E:\\name.txt");
            InputStream in = new FileInputStream(file);
            //读文件一utf-8格式
            Reader reader = new InputStreamReader(in, "utf-8");
            pstmt.setCharacterStream(1, reader, file.length());
            int count = pstmt.executeUpdate();

            if (count > 0) System.out.println("操作成功");
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void clobReaderDome() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mynovel", "root", "root");
            String sql = "select text from novel where id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, 1);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                Reader reader = rs.getCharacterStream("text");
                File file = new File("E:\\文本.txt");
                Writer writer = new FileWriter(file);

                char[] chs = new char[100];
                int len = -1;
                while ((len = reader.read(chs)) != -1) {
                    writer.write(chs, 0, len);
                }
                System.out.println("成功");
                reader.close();
                writer.close();
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    public static void main(String[] args) {
//        clobDemo();
        clobReaderDome();
    }
}

