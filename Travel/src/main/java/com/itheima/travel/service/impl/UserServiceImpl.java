package com.itheima.travel.service.impl;

import com.itheima.travel.dao.UserDao;
import com.itheima.travel.domain.ResultInfo;
import com.itheima.travel.domain.User;
import com.itheima.travel.service.UserService;
import com.itheima.travel.utils.Md5Utils;
import com.itheima.travel.utils.SmsUtils;
import com.itheima.travel.utils.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RedisTemplate redisTemplate;  //操作Redis的模板对象

    /**
     * 用户注册
     * @param user
     */
    @Override
    public ResultInfo register(User user,String code) {
        //1.判断用户名是否存在
        User byUserName = userDao.findByUserName(user.getUsername());
        if (byUserName != null) {
            return new ResultInfo(false, "用户名已经存在");
        }
        //2.判断电话号码是否存在
        User byTelephone = userDao.findByTelephone(user.getTelephone());
        if (byTelephone != null) {
            return new ResultInfo(false, "手机号已经被注册了");
        }
        //3.判断验证码是否过期
        ValueOperations<String,String> ops = redisTemplate.opsForValue();
        //获取验证码
        String smsCode = ops.get("smsCode_" + user.getTelephone());
        if (smsCode == null) {
            return new ResultInfo(false, "验证码过期");
        }
        //判断验证码是否正确
        if (!smsCode.equals(code)) {
            return new ResultInfo(false, "验证码错误");
        }
        //验证码通过，删除验证码
        redisTemplate.delete("smsCode_" + user.getTelephone());

        //4.对密码使用md5加密：md5(用户名+密码+盐)
        //产生盐
        String salt = UuidUtils.simpleUuid();
        //使用md5进行加密
        String md5 = Md5Utils.getMd5(user.getUsername() + user.getPassword() + salt);
        //替换原来密码字段
        user.setPassword(md5);
        //设置盐
        user.setSalt(salt);
        //5.调用dao添加用户方法
        userDao.save(user);
        return new ResultInfo(true, "用户注册成功");
    }

    /**
     * 判断用户名是否存在
     * @param username
     */
    @Override
    public User findByUserName(String username) {
        return userDao.findByUserName(username);
    }

    /**
     * 发送手机短信验证码
     * SMS: Short Message Service
     * @param telephone 手机号
     * @param code 6位数字的验证码
     */
    @Override
    public ResultInfo sendSms(String telephone, String code) {
        //1.调用工具类发送短信
//        String result = SmsUtils.send(telephone, "黑马旅游", "SMS_195723031", code);
        //1.模拟发送成功
        String result = "OK";
        //2.判断是否发送成功
        if ("OK".equals(result)) {
            //把验证码放到Redis中去
            ValueOperations<String,String> ops = redisTemplate.opsForValue();
            //设置存活时间是30秒
            ops.set("smsCode_" + telephone, code, 30, TimeUnit.SECONDS);
            return new ResultInfo(true, "短信发送成功");
        }
        else {
            return new ResultInfo(false, "短信发送失败");
        }
    }

    /**
     * 登录
     * @param params 用户名username，密码password，验证码smsCode
     */
    @Override
    public ResultInfo login(Map<String, String> params) {
        //调用业务层判断用户名是否存在
        User user = userDao.findByUserName(params.get("username"));
        if (user == null) {
            return new ResultInfo(false, "用户名不存在");
        }
        //不为空再判断密码是否正确
        String md5 = Md5Utils.getMd5(params.get("username") + params.get("password") + user.getSalt());
        //判断加密后的密码与数据库中密码是否一致
        if (!md5.equalsIgnoreCase(user.getPassword())) {
            return new ResultInfo(false, "密码错误");
        }
        ValueOperations<String,String> ops = redisTemplate.opsForValue();
        //获取验证码
        String code = ops.get("smsCode_" + user.getTelephone());
        //判断验证码是否正确
        if (code == null) {
            return new ResultInfo(false, "验证码过期");
        }
        //不为空则判断验证码
        if (!code.equals(params.get("smsCode"))) {
            return new ResultInfo(false, "验证错误");
        }
        //登录成功，将用户对象封装传到控制器
        return new ResultInfo(true, "登录成功", user);
    }
}
