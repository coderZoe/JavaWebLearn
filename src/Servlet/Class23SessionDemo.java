package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author yhs
 * @date 2020/5/6 11:03
 * @description
 */
@WebServlet(name = "Class23SessionDemo",urlPatterns = "/demo")
public class Class23SessionDemo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        User user = Class23UserDemo.getUSer(userName,password);
        if(user==null){
            response.getWriter().write("登陆失败 没有该用户");
            return;
        }

        //设置session
        HttpSession session = request.getSession();
        session.setAttribute("user",user);
        response.getWriter().write("恭喜");
        response.getWriter().write(((User)session.getAttribute("user")).getUserName());
        response.getWriter().write("登录");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
