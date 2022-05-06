package com.spring5.jdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * @date 2021/7/22 -16:58
 */
@Service //创建对象注解
public class service {
    //    注入dao
    @Autowired//根据属性类型进行自动装配
//    接口
    private dao dao;

    //    增加
    public void addUser(entity user) {
        dao.add(user);
    }

    //    改
    public void updateuser(entity entity, String id) {
        dao.update(entity, id);
    }

    //    删
    public void deleteUser(String id) {
        dao.delete(id);
    }

    public void selectCount() {
        System.out.println(dao.selectCount());
    }

    //    根据id查数据表
    public void findUserByid(String id) {
        System.out.println(dao.findUserByObject(id));
    }

    //    /    查询结果以集合形式
    public void finUSerByList() {
        List<entity> list = dao.findUserBylist();
        System.out.println(list);
    }

    //    批量添加
    public void batchAdd(List<Object[]> args) {
        int[] counts = dao.batchAdd(args);
//       遍历int数组
        System.out.println(Arrays.toString(counts));

    }

    //    批量修改
    public void batchUpdate(List<Object[]> args) {
        dao.batchUpdate(args);
    }

    //    批量删除
    public void batchDelde(List<Object[]> args) {
        dao.batchDelede(args);
    }
}
