package com.itheima.travel.utils;

import com.itheima.travel.domain.Cart;
import com.itheima.travel.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

/**
 * 购物车工具类，由Spring管理，注：不能使用静态方法
 */
@Component
public class CartUtils {

    @Autowired
    private RedisTemplate<String, Cart> redisTemplate;

    /**
     * 设置购物车对象
     * @param user 用户
     * @param cart 购物车
     */
    public void setCartToRedis(User user, Cart cart) {
        ValueOperations<String, Cart> ops = redisTemplate.opsForValue();
        ops.set("user_" + user.getUsername(), cart);
    }

    /**
     * 获取购物车对象
     * 必须返回一个购物车对象
     */
    public Cart getCartFromRedis(User user) {
        ValueOperations<String, Cart> ops = redisTemplate.opsForValue();
        //先从redis中获取
        Cart cart = ops.get("user_" + user.getUsername());
        //如果购物车为空
        if (cart == null) {
            cart = new Cart();
        }
        return cart;
    }

    /**
     * 删除购物车
     */
    public void removeCart(User user) {
        redisTemplate.delete("user_" + user.getUsername());
    }
}
