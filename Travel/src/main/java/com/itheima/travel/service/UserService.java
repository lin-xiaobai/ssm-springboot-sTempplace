package com.itheima.travel.service;

import com.itheima.travel.domain.ResultInfo;
import com.itheima.travel.domain.User;

import java.util.Map;

/**
 * 用户业务层接口
 */
public interface UserService {

    /**
     * 用户注册
     */
    ResultInfo register(User user, String code);

    /**
     * 判断用户名是否存在
     */
    User findByUserName(String username);

    /**
     * 发送手机短信验证码
     * SMS: Short Message Service
     * @param telephone 手机号
     * @param code 6位数字的验证码
     */
    ResultInfo sendSms(String telephone, String code);

    /**
     * 登录
     */
    ResultInfo login(Map<String,String> params);
}
