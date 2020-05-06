<%--
  Created by IntelliJ IDEA.
  User: 90617
  Date: 2020/5/6
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>笔记</h1>
<p>JSP全名为Java Server Pages，java服务器页面。JSP是一种基于文本的程序，其特点就是HTML和Java代码共同存在</p>
<p>JSP是为了简化Servlet的工作出现的替代品，Servlet输出HTML非常困难，JSP就是替代Servlet输出HTML的</p>
<p>JSP本身就是一种Servlet。其实JSP在第一次被访问的时候会被编译为HttpJspPage类（该类是HttpServlet的一个子类）</p>
<p>当浏览器请求一个 jsp时 Tomcat会将JSP转化为一个java类 然后这个Java文件会被编译成class文件 编译完毕后运行class文件来响应浏览器</p>
<p>在jsp不变动的情况下 以后访问jsp就直接访问class文件</p>
<p>JSP当初设计的目的是为了简化Servlet输出HTML代码</p>
<p>JSP内置了9个对象</p>
<p>内置对象有：out、session、response、request、config、page、application、pageContext、exception</p>
<p>使用JSP:</p>
<p>在Servlet处理好的数据，转发到JSP，JSP只管对小部分的数据处理以及JSP本身写好的页面</p>
<p>JSP的学习主要包含两个东西:EL表达式和JSTL</p>
<p>JSP语法可以包含两个部分:模板数据(HTML代码)和元素(JSP中Java代码 JSP指令)</p>
<p>JSP脚本就是JSP页面中的Java代码 也叫做scriptlet JSP脚本必须使用< % % >括起来</p>
<p>除此以外还可以使用jsp:scriptlet标签</p>
<br/>
<p>JSP指令:</p>
<p>JSP指令用来声明JSP页面的相关属性 例如编码格式 文档类型等</p>

<%
    String string = "hello JSP";
    out.println(string);
%>

<%--include指令 静态包含--%>
<%@include file="error.jsp"%>
<%@include file="foot.jsp"%>

<%--include行为 动态包含--%>
<jsp:include page="error.jsp"/>
<jsp:include page="foot.jsp"/>

<%--forward行为 做跳转--%>
<%--<jsp:forward page="foot.jsp"/>--%>

<%--directive行为:该行为是替代指令的语法--%>
<jsp:directive.include file="error.jsp"/>
<jsp:directive.include file="foot.jsp"/>

<%--模拟空指针异常--%>
<%--<%--%>
<%--   String string1 = null;--%>
<%--   string1.length();--%>
<%--%>--%>

<br/>
<%--PageContext--%>
<%
    out.println(pageContext.getRequest());
    out.println(pageContext.getResponse());
    out.println(pageContext.getServletConfig());
    out.println(pageContext.getSession());
    out.println(pageContext.getServletContext());
    out.println(pageContext.getPage());
    out.println(pageContext.getException());
    out.println(pageContext.getOut());
%>
<%
    System.out.println(pageContext.getRequest());
    System.out.println(pageContext.getResponse());
    System.out.println(pageContext.getServletConfig());
    System.out.println(pageContext.getSession());
    System.out.println(pageContext.getServletContext());
    System.out.println(pageContext.getPage());
    System.out.println(pageContext.getException());
    System.out.println(pageContext.getOut());
%>
<br/>
<%--PageContext作为域对象--%>
<%
    pageContext.setAttribute("name","yhs");
%>
<%
    out.println(pageContext.getAttribute("name"));
%>
</body>
</html>
