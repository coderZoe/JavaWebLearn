package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yhs
 * @date 2020/4/28 20:27
 * @description 重定向跳转
 */
@WebServlet(name = "Class11Redirect",urlPatterns = "/redirect")
public class Class11Redirect extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //重定向跳转:点击一个超链接 通知浏览器跳转到另一个页面
        //页面之间的跳转有两种方式 重定向和转发

        //1.重定向
//        response.sendRedirect("/JavaWebLearn/index.jsp");

        //具体实现
        response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);   //302 临时重定向
        response.setHeader("Location","/JavaWebLearn/index.jsp");
    }
}
