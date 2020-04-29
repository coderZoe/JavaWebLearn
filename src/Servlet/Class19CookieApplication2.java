package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

/**
 * @author yhs
 * @date 2020/4/29 19:53
 * @description
 */
@WebServlet(name = "Class19CookieApplication2",urlPatterns = "/book")
public class Class19CookieApplication2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //显示所有书籍
        PrintWriter writer = response.getWriter();
        writer.write("网上所有书籍"+"<br/>");
        Set<Map.Entry<Integer,Book>> entries = BookCollector.getAllBook().entrySet();

        for(Map.Entry<Integer,Book> bookEntry:entries){
            Book book = bookEntry.getValue();
            writer.write("<a href='/JavaWebLearn/bookServlet?id="+book.getId() +"''target=_blank'>"+book.getName() +"</a>");
            writer.write("<br/>");
        }
        writer.write("您曾经浏览过："+"<br/>");
        Cookie[] cookies = request.getCookies();
        String bookHistory = null;
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("bookHistory")){
                bookHistory = cookie.getValue();
            }
        }
        String[] strings = null;
        if(bookHistory!=null){
            strings = bookHistory.split("_");
        }
        for(String string:strings){
            writer.write(BookCollector.getById(string)+"<br/>");
        }
    }
}
