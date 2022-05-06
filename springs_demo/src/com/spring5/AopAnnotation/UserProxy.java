package com.spring5.AopAnnotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.awt.*;

/**
 * @date 2021/7/20 -19:28
 * AOP操作（在不动源代码的基础上，新添几个功能） （sprig结合Aspect框架）
 * 根据其类型按照从高到低的优先级进行执行：@Around    @Before   @After @AfterReturning @AfterThrowing
 * <p>
 * <p>
 * 步骤：
 * 1.创建类，在类中定义方法（被增强类）
 * 2.创建增强类（编写增强逻辑）
 * （1）在增强类里面，创建方法，让不同方法代表不同 通知类型（）
 * 通知类型：前置通知（在原方法前面）、后置通知（在原方法前面）、环绕通知（在原方法前面和后面）、异常通知（有异常时）、最终通知（如同finally）
 * 3.进行通知的配置
 * （1）在spring配置文件中，开启注解扫描
 * （2）使用注解创建 增强对象 和 被增强对象
 * （3）在增强类上面添加注解 @Aspect ：表示这个类是增强类
 * （4）在spring配置文件中开启生成代理对象
 * 4.配置不同类型的通知
 * （1）在增强类的里面，在作为通知方法上面添加类型注解，使用切入点表达式配置
 * 切入点表达式 语法：execution([权限修饰符][返回类型][类全路径][方法名称]([参数列表]))
 * <p>
 * 多个增强类对同一个方法进行增加，设置增强类优先级
 * 在增强类上面添加@Order(数字类型值)，数字类型越小优先级越高
 */

//创建增强类（编写增强逻辑）
//    在增强类里面，创建方法，让不同方法代表不同通知类型

@Component//普通注解 创建对象
@Aspect//生成代理对象
@Order(2)//设置增强类优先级
public class UserProxy {
    public final String Point = "execution(* com.spring5.AopAnnotation.User.add(..))";

//       相同的切入点抽取
//以下  execution(* com.spring5.AopAnnotation.User.add(..)) 出现了多次，可以提取出来
//     @Pointcut注释：表示这个是一个切入点
//    @Pointcut(value = "execution(* com.spring5.AopAnnotation.User.add(..))")

    @Pointcut(value = "execution(* com.spring5.AopAnnotation.User.add(..))")
    public void pointdemo() {
    }


    //    前置通知
//@@Before 注解表示作为前置通知  被增强对象
//切入点表达式 语法：execution([权限修饰符][返回类型][类全路径][方法名称]([参数列表]))
//    一个*表示所有的修饰符 +类路径+方法名称+ ..是参数列表
//
//    value值可以写成 方法名()
//    等同于：：
    @Before(value = "execution(* com.spring5.AopAnnotation.User.add(..))")
//   用final修饰的字符串 @Before(value = Point)
//    用切入点方定义的方法
//    @Before(value = "pointdemo()")
    public void before() {
        System.out.println("before.....");
    }

//     @After在方法结束之前执行  无论是否有异常都会通知
//    @AfterReturning在返回值之后执行  有异常则不通知

    //   最终通知
    @After(value = "execution(* com.spring5.AopAnnotation.User.add(..))")
    public void after() {
        System.out.println("after.....");
    }

    //  后置通知（返回通知）
    @AfterReturning(value = "execution(* com.spring5.AopAnnotation.User.add(..))")
    public void AfterReturning() {
        System.out.println("AfterReturning....");
    }


    //    异常通知  有异常才会通知
    @AfterThrowing(value = "execution(* com.spring5.AopAnnotation.User.add(..))")
    public void afterThrowing() {
        System.out.println("afterThrowing.....");
    }

    //    环绕通知
    @Around(value = "execution(* com.spring5.AopAnnotation.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕之前");
//       被增强的方法执行
        proceedingJoinPoint.proceed();

        System.out.println("环绕之后");
    }
}
