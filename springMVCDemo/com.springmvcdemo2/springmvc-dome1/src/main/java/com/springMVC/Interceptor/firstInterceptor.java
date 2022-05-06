package com.springMVC.Interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @date 2021/10/9 -16:54
 * 定义拦截器
 * 1.需要实现HandlerInterceptor接口 或者继承HandlerInterceptorAdapter类（已过时）
 *接口中有默认修（ default）的方法，所以可以选择性进行重写方法
 *2.重新方法
 * 拦截器方法写完之后，是没有作用的
 * 让这个拦截器有作用需要在springmvc配置文件中配置
 *
 * preHandle：控制器方法执行之前执行preHandle()，其boolean类型的返回值表示是否拦截或放行，返
 * 回true为放行，即调用控制器方法；返回false表示拦截，即不调用控制器方法
 * postHandle：控制器方法执行之后执行postHandle()
 * afterComplation：处理完视图和模型数据，渲染视图完毕之后执行afterComplation()
 * */

@Component //普通组件 将这个类交给spring的IOC容器管理
public class firstInterceptor implements HandlerInterceptor {
//   preHandle()方法 在控制器方法执行之前执行

//   preHandle()中的返回值表示是否放行
//    false:表示不放行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("第一个拦截器中的preHandle方法执行");
//        不放行
//        控制台输出：
//        拦截器中的preHandle方法执行
//        页面不跳转

//        return false;
//        放行  页面会跳转
//        控制台输出：
//拦截器中的preHandle方法执行
//拦截器中的postHandle方法执行
//拦截器中的afterCompletion方法执行
        return true;
    }
//    在控制器方法执行之后执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("第一个拦截器中的postHandle方法执行");

    }
//    在视图渲染之后执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("第一个拦截器中的afterCompletion方法执行");

    }
}
