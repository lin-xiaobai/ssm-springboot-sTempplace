package com.springmvc.config;

import com.springmvc.interceptor.TestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import java.util.List;
import java.util.Properties;

/**
 * @date 2021/10/10 -16:00
 * springmvc中的核心配置类 springmvc.xml的配置类
 * 代替springmvc的配置文件 springmvc.xml
 * springmvc.xml配置：
 * 1.扫描组件 2.视图解析器 3.view-controller(如果请求中没有数据处理 可以在这个里面配置，不需要创建控制类方法) 4.default-servlet-handled（处理静态资源配置）
 * 5.mvc注解驱动 6.文件上传解析器 7.异常处理  8.拦截器
 */
@Configuration //通过注解来标识这个类是一个配置类
//1.扫描组件 需要添加扫描的报名
//@ComponentScan("com.springmvc.controller")
@ComponentScan("com.springmvc")
//5.mvc注解驱动
@EnableWebMvc
//实现WebMvcConfigurer接口 是为了能够实现bean标签外的操作
public class WebConfig implements WebMvcConfigurer {

//    3.view-controller(如果请求中没有数据处理 可以在这个里面配置，不需要创建控制类方法)
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/hello").setViewName("hello");
    }
//    6.文件上传解析器
    @Bean
    public MultipartResolver multipartResolver(){
//        CommonsMultipartResolver是MultipartResolver接口的实现类
        CommonsMultipartResolver commonsMultipartResolver=new CommonsMultipartResolver();
        return commonsMultipartResolver;
    }

    //    7.异常解析器（在控制器方法执行时出现的异常时，将该异常交给异常控制器管理，并且重新跳转到一个新的异常视图）
    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
//       SimpleMappingExceptionResolver类是HandlerExceptionResolver实现类的子类
//        可以自定义 异常类
        SimpleMappingExceptionResolver exceptionResolver=new SimpleMappingExceptionResolver();
//       setExceptionMappings()方法传参是一个Properties对象（继承Hashtable）是一个map集合
        Properties properties=new Properties();
//        对Properties进行放值 是键值对格式
//        properties主要是文件配置，而且文件配置都是字符串格式
//        所以不能使用put(object类型)和add(object类型)方法进行放值
//        设置键值对
//        第一个key是放 可能出现的异常 ArithmeticException数字异常
        properties.setProperty("java.lang.ArithmeticException","error");

//        在请求域中共享异常信息  key为exception 可以通过 <p th:text="${exception}"></p>获取异常信息
        exceptionResolver.setExceptionAttribute("exception");
        exceptionResolver.setExceptionMappings(properties);
        resolvers.add(exceptionResolver);
    }
//    8.拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        创建自定义的拦截器
        TestInterceptor testInterceptor=new TestInterceptor();
//       将自定义的拦截器对象放到 传参位置
//        编写拦截规则  在registry.addInterceptor(testInterceptor)后面进行“.”加方法名
//        addPathPatterns() 方法：添加拦截路径
//        “/*”:表示拦截一层目录的所有请求
//        “/**”：无论多少层路径都拦截所有的请求
        registry.addInterceptor(testInterceptor).addPathPatterns("/**");
    }

    //    4.default-servlet-handled（处理静态资源配置）
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//       默认default-servlet-handled
        configurer.enable();
    }

    //配置生成模板解析器
    @Bean //这个标识将这个方法的返回值 作为IOC容器中一个bean
    public ITemplateResolver templateResolver() {
        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
        // ServletContextTemplateResolver需要一个ServletContext作为构造参数，可通过 WebApplicationContext 的方法获得
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver( webApplicationContext.getServletContext());
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        return templateResolver;
    }
    //生成模板引擎并为模板引擎注入模板解析器
//   当前的参数是ITemplateResolver， 它会去IOC容器 寻找相对应的Bean，然后对参数进行赋值
//    参数必须满足IOC容器中存在的Bean,因为上面templateResolver()方法已经将返回值交给了IOC容器中管理
    //    相当于自动转配
    @Bean
    public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver) {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine;
    }
    //生成视图解析器并未解析器注入模板引擎
    @Bean
//    形参位置是IOC容器中存在的Bean对象
    public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setCharacterEncoding("UTF-8");
        viewResolver.setTemplateEngine(templateEngine);
        return viewResolver;
    }
}
