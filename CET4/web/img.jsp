<%@ page import="java.awt.*" %>
<%@ page import="java.util.Random" %>
<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="javax.imageio.ImageIO" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2021/7/5
  Time: 23:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="image/jpeg;charset=UTF-8" language="java" %>
<%!
    public Color getColor() {
        Random random = new Random();
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        return new Color(r, g, b);
    }

    public String getNum() {
        Random random = new Random();
        int num = random.nextInt(10000) + 1000;
        return String.valueOf(num);
    }
%>
<%
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Cache-Control", "no-cache");
//    清缓存时间 ,缓存马上过期
    response.setHeader("Expires", "0");
    BufferedImage image = new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);
//    画笔
    Graphics graphics = image.getGraphics();
//    fillRect填充长方形
//    第一和第二个参数是填充的起点（x,y)
//    第三和第4个参数是长和宽
    graphics.fillRect(0, 0, 80, 30);
//    绘制干扰线条  干扰线条20条
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
