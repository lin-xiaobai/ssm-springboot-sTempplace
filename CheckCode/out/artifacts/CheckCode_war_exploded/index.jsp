<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2021/6/29
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <%--    编写juery--%>
    <script type="text/javascript" src="1_jquery-3.5.1.js">
    </script>
    <script type="text/javascript">
        //点击时再次请求验证码
        function reloadCheckImg() {
            //attr()修改新的属性
            //     ?t="+(new  Date().getTime())添加的原因：
            //web容器会记录JSP的时间戳，从而看JSP是否被修改过
            // 强制刷新：除了禁止缓存以外，还需要给服务端传递一个唯一的参数值（没有实际用处）
            //随机数、时间
            $("img").attr("src", "img.jsp?t=" + (new Date().getTime()));
        }

        $(document).ready(function () {
            $("#checkcodeId").blur(function () {

                // 获取id的值
                var $chekcode = $("#checkcodeId").val();
                //    校验：文本框输入的值 发送到服务端
                //    服务端：获取文本框输入的值，和真实验证码图片中的值对比，并返回结果
                //利用ajax的方法
                $.post(
                    "Servlet",//服务端地址
                    //key的value形式获取值
                    "checkcode=" + $chekcode,
                    //    服务端的结果放在result中
                    function (result) {
                        //    将服务端的结果以信息返回
                        var resultValue = result;
                        if (resultValue == "true") {
                            $("#tip").html("您输入的验证码正确");
                        } else {
                            $("#tip").html("您输入的验证码不正确");
                        }

                    }
                )
            })
        })

    </script>
    <title>验证码</title>
</head>
<body>
<%--  当光标失去时自动校验正确是否--%>
<%--  文本输入框--%>
<form action="Servlet">
    用户名：<input type="text" name="uname"><br/>
    密码：<input type="password" name="upwd"><br/>
    验证码：<input type="text" name="checkcode" id="checkcodeId" size="4"/>

    <%--  验证码--%>
    <%--点击href时执行JavaScript中的方法--%>
    <a href="javascript:reloadCheckImg();"><img src="img.jsp"/></a>
    <span id="tip"></span><br/>
    <input type="submit" value="提交">
</form>

</body>
</html>
