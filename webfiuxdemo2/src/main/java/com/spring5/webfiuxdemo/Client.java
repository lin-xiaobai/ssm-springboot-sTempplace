package com.spring5.webfiuxdemo;

import com.spring5.webfiuxdemo.entity.User;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

/**
 * @date 2021/8/8 -12:10
 *
 * 使用WebClient进行调用测试
 * 不需要在网页上调用
 * 客户端进行调用
 */
public class Client {
    public static void main(String[] args) {
//        指定调用的服务器以及地址
//        传参： 请求服务器的地址
//        调用服务器地址  端口号需要在Server类中获取端口号
        WebClient webClient= WebClient.create("http://127.0.0.1:56256");

//        根据id查询
        String id="1";
//   提交方式：Get请求  第一个参数为请求的路径 第二个参数为传入的参数（id)
//        accept指定接收的数据类型格式
//        retrieve()进行初始化操作
//        bodyToMono()得到数据 参数为：返回类型的class文件  将数据转变为对象
//        block()：进行最终执行

        User userresult = webClient.get().uri("/users/{id}", id).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(User.class).block();
        System.out.println(userresult);


//         查询所有
        Flux<User> result = webClient.get().uri("/users").accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(User.class);
//        map()将元素转变为另一个元素  stu.getName():获取名字
//        buffer()进行缓冲  doOnNext():一个一个往下输出
//        blockFirst()类似于订阅
        result.map(stu ->stu.getName()).buffer().doOnNext(System.out::println).blockFirst();

    }
}
