package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yhs
 * @date 2020/4/29 10:26
 * @description 学习http请求request类
 */
@WebServlet(name = "Class13Request",urlPatterns = "/request")
public class Class13Request extends HttpServlet {

    /**
     * HttpServletRequest对象代表客户端的请求
     * 我们可以通过这个对象获得浏览器信息和请求时发过来的数据
     *
     * 1.浏览器信息
     * getRequestURL方法返回客户端发出请求时的完整URL。
     * getRequestURI方法返回请求行中的资源名部分。
     * getQueryString 方法返回请求行中的参数部分。
     * getPathInfo方法返回请求URL中的额外路径信息。额外路径信息是请求URL中的位于Servlet的路径之后和查询参数之前的内容，它以“/”开头。
     * getRemoteAddr方法返回发出请求的客户机的IP地址
     * getRemoteHost方法返回发出请求的客户机的完整主机名
     * getRemotePort方法返回客户机所使用的网络端口号
     * getLocalAddr方法返回WEB服务器的IP地址。
     * getLocalName方法返回WEB服务器的主机名
     *
     * 2.请求头
     * getHeader方法
     * getHeaders方法
     * getHeaderNames方法
     *
     * 3.请求参数
     * getParameter方法
     * getParameterValues（String name）方法
     * getParameterNames方法
     * getParameterMap方法
     */

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //防盗链
        //通过request的header信息判断访问当前网页的来源 如果不是由导航窗口进来 那就直接跳转回导航窗口 让用户再点一遍

        //得到网站的来源并进行判断
        String referer = request.getHeader("Referer");
        if(referer==null||!referer.contains("http://localhost:8080/JavaWebLearn/index.jsp")){
            response.sendRedirect("/JavaWebLearn/index.jsp");
            return;
        }
        response.setContentType("text/html; charset = UTF-8");
        response.getWriter().write("这是我的资源 你只能通过首页跳转过来");
    }
}
