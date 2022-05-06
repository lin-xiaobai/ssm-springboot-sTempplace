<%@ page import="java.awt.*" %>
<%@ page import="java.util.Random" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2021/6/29
  Time: 15:16
   将jsp文件变成图片文件
   修改contentType的属性值，修改成image/jpeg  就成了一张图片了

    验证码组成：1.数字 2.干扰线 3.画框

--%>
<%--   修改contentType的属性值，修改成image/jpeg  就成了一张图片了--%>
<%@ page contentType="image/jpeg;charset=UTF-8" language="java" %>
<%--生成随机颜色值--%>
<%--方法一般都写在<%! %>--%>
<%!
    //    绘图使用awt类
//    定义一个生成颜色的方法,返回值为Color
    public Color getColor() {
//        因为rgb的各个值都是从0到255，所以随机生成的值得在0-255
        Random ran = new Random();
//        生成0-255范围,定义r g b 的随机数
        int r = ran.nextInt(256);
        int g = ran.nextInt(256);
        int b = ran.nextInt(256);
//    color里面的三个参数为rgb的值
        return new Color(r, g, b);
    }

    //    产生验证码值，返回值为字符串string类型
    public String getNum() {
//        Math.random()的作用是产生0-1的数字，返回值是doule类型
//        代码意思是 生成0-9999的值  强转成int类型
        int num = (int) Math.random() * 9000 + 1000;
//        将int类型转为字符串
        String nums = String.valueOf(num);
        return nums;
    }
//    由于网页中存在缓冲现象，验证码本身是一张图片，防止客户端不让更新图片
//    所以验证码得禁止缓存操作

//    禁止缓存，防止验证码过期


%>


