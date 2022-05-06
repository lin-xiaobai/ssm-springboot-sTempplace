<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2021/6/26
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>

<!--使用传统的自定义的传统标签 引用自定义的.tld标签文件-->
<!--uri是写入tld文件的uri属性值 prefix是前缀-->
<%@ taglib uri="http://www.youjizz.com" prefix="wf" %>
<!--引入简单方式的自定义标签 引用自定义的.tld标签文件-->
<%@ taglib uri="http://www.simple.com" prefix="simple" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试</title>
</head>
<!--使用自定义标签的前缀 num是tld文件中定义的必填-->
<body>
<!--这个标签的作用是打印3次hello文本-->
<wf:mytab num="3">
    <wf:toUpperCase>
        hellosdsdw
    </wf:toUpperCase>
</wf:mytab>
<%--  简单方式自定义标签打印输出num的值的标签体--%>
<simple:mytab num="5">您好</simple:mytab>


</body>
</html>
