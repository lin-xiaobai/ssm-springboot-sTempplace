package com.springMVC.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.UUID;

/**
 * @date 2021/10/8 -19:19
 * 使用ResponseEntity用于控制器方法的返回值类型，该控制器方法的返回值就是响应到浏览器的响应报文
 *  方法的返回值：ResponseEntity
 *
 *  作用：可以实现上传和下载、自定义报文
 *  ResponseEntity类型：底层也就是一个流
 *
 * 从服务器中下载文件到浏览器（底层都是文件复制）
 *  使用ResponseEntity类型实现下载功能
 *  需要在static文件夹中添加一个img文件，然后存放资源（图片之类）
 *  响应报文：响应体 响应头 状态码
 */
@Controller
public class FileUpAndDownController {
//    也可以在springmvc的配置文件springmvc.xml中配置<mvc:view-controller>
//
    @RequestMapping("/FileDown")
    public String FileDown(){
        return "FileUpAndDown";
    }
//    方法的返回值为ResponseEntity类型来表示当前响应浏览器的报文信息
    @RequestMapping("/testDown")
//    形参的位置获取一个session对象
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
//        获取SerletContext对象
//        ServletContext：表示当前的工程
        ServletContext servletContext=session.getServletContext();
//        获取服务器中文件的真实路径
//        servletContext.getRealPath():获取当前【"/static/img/1.png"】字符串的服务器部署路径（当前工程部署到tomcat服务器的路径）
//   服务器的真实位置在target目录下的工程名里面
        String realPath=servletContext.getRealPath("/static/img/1.png");
//        输出 realPath 查看资源在服务器的真实位置
        System.out.println(realPath);
        //        创建输入流 文件下载和上传都是以流的形式
//        先读后写
        InputStream is = new FileInputStream(realPath);
//        创建字节数组
//        is.available()：获取当前输入流对应文件的所有字节数
        byte[] bytes = new byte[is.available()];
//        将所有字节数的流读到字节数组中
        is.read(bytes);

//将这个输入流响应到浏览器就是下载文件
//由于方法的返回值是ResponseEntity类型（自定义报文），
//将响应到浏览器的数据转换为ResponseEntity对象

//        创建HttpHeaders对象设置响应头（键值对形式）信息 底层是一个map集合
        MultiValueMap<String,String> httpHeaders = new HttpHeaders();
//        设置下载方式以及下载文件的名字 处理名字可以改，其余的不行
//       Content-Disposition：设置当前的下载方式
//       attachment：以附件的形式下载（在谷歌下载时下面显示下载完成）
//        filename：设置默认的名字
        httpHeaders.add("Content-Disposition","attachment;filename=1.png");
//设置响应状态码（200 404）
// HttpStatus.OK：设置HttpStatushttp的状态 OK是200
        HttpStatus statusCode=HttpStatus.OK;
//        创建ResponseEntity对象 三个参数
//        bytes:存放了当前文件的所有字节， 这也是响应体
//        httpHeaders：响应头
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, httpHeaders, statusCode);
//        关闭输入流
        return responseEntity;
    }


//    浏览器上传文件到服务器
    @RequestMapping(value = "/testUp",method = RequestMethod.POST)
//后端 接收 前端传递来的文件（二进制）
//    springmvc将前端上传到服务器的文件 封装到MultipartFile对象中
//    MultipartFile对象中跟浏览器上传文件包含的信息，以及要做的操作都封装好了

//    要想将 上传的文件(前端表单中的文件以二进制形式传到后端 ) 转化为 MultipartFile对象
//    MultipartFile这个对象 需要在springmvc的核心配置文件springmvc.xml上配置 文件上传解析器

//    形参的MultipartFile属性名 需要 与前端的name属性名一致
    public String testUp(MultipartFile photo,HttpSession session) throws IOException {
//transferTo()：资源状态转移 上传功能
//        传参（上传目标的 路径）就是上传到哪的路径
       System.out.println(photo.getBytes());;
//       获取上传文件的文件名

//       文件重名会导致文件被覆盖
//        解决方法：uuid(16进制的符号)+后缀名
        String fileName=photo.getOriginalFilename();
//       （1） 获取上传的文件的后缀名 需要知道“.”在字符串的的位置 IndexOf(".")获取第一个“.”的位置 包括这个“.”
//        string类型中substring()方法：
//        1个参数是从哪里截取字符，默认截取到最后
//        2个参数是从哪里截取一直截取到哪里
//
//        lastIndexOf()获取最后一个"."的位置（包括"."）
//        截取最后出现"."到结尾的字符串
        String suffixName=fileName.substring(fileName.lastIndexOf("."));
//        （2）创建一个UUid作为文件名
        String uuid= UUID.randomUUID().toString();
//        (3)将uuid和后缀名拼接后的结果作为最终的文件名
            fileName=uuid+suffixName;


//        将浏览器上传的文件 转移 到 服务器的webapp下的photo文件夹下（上传）
//        确定上传的位置:上传到webapp下的photo文件夹

//        1.先获取服务器的路径，所以需要在形参的位置上添加一个HttpSession对象
//        通过session会话的getServletContext()方法获取上下文，即可当前的工程ServletContext
        ServletContext servletContext = session.getServletContext();
//        2.将资源 放在服务器的photo目录下（上传的位置）
        String photoPath=servletContext.getRealPath("photo");
//        判断上传的路径是否存在，若不存在则需要创建
//        对 不存在的 上传的路径进行 动态创建

//        file文件 表示当前photoPath目录
//        这个file对象只是一个文件映射对象，并不是实际的文件夹
//        是在程序里的
        File file=new File(photoPath);
//        判断photoPath所对应路径是否存在
//        !file.exists()表示路径不存在
//      判断系统里是否存在这个文件夹
        if(!file.exists()){
//            若不存在，则创建目录
            file.mkdirs();
        }
//     确定上传的位置（服务器）
//        最终的位置=文件路径+文件分隔符（\或者/）+上传文件的名字
//        File.separator:表示一个文件分隔符
        String finalPath=photoPath+File.separator+fileName;
//        文件上传就是先读后写 transferTo()中实现了先读后写
//        传参可以是一个 路径名和一个File对象
        photo.transferTo(new File(finalPath));
        return "success";
    }

}
