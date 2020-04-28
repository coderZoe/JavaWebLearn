package Servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author yhs
 * @date 2020/4/27 21:13
 * @description servlet读取资源文件
 */

@WebServlet(name = "Class5GetResourceFile",urlPatterns = "/getSource")
public class Class5GetResourceFile extends HttpServlet {

    /**
     * Servlet访问的资源只能WebInF文件夹下的，其他文件夹内容无法访问到
     */


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext servletContext = this.getServletContext();
        InputStream inputStream = servletContext.getResourceAsStream("/WEB-INF/resource/picture/西电.jpeg");
        System.out.println(inputStream);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
