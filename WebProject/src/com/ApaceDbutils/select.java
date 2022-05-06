package com.ApaceDbutils;

import com.DBPC.DBCPUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.*;

import java.util.List;
import java.util.Map;

/**
 * @date 2021/6/21 -20:57
 * 使用apace下的dbutils的查询功能
 * 需要ResultSetHandler接口 里面有许多实现类 ，一种实现类对应于一种 不同的查询结果类型
 * select*from student
 */
public class select {
    //查询单行数据，返回类型是object[]数组，返回结果集的第一行数据
    public static void testArrayHandler() throws Exception {
        //有参是自动提交事务  无参加手动提交事务
        //其中的一个形参是数据源DataSource 等等

//        自动提交事务
        QueryRunner runner = new QueryRunner(DBCPUtil.getDataSourceWithDbcpByProperties());
        String sql = "select * from stu where id >?";
//        方法的第一个参数是sql语句，第二个参数是返回集，第三个是给占位符（？）赋值
//        1.ArrayHandler()：返回结果集中的第一行数据，并用object[]
//        ArrayHandler()方法实现ResultSetHandler接口
        //代码意思：查询id大于0的数据，返回结果集中的第一行数据，并用object数组接收
        Object[] student = runner.query(sql, new ArrayHandler(), 0);
        //遍历循环数组元素
        for (int i = 0; i < student.length; i++) {
            System.out.println(student[i]);
        }
    }

    //    查询多行数据,使用list<object[]>接收
    public static void testArrayListHandler() throws Exception {
        //自动提交事务
        QueryRunner runner = new QueryRunner(DBCPUtil.getDataSourceWithDbcpByProperties());
        String sql = "select * from stu where id >?";
//       2.ArrayListHandler()：返回结果集中的全部数据，并用list<object[]>接收
        List<Object[]> students = runner.query(sql, new ArrayListHandler(), 0);
        for (Object[] studnet : students) {
            System.out.println(studnet[0] + "," + studnet[1]);
        }
    }

    //查询单行数据，将查到的数据封装到对象中,使用BeanHandler<bean>(bean.class)接收
    public static void testBeanHandler() throws Exception {
//        自动提交事务
        QueryRunner runner = new QueryRunner(DBCPUtil.getDataSourceWithDbcpByProperties());
        String sql = "select * from stu where id >?";
//        指定泛型（bean类型） 使用泛型约束
//        反射会通过无参构造创建对象
//        3.BeanHandler<bean>(bean.class)将查询到的结果以对象的形式返回
        bean stu = runner.query(sql, new BeanHandler<bean>(bean.class), 1);
        System.out.println(stu);
    }

    //查询多行数据，将查询的多行数据存放到多个对象中，存放到List<student>中
    public static void testBeanListHandler() throws Exception {
//        自动提交事务
        QueryRunner runner = new QueryRunner(DBCPUtil.getDataSourceWithDbcpByProperties());
        String sql = "select * from stu where id > ?";
// 4.BeanListHandler<bean>(bean.class)将查询到的结果以集合list的方式返回，list集合使用泛型约束
        List<bean> students = runner.query(sql, new BeanListHandler<bean>(bean.class), 0);
//       遍历list集合
        for (bean student : students) {
            System.out.println(student);
        }
    }

    //查询多行数据，将查询的多行数据存放到多个对象中，存放到中Map<student>中
    public static void testBeanMapHandler() throws Exception {
        //自动提交
        QueryRunner runner = new QueryRunner(DBCPUtil.getDataSourceWithDbcpByProperties());
        String sql = "select * from stu where id > ?";
//BeanMapHandler<Integer,bean>(bean.class)的返回值是map集合类型
//     返回值类型例如：1 ww  456
        Map<Integer, bean> students = runner.query(sql, new BeanMapHandler<Integer, bean>(bean.class), "id");

        //通过Map.Entry<Integer,bean>，然后使用entry,getKey()获取到键，通过entry.getValue()获取到值
//        entrySet()是java中键-值对的集合，通过map.entrySet()得到键-值对的集合
        for (Map.Entry<Integer, bean> entry : students.entrySet()) {
            System.out.println(entry.getKey() + "," + entry.getValue());
        }

//        bean stu=students.get(2);
//        System.out.println(stu.getId()+","+stu.getName()+","+stu.getPwd());
    }

