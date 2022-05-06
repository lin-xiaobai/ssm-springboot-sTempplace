package com.spring5.webfiuxdemo.handler;

import com.spring5.webfiuxdemo.entity.User;
import com.spring5.webfiuxdemo.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import static org.springframework.web.reactive.function.BodyInserters.fromValue;

/**
 * @date 2021/8/6 -22:47
 *  springWebflux(基于 函数式编程模型）
 *  （1）在使用函数式编程模型操作时候，需要 自己初始化服务器
 *  （2）两个核心接口：
 *  RouterFunction(实现路由功能，请求转发给对应的handler）
 *  HandlerFunction(处理请求生成响应的函数）
 *  核心任务：定义两个函数式接口的实现并且启动需要的服务器
 *
 *  springWebflux 请求和响应 不再是 ServletRequest和ServletResponse
 *  而是 ServerRequest和ServerResponse
 */
public class UserHandler {

    private  final UserService userService;

    //        通过有参构造对userService进行赋值
    public UserHandler(UserService userService){
        this.userService=userService;
    }
    //根据id查询 Mono 返回的元素1/0个元素
//    webflux中返回的不是 Servlet，而是Server，所以泛型添加为ServerResponse
//    ServerResponse返回的类型
//    需要在方法中传入id值  通过ServerRequest传递  serverRequest代表请求的对象
    public Mono<ServerResponse> getUserById(ServerRequest request){
//       获取 访问路径 中的值 名字为id 返回值为string
//        强转为int类型
//        获取id值
        int userId= Integer.valueOf(request.pathVariable("id"));

//        空值处理 build()空值构建
        Mono<ServerResponse> notFound=ServerResponse.notFound().build();



        //        调用service方法得到数据
        Mono<User> userMono=this.userService.getUserById(userId);
//        因为上面返回的类型中的泛型为ServerResponse
//    所以需要把  userMono 进行转换返回 userMono可以理解为一个对象
//        需要把 对象 转换为 流 的形式返回
//        使用Reactor操作符 flatMap
//        flatMap  把元素转换流，把转换之后多个流合并大的流
//        flatMap的传参是lamba表达式
//        ServerResponse.ok()表示操作成功
//        contentType：设置返回值类型
//        需要返回一个Json类型
//        body方法里面在body可以变成我们需要的类型
      return
//  switchIfEmpty(notFound)表示如果判断为空则返回上面定义的noFound
              userMono.flatMap(person ->ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(fromValue(person))).switchIfEmpty(notFound);
//   效果一样：return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(users,User.class);
    }

    //查询所有
    public Mono<ServerResponse> getAllUsers(ServerRequest request){
//        调用service得到结果 多个元素用Flux
        Flux<User> users= this.userService.getAllUser();
//        将users对象转换成流的形式
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(users,User.class);
    }



    //添加
    public  Mono<ServerResponse> saveUser(ServerRequest request){
//        得到user对象
//       bodyToMono： 将内容转换成Mono 传参：类型的class文件
        Mono<User> userMono=request.bodyToMono(User.class);
//        build():表示进行订阅 如果有变化则进行通知 然后进行操作
        return   ServerResponse.ok().build(this.userService.saveUserInfo(userMono));
    }
}
