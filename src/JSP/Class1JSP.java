package JSP;

/**
 * @author yhs
 * @date 2020/5/6 15:38
 * @description JSP笔记
 */
public class Class1JSP {

    /**
     * 笔记
     * JSP指令
     * JSP指令用来声明JSP页面的相关属性，例如编码方式、文档类型等等
     * <%@指令  属性名="值"  %>
     * 如:<%@ page contentType="text/html;charset=UTF-8" language="java" %>
     *
     * page指令常见属性：
     * language="java"
     * extends="package.class"
     * import="{package.class | package.*}, …"
     * session="true | false"
     * buffer="none | 8kb | sizekb"
     * autoFlush="true | false"
     * isThreadSafe="true | false"
     * info="text"
     * errorPage="relative_url"
     * isErrorPage="true | false"
     * contentType="mimeType  ;charset=characterSet " | "text/html ; charset=ISO-8859-1"
     * pageEncoding="characterSet | ISO-8859-1"
     * isELIgnored="true | false"
     *
     * include指令
     * <%@include file="head.jsp" %>
     * <%@include file="foot.jsp" %>
     *
     * taglib指令
     * JSP支持标签技术，要使用标签技术就先得声明标签库和标签前缀。taglib指令就是用来指明JSP页面内使用标签库技术
     *
     * JSP行为:JSP行为（JSP Actions）是一组JSP内置的标签，只书写少量的标记代码就能够使用JSP提供丰富的功能，JSP行为是对常用的JSP功能的抽象和封装
     * include行为
     * <jsp:include page="head.jsp"/>
     * <jsp:include page="foot.jsp"/>
     *
     * param行为：
     * 当使用和行为引入或将请求转发给其它资源时，可以使用行为向这个资源传递参数
     * forward行为:
     * <jsp:forward page=""/> 做跳转
     *
     * directive行为:
     * 该行为是替代指令<%@%>的语法的
     * <jsp:directive.include file="head.jsp"></jsp:directive.include>
     * <jsp:directive.include file="foot.jsp"></jsp:directive.include>
     *
     * javaBean行为：
     * JSP还提供了操作javaBean对象的行为来操作简单类
     * <jsp:useBean id=""/>
     * <jsp:setProperty name="" property=""/>
     * <jsp:getProperty name="" property=""/>
     */
    public static void main(String[] args) {

    }
}
