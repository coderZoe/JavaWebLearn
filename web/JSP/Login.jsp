<%--
  Created by IntelliJ IDEA.
  User: 90617
  Date: 2020/5/17
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AutoLogin</title>
</head>
<body>

<%
    if(session.getAttribute("user")!=null){
        out.print("欢迎您！"+session.getAttribute("user").toString());
    }
%>
<form action="${pageContext.request.contextPath}/autoLogin" method="post">
    用户名:<input type="text" name="username"/><br/>
    密码:<input type="password" name="password"/><br/>
    登陆时长:<input type="radio" name="time" value="1">1分钟
    <input type="radio" name="time" value="5">5分钟
    <input type="radio" name="time" value="10">10分钟
    <input type="radio" name="time" value="15">15分钟
    <input type="radio" name="time" value="20">20分钟<br/>
    <input type="submit" value="登录">
</form>
</body>
</html>
