package com.itheima.travel.controller;

import com.itheima.travel.domain.*;
import com.itheima.travel.service.RouteService;
import com.itheima.travel.utils.CartUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * 购物车控制器
 */
@RestController
@RequestMapping(path = "/cart", produces = "application/json;charset=utf-8")
public class CartController extends BaseController{

    @Autowired
    private CartUtils cartUtils;  //购物车的工具类

    @Autowired
    private RouteService routeService;


    /**
     * 添加商品到购物车
     * @param num 商品数量
     * @param rid 线路的主键，做为购物车项的键
     */
    @RequestMapping("/addCart")
    public ResultInfo addCart(Integer num, String rid) {
        //1.从会话域中获取用户对象
        User user = getUserFromSession();
        //2.调用购物车工具类获取当前用户的购物车
        Cart cart = cartUtils.getCartFromRedis(user);
        //3.遍历购物车项，判断当前商品在购物项中是否存在
        HashMap<String, CartItem> cartItemMap = cart.getCartItemMap();
        //通过rid键获取购物车项的值
        CartItem cartItem = cartItemMap.get(rid);
        //如果为空，表示这一项不存在，需要新增一项
        if (cartItem == null) {
            cartItem = new CartItem();
            //获取线路对象
            Route route = routeService.findRoute(Integer.parseInt(rid));
            cartItem.setRoute(route);
            //设置数量
            cartItem.setNum(num);
            //把购物车项放到购车中
            cartItemMap.put(rid, cartItem);
        }
        else {
            //不为空，数量累加
            cartItem.setNum(cartItem.getNum() + num);
        }
        //将购物车放到redis中
        cartUtils.setCartToRedis(user, cart);
        //把购物车项放在会话域中，为了回显购物车的数据
        session.setAttribute("cartItem", cartItem);
        //返回操作结果
        return new ResultInfo(true, "添加到购物车成功");
    }

    /**
     * 显示刚添加的购物项
     */
    @RequestMapping("/showCartItem")
    public ResultInfo showCartItem() {
        //从会话域中获取当前购物车项
        CartItem cartItem = (CartItem) session.getAttribute("cartItem");
        return new ResultInfo(true, cartItem);
    }

    /**
     * 获取购物车中所有的内容
     */
    @RequestMapping("/findAll")
    public ResultInfo findAll() {
        //从会话域中获取当前用户对象
        User user = getUserFromSession();
        //调用工具类获取当前用户的购物车
        Cart cart = cartUtils.getCartFromRedis(user);
        //封装结果返回
        return new ResultInfo(true, cart);
    }

    /**
     * 删除购物车项
     * 注：rid应该使用String类型
     */
    @RequestMapping("/deleteCartItem")
    public Cart deleteCartItem(String rid) {
        //从会话域中获取当前用户对象
        User user = getUserFromSession();
        //调用工具类获取当前用户的购物车
        Cart cart = cartUtils.getCartFromRedis(user);
        //获取所有的购物车项
        HashMap<String, CartItem> cartItemMap = cart.getCartItemMap();
        //通过键删除值
        cartItemMap.remove(rid);
        //更新购物车
        cartUtils.setCartToRedis(user, cart);
        //返回购物车
        return cart;
    }
}
