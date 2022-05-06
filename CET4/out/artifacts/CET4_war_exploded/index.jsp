<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2021/7/5
  Time: 23:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script type="text/javascript" src="1_jquery-3.5.1.js"></script>
<script type="text/javascript">
    function reloadCheckImg() {
        //强制刷新
        $("img").attr("src", "img.jsp?t=" + (new Date().getTime()));
    }

    $(document).ready(function () {
        //检测手机号码是否为数字和有11(#O位数字
        $("#phone").blur(function () {
            var $p = $("#phone").val();
            var $phone = $p.length;
            var result = new RegExp(/^[0-9-+]+$/);
            var re = result.test($p)
            if ($phone == 11 && re) {
                $("#phon").html("正确");
            } else {
                $("#phon").html("请输入正确的手机号码");
            }
        })
        //检测身份证是否为18位
        $("#id").blur(function () {
            var $id = $("#id").val();
            var $num = $id.length;
            if ($num == 18) {
                $("#idspan").html("正确");
            } else {
                $("#idspan").html("请输入18位的身份证");
            }
        })

        $("#checkcodeId").blur(function () {
            // 获取id的值
            var $chekcode = $("#checkcodeId").val();
            //    校验：文本框输入的值 发送到服务端
            //    服务端：获取文本框输入的值，和真实验证码图片中的值对比，并返回结果
            //利用ajax的方法
            $.post(
                "check",//服务端地址
                //key的value形式获取值
                "checkcode=" + $chekcode,
                //    服务端的结果放在result中
                function (result) {
                    //    将服务端的结果以信息返回
                    var resultValue = result;
                    if (resultValue == "true ") {
                        $("#tip").html("您输入的验证码正确");
                    } else {
                        $("#tip").html("您输入的验证码不正确");
                    }
                }
            )
        })
    })
</script>
<head>
    <title>$Title$</title>
</head>
<body>
<p style="text-align: center;">欢迎来到英语4级报名系统
<form action="add" method="post">
    手机号：<input type="text" name="phone" id="phone" required/><span id="phon"></span><br/>
    姓名：<input type="text" name="user" required/><br/>
    密码：<input type="password" name="upwd" required/></br>
    身份证 ：<input type="text" name="uid" id="id" required>
    <span id="idspan"></span></br>
    验证码:<input type="text" name="checkcode" id="checkcodeId" size="4" required/>
    <a href="javascript:reloadCheckImg();"><img src="img.jsp"/></a>
    <span id="tip"></span><br/>
    <input type="submit" value="提交"/>
</form>
</body>
</html>
