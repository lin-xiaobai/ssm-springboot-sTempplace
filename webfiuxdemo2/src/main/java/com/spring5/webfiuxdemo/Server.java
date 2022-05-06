package com.spring5.webfiuxdemo;

import com.spring5.webfiuxdemo.handler.UserHandler;
import com.spring5.webfiuxdemo.service.Impl.UserServiceImpl;
import com.spring5.webfiuxdemo.service.UserService;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.netty.http.server.HttpServer;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.toHttpHandler;

/**
 * @date 2021/8/7 -23:17
 * 创建 路由 的方法
 * 创建  服务器完成配置
 * 00:17:55.630 [reactor-http-nio-1] DEBUG reactor.netty.transport.ServerTransport - [id: 0x80ac83e9, L:/0:0:0:0:0:0:0:0:53974] Bound new server
 * 53974端口号
 */
public class Server {

    public static void main(String[] args) throws Exception{
        Server server=new Server();
//        启动服务
        server.createReactorServer();
//        退出
        System.in.read();
    }
//    创建Router路由的方法
//    返回的类型是：RouterFunction
    public RouterFunction<ServerResponse> routingFunction(){
//        参加对象
       UserService userService = new UserServiceImpl();
//        创建userHandler类 ，在userHandler中进行操作：增查操作
//        需要传参是userService类
        UserHandler handler=new UserHandler(userService);

//        调用RouterFunction中的route方法
        return RouterFunctions.route(
//            在里面进行根据id进行请求 :Get请求:Get是一个常量
//          在get请求里面添加 请求的路径
//          {id}表示传入的   id值
//        在后面设置  接收返回的类型数据格式  包括需要调用handler中哪个方法
// 代码意思：设置 请求的路径 /users/{id} 设置接受的类型为JSON格式数据，并且调用自定义的handler类中getUserById方法中通过id查询结果
           GET("/users/{id}").and(accept(APPLICATION_JSON)),handler::getUserById)
//              在里面使用链式方程 andRoute()方法
//       在里面调用其他的方法
//      代码意思：设置请求的路径为/users ，设置接受的类型为JSON格式数据，并且调用自定义的handler类中查询所有 getAllUsers方法
                .andRoute(GET("/users").and(accept(APPLICATION_JSON)),handler::getAllUsers);
    }

//    3.创建服务器完成适配
    public void createReactorServer(){
//     路由和handler适配
//        调用上面的routingFunction()方法   创建Router路由
//        得到路由
        RouterFunction<ServerResponse> route = routingFunction();
//        做适配
//        HttpHandler做http请求，储存请求的信息
        HttpHandler httpHandler = toHttpHandler(route);
//        最终的适配  返回的是一个适配器的对象
        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(httpHandler);

//   创建服务器
        HttpServer httpServer=HttpServer.create();
//        传入适配器  现在进行构建
        httpServer.handle(adapter).bindNow();
    }

}
