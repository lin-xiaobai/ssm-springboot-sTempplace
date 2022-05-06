package com.itheima.travel.service;

import com.itheima.travel.domain.Address;
import com.itheima.travel.domain.Order;
import com.itheima.travel.domain.ResultInfo;
import com.itheima.travel.domain.User;

import java.util.Map;

/**
 * 订单业务层
 */
public interface OrderService {

    /**
     * 某个用户下订单
     * @param user 用户对象
     * @param address 收货地址
     * @return 订单对象
     */
    Order save(User user, Address address);

    /**
     * 根据支付结果修改订单状态
     */
    ResultInfo updateState(Map<String,String> params);

    /**
     * 判断指定的订单是否支付
     */
    boolean isPaid(String oid);
}
