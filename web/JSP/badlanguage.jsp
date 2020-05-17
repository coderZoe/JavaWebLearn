<%--
  Created by IntelliJ IDEA.
  User: 90617
  Date: 2020/5/17
  Time: 12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>敏感词屏蔽</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/filterBadLanguage" method="get">
    <input type="text" name="words">
    <input type="submit" value="提交">
</form>
</body>
</html>
