package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

/**
 * @author yhs
 * @date 2020/4/29 15:07
 * @description
 */
@WebServlet(name = "Class17GetCookie",urlPatterns = "/getCookie")
public class Class17GetCookie extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //class16颁发给了浏览器一个cookie
        response.setContentType("text/html;charset=UTF-8");
        //class17的目的是获得cookie 看看是不是得到了 其实在浏览器里也可以看 确实是得到了
        Cookie[] cookies = request.getCookies();
        System.out.println(cookies.length);
        for(Cookie cookie:cookies){
            System.out.println(cookie.getDomain());
            String name = cookie.getName();
            //这里因为在颁布cookie的时候 对value字段进行了编码 所以现在想获得cookie就得进行解码
            String value = URLDecoder.decode(cookie.getValue(),"UTF-8");
            response.getWriter().write(name+value);
        }
    }
}
