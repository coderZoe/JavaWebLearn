<%--
  Created by IntelliJ IDEA.
  User: 90617
  Date: 2020/5/6
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
contains:${fn:contains("zhongfucheng",zhong )}<br>

containsIgnoreCase:${fn:containsIgnoreCase("zhongfucheng",ZHONG )}<br>

endsWith:${fn:endsWith("zhongfucheng","eng" )}<br>

escapeXml:${fn:escapeXml("<zhongfucheng>你是谁呀</zhongfucheng>")}<br>

indexOf:${fn:indexOf("zhongfucheng","g" )}<br>

length:${fn:length("zhongfucheng")}<br>

replace:${fn:replace("zhongfucheng","zhong" ,"ou" )}<br>

split:${fn:split("zhong,fu,cheng","," )}<br>

startsWith:${fn:startsWith("zhongfucheng","zho" )}<br>

substring:${fn:substring("zhongfucheng","2" , fn:length("zhongfucheng"))}<br>

substringAfter:${fn:substringAfter("zhongfucheng","zhong" )}<br>

substringBefore:${fn:substringBefore("zhongfucheng","fu" )}<br>

toLowerCase:${fn:toLowerCase("zhonGFUcheng")}<br>

toUpperCase:${fn:toUpperCase("zhongFUcheng")}<br>

trim:${fn:trim("              zhong    fucheng    ")}<br>

<%--将分割成的字符数组用"."拼接成一个字符串--%>
join:${fn:join(fn:split("zhong,fu,cheng","," ),"." )}<br>
</body>
</html>
