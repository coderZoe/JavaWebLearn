<%@ page import="JSP.Person" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@taglib prefix="fn" uri="/WEB-INF/filter.tld"%>
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

<%--JavaBean的使用--%>
<jsp:useBean id="person" class="JSP.Person" scope="page"/>
<%
    person.setName("yhs");
    out.println(person.getName());
    System.out.println(person.getName());
%>
<%--jsp:setProperty--%>
<jsp:setProperty name="person" property="name" value="tomcat"/>
<%
    System.out.println(person.getName());
%>

<%--将setProperty与form表单一起使用--%>
<form action="firstJSP.jsp" method="post">
    用户名:<input type="text" name="name" />
    年龄:<input type="text" name="age" />
    <input type="submit" value="提交">
    <input type="reset" value="重置">
</form>

<%--这里JSP自动做了反射 将form表单name的值字段对应到了Person的属性上--%>
<jsp:setProperty name="person" property="*"/>
<%
    System.out.println(person.getName());
    System.out.println(person.getAge());
%>

<%--直接out.print输出到html--%>
<jsp:getProperty name="person" property="name"/>
<jsp:getProperty name="person" property="age"/>

<%--EL表达式--%>
<%
    session.setAttribute("name","yhs");
    System.out.println("设置了一个session");
%>
<%--普通方法--%>
<%
    String name = (String) session.getAttribute("name");
    System.out.println("得到了Session----->"+name);
%>
<br/>
<%--EL表达式--%>
<%--直接out.print了--%>
${name}

<%--EL操作JavaBean 利用了反射 调用了对象的getter方法--%>
${person.name}

<%--EL操作集合--%>
<%
    List<Person> personList = new ArrayList<>();
    for(int i = 0; i < 10; i++){
        personList.add(new Person("tom"+i,String.valueOf(i)));
    }
    session.setAttribute("list",personList);
%>
<br/>
${list[0].name} <br/>
${list[1].name} <br/>

<%
    Map<String,Person> personMap = new HashMap<>();
    for(int i = 0; i < 10; i++){
        personMap.put("tom"+i,new Person("tom"+i,String.valueOf(i)));
    }
    session.setAttribute("map",personMap);
%>
${map.tom0.name}<br/>
${map.tom1.name}<br/>

<%--测试EL的11个内置对象--%>
<%--pageContext内置对象--%>
<%
    pageContext.setAttribute("pageContext1", "pageContext");
%>
pageContext内置对象：${pageContext.getAttribute("pageContext1")}
<br>
<%--pageScope内置对象--%>
<%
    pageContext.setAttribute("pageScope1","pageScope");
%>
pageScope内置对象:${pageScope.pageScope1}
<br>
<%--requestScope内置对象--%>
<%
    request.setAttribute("request1","request");
%>
requestScope内置对象:${requestScope.request1}
<br>
<%--sessionScope内置对象--%>
<%
    session.setAttribute("session1", "session");
%>
sessionScope内置对象：${sessionScope.session1}
<br>
<%--applicationScope内置对象--%>
<%
    application.setAttribute("application1","application");
%>
applicationScope内置对象：${applicationScope.application1}
<br>
<%--header内置对象--%>
header内置对象：${header.Host}
<br>
<%--headerValues内置对象,取出第一个Cookie--%>
headerValues内置对象：${headerValues.Cookie[0]}
<br>
<%--Cookie内置对象--%>
<%
    Cookie cookie = new Cookie("Cookie1", "cookie");
%>
Cookie内置对象：${cookie.JSESSIONID.value}
<br>
<%--initParam内置对象，需要为该Context配置参数才能看出效果【jsp配置的无效！亲测】--%>
initParam内置对象:${initParam.name}
<br>

<%--测试EL的param对象--%>
<%--参数是上面的form表单传递来的--%>
${param.name}
${param.age}

<%
    Person user = new Person();
    user.setAge("20");

    //数据回显
    request.setAttribute("user",user);
%>
<input type="radio" name="age" value="20" ${user.age=='20'?'checked':'' }>20
<input type="radio" name="age" value="25" ${user.age=='25'?'checked':'' }>25

<%--测试EL调用自定义方法--%>
${fn:filter("<a href = ‘http://www.google.com’>谷歌</a>")}
</body>
</html>
