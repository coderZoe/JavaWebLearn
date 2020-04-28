package Servlet;

import javax.servlet.*;
import java.io.IOException;


/**
 * @data: 2020/04/27 19:15
 * @author: yhs
 * @description: servlet学习
 */

public class Class1MyFirstServlet implements Servlet {

    /**
     * Servlet生命周期：
     * 加载Servlet：当Tomcat第一次访问Servlet的时候，Tomcat会负责创建Servlet的实例
     * 初始化：当Servlet被实例化后，Tomcat会调用init()方法初始化这个对象
     * 处理服务：当浏览器访问Servlet的时候，Servlet 会调用service()方法处理请求
     * 销毁：当Tomcat关闭时或者检测到Servlet要从Tomcat删除的时候会自动调用destroy()方法，让该实例释放掉所占的资源。一个Servlet如果长时间不被使用的话，也会被Tomcat自动销毁
     * 卸载：当Servlet调用完destroy()方法后，等待垃圾回收。如果有需要再次使用这个Servlet，会重新调用init()方法进行初始化操作。
     *
     * 只要访问Servlet，service()就会被调用。init()只有第一次访问Servlet的时候才会被调用。destroy()只有在Tomcat关闭的时候才会被调用
     *
     * 一个已经被注册的Servlet可以被多次映射 即可以通过不同的url来访问到同一个Servlet
     * 映射的URL可以使用通配符
     * 1. *.扩展名  如:<url-pattern>*.jsp</url-pattern>  这样可以通过http://localhost:8080/JavaWebLearn/任意内容.jsp访问到 *代表任意字符
     * 2.以斜杠（/）开头并以“/*”结尾  如:<url-pattern>/*jsp</url-pattern> 匹配所有
     *
     * Servlet的单例加载
     * 浏览器会对Servlet进行多次请求 一般情况下服务器只创建一个Servlet对象 Servlet对象一旦创建 就会驻留在内存中
     * 浏览器的每次请求访问都会创建一个新的HttpServletRequest和HttpServletResponse 然后将这两个对象传给Servlet的service方法
     * service方法再根据请求类型决定调用doGet或doPost
     * 当多个用户访问同一Servlet资源时 服务器会为每个用户创建一个线程 这可能出现线程安全问题 需要用syn进行同步锁
     * 可以在<Servlet><Servlet/>中配置<load-on-startup><load-on-startup/>标签 在web启动时就创建Servlet实例 并调用他的init()方法 常用于初始化或定时调度任务
     */


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }


    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.getWriter().write("hello servlet");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
