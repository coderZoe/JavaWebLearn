package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author yhs
 * @date 2020/5/6 9:22
 * @description
 */
@WebServlet(name = "Class22BuyBook",urlPatterns = "/showBuyBook")
public class Class22BuyBook extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();
        List<Book> bookList = (List<Book>) session.getAttribute("list");
        if(bookList==null||bookList.size()==0){
            writer.write("您暂时未购买任何书籍");
        }else {
            writer.write("您购买过以下商品:"+"<br/>");
            for(Book book:bookList){
                writer.write(book.getName()+"<br/>");
            }
        }
    }
}
