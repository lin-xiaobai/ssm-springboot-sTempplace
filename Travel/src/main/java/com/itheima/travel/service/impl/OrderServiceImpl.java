package com.itheima.travel.service.impl;

import com.itheima.travel.dao.OrderDao;
import com.itheima.travel.dao.OrderItemDao;
import com.itheima.travel.domain.*;
import com.itheima.travel.service.OrderService;
import com.itheima.travel.utils.CartUtils;
import com.itheima.travel.utils.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;  //订单

    @Autowired
    private OrderItemDao orderItemDao;  //订单项

    @Autowired
    private CartUtils cartUtils;

    /**
     * 某个用户下订单
     * @param user 用户对象
     * @param address 收货地址
     * @return 订单对象
     * 因为有多次操作数据库，所以要开启事务
     */
    @Override
    @Transactional
    public Order save(User user, Address address) {
        //1.通过用户得到购物车对象
        Cart cart = cartUtils.getCartFromRedis(user);
        //2.创建订单对象，设置基础数据
        Order order = new Order();
        order.setUid(user.getUid());  //订单用户
        order.setTotal(cart.getCartTotal());  //订单总金额
        order.setOrdertime(new Date());  //下单的时间，设置为现在
        order.setTelephone(address.getTelephone());  //设置联系电话
        order.setState(0);  //订单状态：1表示已经支付 0 表示未支付
        order.setOid(UuidUtils.simpleUuid());  //订单编号，随机生成一个32位16进制字符串
        order.setContact(address.getContact());  //联系人
        order.setAddress(address.getAddress());  //收货地址
        //添加订单到数据库中
        orderDao.save(order);

        //3.创建订单项，从购物车中获取每一个购物项
        HashMap<String, CartItem> cartItemMap = cart.getCartItemMap();
        //遍历Map，每一项要创建成一个订单项
        cartItemMap.forEach((rid, cartItem) -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setSubtotal(cartItem.getSubTotal());  //金额
            orderItem.setItemtime(new Date());  //下单时间
            orderItem.setRid(Integer.valueOf(rid));  //线路的rid
            orderItem.setOid(order.getOid());  //订单编号
            orderItem.setState(0);   //支付状态为0
            orderItem.setNum(cartItem.getNum());  //购买数量
            //写到数据库中
            orderItemDao.save(orderItem);
        });

        //4.清空购物车
        cartUtils.removeCart(user);
        //5.返回订单对象
        return order;
    }

    /**
     * 根据支付结果修改订单状态
     * @param params
     */
    @Override
    @Transactional  //开启事务
    public ResultInfo updateState(Map<String, String> params) {
        //获取订单号
        String outTradeNo = params.get("out_trade_no");
        //获取支付结果
        String resultCode = params.get("result_code");
        //判断是否支付成功
        if ("SUCCESS".equals(resultCode)) {
            //支付成功，修改订单状态为1
            orderDao.updateState(outTradeNo);
            orderItemDao.updateState(outTradeNo);
            //返回更新状态结果
            return new ResultInfo(true, "支付成功");
        }
        return new ResultInfo(false, "支付失败");
    }

    /**
     * 判断指定的订单是否支付
     * @param oid
     */
    @Override
    public boolean isPaid(String oid) {
        Order order = orderDao.findByOid(oid);
        //如果为1，返回true
        return order.getState() == 1;
    }
}
