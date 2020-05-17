<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 90617
  Date: 2020/5/6
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

<%--Core标签库测试--%>
<%
    session.setAttribute("name","yhs");
%>
<%--cout--%>
<c:out value="${name}" default="不存在" escapeXml="true"/>

<%--cset--%>
<br/>
cset:
<c:set value="csetyhs" var="name" scope="page"/>
${name}

<%
    int sessionCount = 0;
    int applicationCount = 0;
%>
<c:set var="sessionCount" value="${sessionCount+1}" scope="session"/>
<c:set var="applicationCount" value="${applicationCount+1}" scope="application"/>次<br/>
您一共访问页面:${sessionCount}次<br/>
网页一共被访问:${applicationCount}次<br/>

cset-target:
<jsp:useBean id="person" class="JSP.Person" scope="page"/>
<c:set target="${person}" property="age" value="25"/>
${person.age}
<br/>
cremove :
<c:remove var="person" scope="page"/>
${person==null?"person被删了":"person还在"}
<br/>
ccatch:
<c:catch var="message">
    <c:set target="person" property="age" value="25"/>
<%--    这里出错的原因是target应该操作JavaBean或Map 不能是字符串--%>
</c:catch>
${message}
<br/>
cif:
<jsp:useBean id="user" class="JSP.Person" scope="page"/>
<c:set target="${user}" property="age" value="25"/>
<c:if test="${user.age==25}">
    我设置了25岁
</c:if>
<br/>
cchoose:
<c:choose>
    <c:when test="${user.age==25}">
        这里c:choose类似于if else
    </c:when>
    <c:when test="${name}=='csetyhs'">
        这里类似于 else if
    </c:when>
    <c:otherwise>
        这里就是else
    </c:otherwise>
</c:choose>
<br/>
c:forEach
<%
    List<String> stringList = new ArrayList<>();
    for(int i = 0; i < 10; i++){
        stringList.add((String.valueOf(i)));
    }
    pageContext.setAttribute("stringList",stringList);

    Map<String ,String> stringMap = new HashMap<>();
    stringMap.put("1","yhs");
    stringMap.put("2","zoe");
    stringMap.put("3","coder_yin");
    pageContext.setAttribute("stringMap",stringMap);
%>
<c:forEach var="list" items="${stringList}">
    ${list}
</c:forEach>
<br/>
<c:forEach var="item" items="${stringMap}">
    ${item.key} ${item.value}
    <br/>
</c:forEach>

<c:forEach var="item" items="${stringList}" begin="0" end="5" step="1" varStatus="state">
    ${item} ${state.index} ${state.count} ${state.current} ${state.first}<br/>
</c:forEach>

c:forTokens
<c:forTokens items="a,b,c,d,e,f,g" delims="," var="item">
    ${item}
</c:forTokens>

<c:import url="https://www.baidu.com" charEncoding="utf-8"/>
</body>
</html>
