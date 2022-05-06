<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2021/6/14
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    //JNDI：跨项目调取资源
    //实现步骤：1.配置tomcat/conf/context项目
    Context ctx = new InitialContext();
//        "java:comp/env/  固定  后面是tomcat/conf/context中配置的name属性
    String jndiValue = (String) ctx.lookup("java:comp/env/JNDIName");
    out.print(jndiValue);
%>

</body>
</html>
