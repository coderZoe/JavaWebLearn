package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yhs
 * @date 2020/5/17 11:26
 * @description
 */
@WebServlet(name = "AutoLogin",urlPatterns = "/autoLogin")
public class Class24AutoLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        String time = req.getParameter("time");

        User user = Class23UserDemo.getUSer(userName,password);
        if(user==null){
            req.setAttribute("message","用户名或密码错误");
            req.getRequestDispatcher("/JSP/message.jsp").forward(req,resp);
            return;
        }

        //如果登录成功
        req.getSession().setAttribute("user",user);
        req.setAttribute("message","恭喜!!登陆成功");
        Cookie cookie = new Cookie("autoLogin",user.getUserName()+"."+user.getPassword());
        cookie.setMaxAge(Integer.parseInt(time)*60);
        resp.addCookie(cookie);
        req.getRequestDispatcher("/JSP/message.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
