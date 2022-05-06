package com.itheima.travel.domain;

import lombok.Data;

/**
 * 购物车项
 */
@Data
public class CartItem {

    //线路(商品)
    private Route route;
    //数量
    private int num;
    //小计
    private double subTotal;

    /**
     * 小计=线路价格x数量
     * @return
     */
    public double getSubTotal() {
        this.subTotal = this.num * this.route.getPrice();
        return this.subTotal;
    }
}
