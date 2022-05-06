package com.itheima.travel.controller;

import com.itheima.travel.domain.ResultInfo;
import com.itheima.travel.domain.User;
import com.itheima.travel.service.UserService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
//produces 指定返回的数据类型和编码
@RequestMapping(path = "/user", produces = "application/json;charset=utf-8")
@Slf4j
public class UserController extends BaseController {

    @Autowired
    private UserService userService;
    @Autowired
    private HttpSession session;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;

/**
 * 登录方法
 */

    /**
     * 注册功能
     */
    @SneakyThrows  //lombok提供的注解，生成的字节码中有抛出异常的代码
    @PostMapping("/register")
    public ResultInfo register(@RequestBody Map<String, Object> map) {
        //{user={username=用户名, telephone=电话号码, password=密码}, smsCode=验证码}
        log.info("注册参数是：" + map);
        //获取用户对象
        User user = new User();
        //从Map中获取User的属性
        Map<String,Object> userMap = (Map<String, Object>) map.get("user");
        //将map中同名的属性复制到user同名的属性中
        BeanUtils.populate(user, userMap);
        //获取用户提交的验证码
        String code = (String) map.get("smsCode");
        //调用业务层注册
        return userService.register(user, code);
    }

    /**
     * 判断用户名是否存在
     */
    @RequestMapping("/findByUserName")
    public ResultInfo findByUserName(String username) {
        User user = userService.findByUserName(username);
        if (user == null) {
            //表示用户不存在的
            return new ResultInfo(true, "用户名可以注册");
        } else {
            return new ResultInfo(false, "用户名已经存在");
        }
    }

    /**
     * 发送短信
     */
    @RequestMapping("/sendSms")
    public ResultInfo sendSms(String telephone) {
        //调用工具类随机生成6个数字
        String code = RandomStringUtils.randomNumeric(6);
        System.out.println("============="+code);
        log.info("验证码：" + code);
        //调用业务层发送短信
        return userService.sendSms(telephone, code);
    }

    /**
     * 登录发送验证码
     */
    @RequestMapping("/loginSendMessage")
    public ResultInfo loginSendMessage(String username) {
        //1.通过用户名查询用户是否存在
        User user = userService.findByUserName(username);
        //2.判断用户是否存在
        if (user == null) {
            return new ResultInfo(false, "用户名不存在");
        }
        //3.用户存在，获取手机号
        String telephone = user.getTelephone();
        //随机生成验证码
        String code = RandomStringUtils.randomNumeric(6);

        System.out.println("=========="+code);
        log.info("验证码：" + code);
        //4.给手机号发短信
        return userService.sendSms(telephone, code);
    }

    /**
     * 登录的功能
     * @param params
     * @return
     */
    @RequestMapping("/login")
    public ResultInfo login(@RequestBody Map<String,String> params) {
        //调用业务方法登录
        ResultInfo resultInfo = userService.login(params);
        //判断是否登录成功
        if (resultInfo.getSuccess()) {
            log.info("会话类：" + session.getClass() + "，会话ID：" + session.getId());
            //获取用户数据
            User user = (User) resultInfo.getData();
            //将用户的信息放到会话域中
//            session.setAttribute("user", resultInfo.getData());
            //将用户信息放在会话域中，用户对象从resultInfo的data属性中获取
            session.setAttribute("user", user);

            //如果登录成功，判断是否勾选自动登录。因为是字符串类型，这里要转换一下
            boolean autoLogin = Boolean.parseBoolean(params.get("autoLogin"));
            //如果勾选了自动登录，则将用户名和密码写到cookie中
            if (autoLogin) {
                //设置用户名
                Cookie cookieName = new Cookie("username", user.getUsername());
                //访问首页自动登录
                cookieName.setPath(request.getContextPath() + "/index.html");
                //过期时间1天
                cookieName.setMaxAge(60 * 60 * 24 * 1);
                response.addCookie(cookieName);

                //设置密码
                Cookie cookiePass = new Cookie("password", user.getPassword());
                //访问首页自动登录
                cookiePass.setPath(request.getContextPath() + "/index.html");
                //过期时间1天,单位是秒
                cookiePass.setMaxAge(60 * 60 * 24 * 1);
                response.addCookie(cookiePass);
            }
        }
        //返回登录结果
        return resultInfo;
    }

    /**
     * 判断用户是否登录
     */
    @RequestMapping("/isLogged")
    public ResultInfo isLogged() {
        //从会话域中获取用户的对象
        User user = getUserFromSession();
        if (user == null) {
            return new ResultInfo(false, "用户未登录");
        }
        else {
            //只返回用户名字
            return new ResultInfo(true, "用户已登录", user.getUsername());
        }
    }
    /**
     * 自动登录
     */
    @RequestMapping("/autoLogin")
    public ResultInfo autoLogin(User params) {
        //获取用户对象
        User user = userService.findByUserName(params.getUsername());
        //如果用户不为空，并且密码也相同，则登录成功
        if (user != null && user.getPassword().equals(params.getPassword())) {
            //将用户的信息保存到会话域中
            session.setAttribute("user", user);
            return new ResultInfo(true);
        }
        //自动登录失败
        return new ResultInfo(false);
    }
    /**
     * 用户退出
     */
    @RequestMapping("/logout")
    public void logout() {
        //会话销毁
        session.invalidate();
        //清空Cookie的数据
        //在Cookie中保存用户名
        Cookie cookieName = new Cookie("username", null);
        //设置访问路径，只有访问这个路径和它的子路径，才会发送Cookie的信息给服务器
        cookieName.setPath(request.getContextPath() + "/index.html");
        //删除Cookie
        cookieName.setMaxAge(0);
        //添加到浏览器端
        response.addCookie(cookieName);

        //在Cookie中保存密码，密码已经加密了
        Cookie cookiePassword = new Cookie("password",null);
        //设置访问路径，只有访问这个路径和它的子路径，才会发送Cookie的信息给服务器
        cookiePassword.setPath(request.getContextPath() + "/index.html");
        //删除Cookie
        cookiePassword.setMaxAge(0);
        //添加到浏览器端
        response.addCookie(cookiePassword);
    }
}
