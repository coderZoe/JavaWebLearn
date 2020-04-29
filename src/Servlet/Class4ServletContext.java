package Servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yhs
 * @date 2020/4/27 20:57
 * @description ServletContext对象代表当前web站点 所有的Servlet都有同一个ServletContext 所以ServletContext可以实现Servlet之间通讯
 */
public class Class4ServletContext extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        //配置属性
        servletContext.setAttribute("name","coderZoe");

        //与此同时可以在web.xml中配置站点信息，这样每个Servlet就都可以访问站点信息 不用把站点信息放入每个Servlet中

        /**
         * <context-param>
         *   <param-name>name</param-name>
         *   <param-value>coderZoe</param-value>
         * </context-param>
         */
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
