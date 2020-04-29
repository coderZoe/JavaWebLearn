package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yhs
 * @date 2020/4/29 20:20
 * @description
 */
@WebServlet(name = "BookServlet",urlPatterns = "/bookServlet")
public class Class20BookServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("id");
        String bookHistory = null;
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("bookHistory")){
                bookHistory = cookie.getValue();
            }
        }
        if(bookHistory!=null){
            String[] strings = bookHistory.split("_");
            List<String> list = Arrays.asList(strings);
            LinkedList<String> linkedList = new LinkedList<>(list);
            if(linkedList.contains(id)){
                linkedList.remove(id);
                linkedList.addFirst(id);
            }else {
                if(linkedList.size()>=3){
                    linkedList.removeLast();
                    linkedList.addFirst(id);
                }else {
                    linkedList.addFirst(id);
                }
            }
            StringBuffer stringBuffer = new StringBuffer();
            for(String bookid:linkedList){
                stringBuffer.append(bookid+"_");
            }
            bookHistory = stringBuffer.deleteCharAt(stringBuffer.length()-1).toString();
        }else {
            bookHistory = id;
        }
        Cookie cookie = new Cookie("bookHistory",bookHistory);
        cookie.setMaxAge(1000);
        response.addCookie(cookie);
    }
}
