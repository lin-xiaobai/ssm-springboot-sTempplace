package com.JDBCutil;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @date 2021/6/24 -16:58
 * 事务例子：转账
 * 一个connection对象相当于一个事务
 * <p>
 * 一个业务service中多个dao操作 应该包含在一个事务中
 * <p>
 * 事务流程：开启事务（将自动提交-->手动提交) ->进行各种DML(增删改查）
 * 正常->将刚才所有的DML全部提交（全部成功）
 * 失败（异常），将刚才所有的DML全部回滚（全部失败）
 */
public class JDBCutil {
    //    利用泛型来约束对象。泛型是连接对象
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    /**
     * 先获取ThreadLocal中的连接对象，如果没有连接对象则进行创建连接对象
     * 第二次从ThreadLocal中获取连接对象时，ThreadLocal中有连接对象存在，则直接获取变量
     */
    public static Connection getConnection() {
//        获取链接
        //  threadLocal.get()方法是从threadLocal中获取变量（副本）
        //如果 ThreadLocal中变量（副本）不够，会自动创建副本
        Connection conn = threadLocal.get();
//        conn 为空则表示第一次获取
        if (conn == null) {
            try {
                //从数据源中获取连接对象  ds--->conn
//                将数据源链接放到connection对象中
                conn = DataSourceUtil.getDataSourceWithC3P0().getConnection();
//            将链接放到ThreadLocal中
//     threadLocal.set()给ThreadLocal中存放一个变量
                threadLocal.set(conn);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }


    //开启事务
    public static void beginTransaction() {
//        获取连接，从ThreadLocal中获取链接
        Connection conn = getConnection();
        try {
            if (conn != null)
                //开启事务
                conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }

//
    }

    //正常。提交事务
    public static void commitTransaction() {
        //获取链接对象，从threadlocal对象中获取副本
        Connection conn = getConnection();
        //所有的对象.方法()  全部排空，不然会报空指针异常
        try {
            if (conn != null) {
                conn.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //失败。回滚事务。
    public static void rollbackTransaction() {
//        获取链接对象，从threadlocal对象中获取副本
        Connection conn = getConnection();
        //所有的对象.方法()  全部排空，不然会报空指针异常
        if (conn != null) {
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static void close() {
        Connection conn = getConnection();
        try {
//                关闭与数据源的连接
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//            清空数据库连接池
        threadLocal.remove();
    }


}
