package com.example.demoreactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @date 2021/8/5 -18:33
 * 响应式编程操作中
 * Reactor中的核心类 Mono和Flux 这两个类实现接口Publisher，提供丰富操作符
 * Flux对象实现发布者 返回 N 个元素  ；Mnon实现发布者，返回0或者1个元素
 *
 * Flux和Mono都是数据流的发布者，都可以发出三种数据信号：元素值，错误信号，完成信号
 * 错误信号和完成信号代表终止信号 终止信号用于告诉  订阅者 数据流结束了
 * 错误信号终止数据流同时把错误信息传递给订阅者
 *
 *   响应式编程不进行订阅是不会有任何输出的
 *
 *
 *   用just或者其他方法只是  声明数据流 ，数据流并没有发出，
 *   只有进行订阅之后才会触发数据流，不订阅声明都不会发生
 */
public class TestReactor {
    public static void main(String[] args) {
//        just方法直接声明
//       响应式编程不进行订阅是不会有任何输出的
//        不进行订阅只会输出日志：
//19:01:34.165 [main] DEBUG reactor.util.Loggers$LoggerFactory - Using Slf4j logging framework
//
//        对数据流进行  订阅输出  -->subscribe(System.out::print)
//        订阅后
//19:01:34.165 [main] DEBUG reactor.util.Loggers$LoggerFactory - Using Slf4j logging framework
//12341

//        向Flux发送4个元素值
        Flux.just(1,2,3,4).subscribe(System.out::print);
//        Mnon发送1并返回一个元素
        Mono.just(1).subscribe(System.out::print);

//        其他方法声明

//        声明数组的数据流
////        定义一个数组
//        Integer[] array={1,2,3,4};
//        Flux.fromArray(array);
//
////        创建一个集合，声明集合的数据流
////        将数组转变为集合
//        List<Integer> list= Arrays.asList(array);
//        Flux.fromIterable(list);
//
////        声明一个stream的数据流
////        声明一个stream流 将list集合转变为stream流
//        Stream<Integer> stream=list.stream();
//        Flux.fromStream(stream);
    }
}
