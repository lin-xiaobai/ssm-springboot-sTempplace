package com.itheima.travel.dao;

import com.itheima.travel.domain.OrderItem;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

/**
 * 订单项
 */
public interface OrderItemDao {

    /**
     * 添加订单项
     * @param orderItem
     * @return
     */
    @Insert("INSERT INTO tab_orderitem VALUES  (NULL,#{itemtime},#{state},#{num},#{subtotal},#{rid},#{oid})")
    int save(OrderItem orderItem);

    /**
     * 修改订单项的状态，设置为支付成功1
     */
    @Update("update tab_orderitem set state=1 where oid=#{oid}")
    int updateState(String oid);
}
