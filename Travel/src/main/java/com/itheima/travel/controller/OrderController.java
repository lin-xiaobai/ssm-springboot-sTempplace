package com.itheima.travel.controller;

import com.itheima.travel.domain.*;
import com.itheima.travel.service.AddressService;
import com.itheima.travel.service.OrderService;
import com.itheima.travel.utils.CartUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/order",produces = "application/json;charset=utf-8")
public class OrderController extends BaseController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private CartUtils cartUtils;

    @Autowired
    private OrderService orderService;

    /**
     * 商品结算页面
     */
    @RequestMapping("/prepareOrder")
    public ResultInfo prepareOrder() {
        //1.从会话域中获取当前用户的信息
        User user = getUserFromSession();
        //2.调用业务层获取当前用户所有收货地址
        List<Address> addressList = addressService.findByUid(user.getUid());
        //3.从Redis中获取当前用户的购物车对象
        Cart cart = cartUtils.getCartFromRedis(user);
        //4.封装成一个Map对象返回
        HashMap<String, Object> map = new HashMap<>();
        map.put("addressList", addressList);
        map.put("cart", cart);
        //5.返回对象
        return new ResultInfo(true, map);
    }

    /**
     * 下订单
     */
    @RequestMapping("/subOrder")
    public ResultInfo subOrder(Integer aid) {
        //1.从会话域中获取用户对象
        User user = getUserFromSession();
        //2.通过aid得到地址对象
        Address address = addressService.findByAid(aid);
        //3.调用业务层下单，返回订单对象
        Order order = orderService.save(user, address);
        //4.返回下单结果
        return new ResultInfo(true, order);
    }
}
