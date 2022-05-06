package com.spring5.jdbcTemplate;

import java.util.List;

/**
 * @date 2021/7/22 -16:58
 */
public interface dao {
    void add(entity entity);

    void update(entity entity, String id);

    void delete(String id);

    //    查询数据库表有多少条数据
    int selectCount();

    //    根据id字段查询结果，以对象形式返回
    public entity findUserByObject(String id);

    //    查询结果以集合形式
    public List<entity> findUserBylist();

    //    批量添加数据，需要传入一个属性值为实体类的list集合
    public int[] batchAdd(List<Object[]> bacthargs);

    void batchUpdate(List<Object[]> args);

    void batchDelede(List<Object[]> args);
}
