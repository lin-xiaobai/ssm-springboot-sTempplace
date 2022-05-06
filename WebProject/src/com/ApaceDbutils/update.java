package com.ApaceDbutils;

import com.DBPC.DBCPUtil;
import org.apache.commons.dbutils.QueryRunner;

/**
 * @date 2021/6/23 -16:24
 * Apace中的dbutils操作
 * 增删改查操作
 * Object...params可变参数，动态参数（可以是单数据，也可以是数组）
 */
public class update {
    public static QueryRunner runner = null;

    static {
        try {
            //            添加数据源
            runner = new QueryRunner(DBCPUtil.getDataSourceWithDbcpByProperties());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //    增
    public static void add(Object... params) throws Exception {
        String sql = "insert into stu(id,name,pwd) values(?,?,?)";
        int count = runner.update(sql, params);
        System.out.println(count);
    }

    public static void delete(Object... params) throws Exception {
        String sql = "delete from stu where id = ?";
        int count = runner.update(sql, params);
        System.out.println(count);
    }

    public static void updat(Object... params) throws Exception {
        String sql = "update stu set name= ? where id= ?";
        int count = runner.update(sql, params);
        System.out.println(count);
    }


    public static void main(String[] args) throws Exception {
//        add(new Object[]{8, "xiaobai", 123});
//        delete(new Object[]{7});
        updat(new Object[]{"zhangsan", 2});

    }
}
