package Servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yhs
 * @date 2020/4/27 20:48
 * @description
 */
public class Class3ServletConfig extends HttpServlet {

    /**
     * ServletConfig对象可以读取web.xml中的初始化参数配置
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig servletConfig = this.getServletConfig();
        String name = servletConfig.getInitParameter("name");
        System.out.println(name);
        System.out.println(this.getServletContext().getAttribute("name"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
