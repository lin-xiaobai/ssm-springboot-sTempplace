package com.itheima.travel.dao;

import com.itheima.travel.domain.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * 订单
 */
public interface OrderDao {

    /**
     * 添加一个订单
     * @param order
     * @return
     */
    @Insert("insert into tab_order values (#{oid},#{ordertime},#{total},#{state},#{address},#{contact},#{telephone},#{uid})")
    int save(Order order);

    /**
     * 修改订单状态
     */
    @Update("update tab_order set state=1 where oid=#{oid}")
    int updateState(String oid);

    /**
     * 通过oid查询一条订单
     */
    @Select("select * from tab_order where oid=#{oid}")
    Order findByOid(String oid);
}
