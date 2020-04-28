package Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author yhs
 * @date 2020/4/27 20:10
 * @description 继承HttpServlet 好处是不需要重写所以接口方法 并且添加了一些Http的处理方法
 */
public class Class2SecondServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String returnMsg = "hello man we see again, i am get";
        OutputStream outputStream = resp.getOutputStream();
        outputStream.write(returnMsg.getBytes());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("hello man we see again, i am post");
    }
}