    //查询单行数据，存放查询到的数据放到map集合中
    public static void testMapHandler() throws Exception {
//        自动提交事务
        QueryRunner runner = new QueryRunner(DBCPUtil.getDataSourceWithDbcpByProperties());
        String sql = "select * from stu where id> ?";
//        map中存入的值是{id=0,name=zs} {String,object}
//        new MapHandler()中不需要泛型，实例化不需要泛型，但是需要在前指定泛型
        Map<String, Object> student = runner.query(sql, new MapHandler(), 0);
//       直接输出map集合
        System.out.println(student);
    }

    //查询多行数据，存放查询到的数据放到map集合中，返回结果集中的多行数据
    public static void testMapListHandler() throws Exception {
        //自动提交事务
        QueryRunner runner = new QueryRunner(DBCPUtil.getDataSourceWithDbcpByProperties());
        String sql = "select * from stu where id> ?";
        //     map中存入的值是{id=0,name=zs} {id=1,name=ww}  属于{String,object}
        List<Map<String, Object>> students = runner.query(sql, new MapListHandler(), 0);
        System.out.println(students);
//        返回一个map集合
        for (Map<String, Object> stu : students) {
            System.out.println(stu);
        }
//        遍历循环List<Map<String,Object>>
//        返回各个字段的key和value
//        for (Map<String,Object> map:students) {
//            for (String key:map.keySet()) {
//                System.out.println(key+","+map.get(key));
//            }
//        }
    }

    //查询多行数据，存放查询到的数据放到map集合中，返回结果集中的多行数据
//    返回结果集是Map(string ，map(string,object)) 就是map类型里面再套一个map类型
    public static void testKeyedHandler() throws Exception {
//        自动提交事务
        QueryRunner runner = new QueryRunner(DBCPUtil.getDataSourceWithDbcpByProperties());
        String sql = "select * from stu where id> ?";
//返回的类型是{字段名={map集合} ，KeyedHandler<String>("name")传入的形参是数据段的字段名（id或者names……）
//        数据库的字段名类型传到后端是String类型
        Map<String, Map<String, Object>> students = runner.query(sql, new KeyedHandler<String>("name"), 0);
// 返回的内容是{ll={id=2, name=ll, pwd=789}, ww={id=1, name=ww, pwd=456}}
        System.out.println(students);
    }

    //查询多行数据中的某一列，将查到的结果放在list集合中
    public static void testColumnListHandler() throws Exception {
        //自动提交事务
        QueryRunner runner = new QueryRunner(DBCPUtil.getDataSourceWithDbcpByProperties());
        String sql = "select * from stu where id> ?";
// ColumnListHandler<String>("name") 中的泛型是指定数据某一列的数据类型，传参是要查询的哪一列的字段名
//       返回值类型是list集合
        List<String> names = runner.query(sql, new ColumnListHandler<String>("name"), 0);
        for (String name : names) {
            System.out.println(name);
        }
    }

    //    查询单值数据，
//    查询id大于0的人有多少个,例如查询id为2的人有多少
    public static void testScalarHandler() throws Exception {
        QueryRunner runner = new QueryRunner(DBCPUtil.getDataSourceWithDbcpByProperties());
        String sql = "select count(*) from stu where id>?";
        //查询id大于0的人有多少个？泛型指定Long对象
        Long num = runner.query(sql, new ScalarHandler<Long>(), 0);
        System.out.println(num);
    }


    public static void main(String[] args) throws Exception {
//        select.testArrayHandler();
//        select.testArrayListHandler();
//        select.testBeanHandler();
//        select.testArrayListHandler();
//        select.testBeanMapHandler();
//        select.testMapHandler();
//        select.testMapListHandler();
//        select.testKeyedHandler();
//        select.testColumnListHandler();
        select.testScalarHandler();
    }
}
