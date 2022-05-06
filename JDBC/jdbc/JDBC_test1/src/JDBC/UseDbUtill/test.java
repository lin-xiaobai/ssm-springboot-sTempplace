package JDBC.UseDbUtill;

import JDBC.DBUtil;

import java.sql.*;

/**
 * @date 2021/4/24 -14:56
 */
public class test {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = DBUtil.open();
            String sql = "insert into t_act values (? ,?)";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, 20);
            stmt.setDouble(2, 30);

            int count = stmt.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.close(con, stmt, rs);
    }
}
