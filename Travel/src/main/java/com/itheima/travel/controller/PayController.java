package com.itheima.travel.controller;

import com.itheima.travel.domain.ResultInfo;
import com.itheima.travel.service.OrderService;
import com.itheima.travel.utils.PayUtils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 支付相关的处理器
 */
@RestController
@RequestMapping(value = "/pay",produces = "application/xml;charset=utf-8")  //必须是xml格式
@Slf4j
public class PayController extends BaseController {

    @Autowired
    private OrderService orderService;
    /**
     * 生成预交易的链接
     * @return 交易地址
     */
    @RequestMapping("/createUrl")
    public String createUrl(String oid, Integer price) {
        log.info("订单号: {}, 支付金额: {}", oid, price);
        //调用工具类生成交易的链接
//        String url = PayUtils.createOrder(oid, 1);//写死1分钱，单位是分
//        log.info("生成的交易链接是：{}", url);
//        return url;

//        模拟成功
        String url="您已经成功支付";
        return url;
    }

    /**
     * 接收微信支付的结果
     * @param payResult 接受的也是xml格式
     * @return 返回结微信的是xml格式
     */
    @RequestMapping("/payNotify")
    public Map<String,String> payNotify(@RequestBody Map<String,String> payResult) {
        log.info("支付结果：{}", payResult);
        //调用业务层根据支付结果返回订单状态
        ResultInfo resultInfo = orderService.updateState(payResult);
        //如果更新订单状态成功的话，返回支付成功
        HashMap<String, String> resultMap = new HashMap<>();
       if (resultInfo.getSuccess()) {
           resultMap.put("return_code", "SUCCESS");
           resultMap.put("return_msg", "OK");
       }
       else {
           resultMap.put("return_code", "FAIL");
           resultMap.put("return_msg", "OK");
       }
        return resultMap;
    }

    /**
     * 获取支付状态
     */
    @RequestMapping(value = "/findStatus",produces = "application/json;charset=utf-8")
    public boolean findStatus(String oid) {
        return orderService.isPaid(oid);
    }
}
