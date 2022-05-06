package com.spring5.jdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

/**
 * @date 2021/7/22 -16:58
 */
@Repository//创建对象注解
public class daoImpl implements dao {
    //    注入jdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //数据库增的操作
    @Override
    public void add(entity user) {
//        直接调用JdbcTemplate中的updated方法
        String sql = "insert into t_user value(?,?,?)";
        Object[] obj = {user.getId(), user.getName(), user.getStatus()};
//        第一个参数为sql语句，第二个参数为占位符的值
        int result = jdbcTemplate.update(sql, obj);
        System.out.println(result);
    }

    //    数据库改操作
    @Override
    public void update(entity entity, String id) {

        String sql = "update t_user set id=?, name=?,ustatus=? where id=?";
        Object[] objects = {entity.getId(), entity.getName(), entity.getStatus(), id};
        int result = jdbcTemplate.update(sql, objects);
        System.out.println(result);
    }

    @Override
    public void delete(String id) {
        String sql = "delete from t_user where id=?";
        Object[] obj = {id};
        int num = jdbcTemplate.update(sql, obj);
        System.out.println(num);
    }

    //    查看数据表中有多少条数据
    @Override
    public int selectCount() {
        String sql = "select count(*) from t_user";
//        第一个参数：sql语句
//        第二个参数：返回类型Clas
        String count = jdbcTemplate.queryForObject(sql, String.class);
        return Integer.valueOf(count);
    }


    //    根据id字段查询结果，以对象形式返回
    @Override
    public entity findUserByObject(String id) {
        String sql = "select * from t_user where id=?";
//        第一个参数为SQL语句 第二个参数：RowMapper 接口，针对返回不同类型数据，使用这个接口里面实现类完成数据封装
//        第三个参数为sql语句值
//        BeanPropertyRowMapper是RowMapper 接口的子接口，泛型为entity，后面接他的class文件
        entity entity = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<entity>(entity.class), id);

        return entity;
    }

    //    查询结果以集合形式
//    第一个参数为SQL语句 第二个参数：RowMapper 接口，针对返回不同类型数据，使用这个接口里面实现类完成数据封装
//        第三个参数为sql语句值
//        BeanPropertyRowMapper是RowMapper 接口的子接口，泛型为entity，后面接他的class文件
    @Override
    public List<entity> findUserBylist() {
        String sql = "select * from t_user";
        List<entity> entities = jdbcTemplate.query(sql, new BeanPropertyRowMapper<entity>(entity.class));
        return entities;
    }

    //批量添加
    @Override
    public int[] batchAdd(List<Object[]> bacthargs) {

        String sql = "insert into t_user value(?,?,?)";
//        底层：遍历list集合，因为元素是一个数组，将数组中数据放置到sql语句中的？值中。
        int[] coounts = jdbcTemplate.batchUpdate(sql, bacthargs);
        return coounts;
    }

    //批量修改
    @Override
    public void batchUpdate(List<Object[]> args) {
        String sql = "update t_user set id=?, name=?,ustatus=? where id=?";
        int[] count = jdbcTemplate.batchUpdate(sql, args);
        System.out.println(count.length);
    }

    //批量删除
    @Override
    public void batchDelede(List<Object[]> args) {
        String sql = "delete from  t_user where id=?";
        int[] count = jdbcTemplate.batchUpdate(sql, args);
        System.out.println(Arrays.toString(count));
    }
}
