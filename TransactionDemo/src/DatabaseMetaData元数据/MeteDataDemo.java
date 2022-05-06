package DatabaseMetaData元数据;

import java.sql.*;

/**
 * @date 2021/6/25 -17:59
 * 获取数据库元信息
 * 元信息：怎么样描述数据
 * <p>
 * 例如
 * 数据库字段名
 */
public class MeteDataDemo {
    private static final String drivename = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://127.0.0.1/test";
    private static final String user = "root";
    private static final String pwd = "root";
    static Connection con = null;
    static PreparedStatement stmt = null;
    static ResultSet rs = null;

    //获取数据库的元信息
    public static void getDataBaseMeteData() {
        try {
            Class.forName(drivename);
            con = DriverManager.getConnection(url, user, pwd);
            //获取数据库的元信息
            DatabaseMetaData metaData = con.getMetaData();
            System.out.println("驱动名" + metaData.getDriverName());
            System.out.println("数据库版本号" + metaData.getDriverVersion());
            System.out.println("数据名" + metaData.getDatabaseProductName());
            System.out.println("数据库链接" + metaData.getURL());
            System.out.println("数据库用户名" + metaData.getUserName());
            System.out.println("用户名最长字段" + metaData.getMaxUserNameLength());
            System.out.println("----------------------------------------------");


            //获取指定表的主键信息
//           第一个参数为null，第二个参数为数据库名称，第三次参数为数据表
            //返回值是ResultSet
            ResultSet rs = metaData.getPrimaryKeys(null, metaData.getDatabaseProductName(), "stu");
            while (rs.next()) {
//                参数1是表类名  2是表模式  3是表名称  4是列名称(主键的字段名名称）
//                6是主键的约束名称
                Object tablename = rs.getObject(1);
                System.out.println("表类名" + tablename);
                Object module = rs.getObject(2);
                System.out.println("表模式" + module);
                Object tableNamer = rs.getObject(3);
                System.out.println("表名为" + tableNamer);
                Object columnName = rs.getObject(4);
                System.out.println("列名称为" + columnName);
                Object pkey = rs.getObject(5);
                System.out.println("主键在表的第几个字段名:" + pkey);
                Object name = rs.getObject(6);
                System.out.println("主键的约束名称" + name);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("----------------------------------------------");
    }


    /**
     * 获取数据库的参数元数据,
     */
    public static void getParameterMeteData() {
        try {
            Class.forName(drivename);
            con = DriverManager.getConnection(url + "?generateSimpleParameterMetadata=true", user, pwd);
            String sql = "select * from stu where id=? and name=? and pwd=?";
            stmt = con.prepareStatement(sql);
            //获取参数元数据
            ParameterMetaData metaData = stmt.getParameterMetaData();
//          获取sql语句中占位符的个数
            int count = metaData.getParameterCount();
            System.out.println("总共" + count + "条占位符信息");
//          获取第param个的参数的类型
            for (int i = 1; i <= count; i++) {
                String parameter = metaData.getParameterTypeName(i);
                System.out.println("第" + i + "个占位符参数的类型名" + parameter);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 获取数据库的结果集元数据,
     */
    public static void getResultSetMeteData() {
        try {
            Class.forName(drivename);
            con = DriverManager.getConnection(url, user, pwd);
            String sql = "select * from stu";
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
//           获取结果集合中列的数量
            int count = metaData.getColumnCount();
            System.out.println("结果集合中列的数量" + count);
////            获取结果集中，第column列的名称
//            for (int i = 1; i <=count ; i++) {
//                String name=metaData.getColumnName(i);
//                System.out.println("结果集中第"+i+"列的名称"+name);
//                String typeName=metaData.getColumnTypeName(i);
//                System.out.println("结果集中第"+i+"列的类型"+typeName);
//            }
            for (int i = 1; i <= count; i++) {
                String name = metaData.getColumnName(i);
                String typeName = metaData.getColumnTypeName(i);

                System.out.println(name + "\t" + typeName + "\t");
            }
            System.out.println();
            while (rs.next()) {
                for (int i = 1; i < count; i++) {
                    System.out.print(rs.getObject(i) + "\t");
                }
                System.out.println();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null && stmt != null && rs != null) {
                try {
                    con.close();
                    stmt.close();
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }


    public static void main(String[] args) {
//        getDataBaseMeteData();
//        getParameterMeteData();
        getResultSetMeteData();
    }
}
