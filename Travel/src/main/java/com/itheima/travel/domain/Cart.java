package com.itheima.travel.domain;

import lombok.Data;

import java.util.HashMap;

/**
 * 购物车
 */
@Data
public class Cart {

    //购物车项集合，注：必须创建出来，否则集合为空
    private HashMap<String, CartItem> cartItemMap = new HashMap<>();
    //商品总数量
    private int cartNum;
    //商品总价格
    private double cartTotal;

    /**
     * 重新计算总数量
     */
    public int getCartNum() {
        this.cartNum = 0;
        //cartItemMap.values()获取所有值的集合，cartItem表示一项
        for (CartItem cartItem : cartItemMap.values()) {
            this.cartNum += cartItem.getNum();
        }
        return this.cartNum;
    }

    /**
     * 重新计算总金额
     */
    public double getCartTotal() {
        this.cartTotal = 0;
        for (CartItem cartItem : cartItemMap.values()) {
            this.cartTotal += cartItem.getSubTotal();
        }
        return this.cartTotal;
    }


}
