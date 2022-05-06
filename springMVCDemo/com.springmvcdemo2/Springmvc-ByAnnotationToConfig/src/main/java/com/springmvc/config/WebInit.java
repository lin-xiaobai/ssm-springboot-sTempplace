package com.springmvc.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import java.io.File;

/**
 * @date 2021/10/10 -15:48
 * 通过注解的方式代替系统配置文件，例如web.xml和springweb的核心配置类springmvc.xml
 *
 * Ttomcat启动时，会先执行web.xml文件
 * 使用配置类和注解代替web.xml和SpringMVC配置文件的功能
 */
//web工程的初始化类，用来代替web.xml
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
//getRootConfigClasses() 获取当前的分配置 即spring的配置类
    protected Class<?>[] getRootConfigClasses() {
//        new Class[0]：表示创建一个class类型的数组，长度为0
//        把spring的配置类SpringConfig.class放到这个数组中
        return new Class[]{SpringConfig.class};
    }

    @Override
//    设置指定SpringMVC的配置类
    protected Class<?>[] getServletConfigClasses() {
//    把web的配置类WebConfig.class放到这个数组中(即web.xml)
        return new Class[]{WebConfig.class};
    }

//    设置指定DispatcherServlet的映射规则，即url-pattern
    @Override
    protected String[] getServletMappings() {
//       设置url-pattern 将"/"放到数组中返回
        return new String[]{"/"};
    }

//    注册过滤器
//    设置UTf-8过滤器 返回值是一个拦截类数组Filter[]
    @Override
    protected Filter[] getServletFilters() {
//        设置过滤器characterEncodingFilter过滤器  post请求中不乱码
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
//        设置初始化参数
        characterEncodingFilter.setEncoding("UTF-8");
//        默认是false
        characterEncodingFilter.setForceEncoding(true);

//     配置HiddenHttpMethodFilter过滤器  在form表单中能实现post方法
        HiddenHttpMethodFilter hiddenHttpMethodFilter=new HiddenHttpMethodFilter();

        return new Filter[]{characterEncodingFilter,hiddenHttpMethodFilter};
    }
}
