<%@ page import="javax.xml.ws.Response" %>
<%@ page import="java.awt.*" %>
<%@ page import="java.util.Random" %>
<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="javax.imageio.ImageIO" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2021/6/29
  Time: 15:56
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
        int num = (int) (Math.random() * 9000) + 1000;
//        将int类型转为字符串
        return String.valueOf(num);

    }
%>
<%
    //    由于网页中存在缓冲现象，验证码本身是一张图片，防止客户端不让更新图片
//    所以验证码得禁止缓存操作
//    禁止缓存，防止验证码过期
//    设置头信息（禁止缓存是设置三个头信息）
//    固定三句话设置缓存
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Cache-Control", "no-cache");
//    清缓存时间 ,缓存马上过期
    response.setHeader("Expires", "0");

//    绘制验证码
//    一个长方形背景
//    长80，宽30，类型是rgb类型
    BufferedImage image = new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);
//    画笔
    Graphics graphics = image.getGraphics();
//    fillRect填充长方形
//    第一和第二个参数是填充的起点（x,y)
//    第三和第4个参数是长和宽
    graphics.fillRect(0, 0, 80, 30);

//   绘制干扰线条  干扰线条20条
    for (int i = 0; i < 20; i++) {
//        生成单条线条随机坐标（x，y）
        Random ran = new Random();
//        生成范围在80的随机数
        int xBegin = ran.nextInt(80);
//        生成范围在30的随机数
        int yBegin = ran.nextInt(30);
//       生成横坐标和纵坐标多10的随机数
        int xEnd = ran.nextInt(xBegin + 10);
        int yEnd = ran.nextInt(yBegin + 10);

//      设置干扰线线条的颜色
        graphics.setColor(getColor());

//        开始绘图
        graphics.drawLine(xBegin, yBegin, xEnd, yEnd);
    }
//    将字体放大  加粗 20像素
    graphics.setFont(new Font("seif", Font.BOLD, 20));
//    绘制验证码
//获取验证码数字
    String checkCode = getNum();//2468
//    每个数字之间隔一个空格
//    拼接字符串
    StringBuffer sb = new StringBuffer();
//    第一次循环拼接一个2  第二次循环拼接一个空格
//     第三次循环拼接一个4  以此类推
    for (int i = 0; i < checkCode.length(); i++) {
//        获取验证码的每一位数字
//        拼接字符串
        sb.append(checkCode.charAt(i) + " ");
    }
    //    验证码用黑色笔画
    graphics.setColor(Color.BLACK);

//写num数字在验证码区域的位置（中间）
    graphics.drawString(sb.toString(), 15, 15);//描绘验证码的内容

//将验证码真实值保存在session中，供使用时比较真实
    session.setAttribute("checkCode", checkCode);

//    真实的产生图片
//    第一个参数是BufferedImage
//    第二个参数是图片的类型
//     第三个参数是一个流
    ImageIO.write(image, "jpeg", response.getOutputStream());

//    关闭操作
    out.clear();
//    如果要将自定义的图片放在input标签的src中，需要添加pageContext.pushBody()
    out = pageContext.pushBody();


%>

