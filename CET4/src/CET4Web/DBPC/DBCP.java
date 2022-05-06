package CET4Web.DBPC;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;

/**
 * @date 2021/7/5 -23:45
 */
public class DBCP {
    public static DataSource getDataSourceBydbcp() {
//		 获取dbcp方式的ds对象
        BasicDataSource dbcp = new BasicDataSource();
//     注册驱动
        dbcp.setDriverClassName("com.mysql.jdbc.Driver");
//     设置连接数据库的url
        dbcp.setUrl("jdbc:mysql://localhost:3306/etc4");
////     数据库的用户名
        dbcp.setUsername("root");
////     数据库密码
        dbcp.setPassword("root");
////     连接池中的连接数量
        dbcp.setInitialSize(200);
////   连接池中处于活跃状态的数据库连接的最大数量
        dbcp.setMaxActive(10);
        return dbcp;
    }
}
