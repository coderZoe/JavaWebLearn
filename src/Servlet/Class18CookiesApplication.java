package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yhs
 * @date 2020/4/29 16:40
 * @description
 */
@WebServlet(name = "Class18CookiesApplication",urlPatterns = "/cookieApp")
public class Class18CookiesApplication extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cookieValue = null;
        Cookie[] cookies = request.getCookies();
        response.setContentType("text/html;charset=UTF-8");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss.SSS");
        PrintWriter writer = response.getWriter();
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("time2")){
                cookieValue = cookie.getValue();
                writer.write("上次登录时间"+cookieValue);
                cookie.setValue(simpleDateFormat.format(new Date()));
                response.addCookie(cookie);
                break;
            }
        }
        if(cookieValue==null){
            Cookie cookie = new Cookie("time2",simpleDateFormat.format(new Date()));
            cookie.setMaxAge(100000);
            response.addCookie(cookie);
            writer.write("欢迎第一次登陆");
        }
    }

}
