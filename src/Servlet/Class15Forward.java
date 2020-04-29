package Servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yhs
 * @date 2020/4/29 13:40
 * @description 实现转发
 */
@WebServlet(name = "Class15Forward",urlPatterns = "/forward")
public class Class15Forward extends HttpServlet {

    /**
     * response.sendRedirect()方法可以实现重定向 功能是页面跳转
     * request.getRequestDispatcher.forward(request,response)实现转发，做到的功能也是页面跳转
     * 同时转发也可以向request添加数据传给服务器 然后供不同Servlet之间访问
     * 与ServletContext不同 ServletContext是整个web的域对象 而request是一次http请求的域对象 在这一次http请求内都可以共用同一个request
     *
     * 转发和重定向的区别
     *
     * 1.发生位置不同 浏览器地址栏也不同
     * 重定向是由浏览器进行重新定向跳转的 url地址栏也会相应的变成重定向目的地的地址 相当于重定向的时候再次发生了一次http请求
     * 转发是由服务器实现的跳转 浏览器只进行了一次请求 服务器得到请求 然后转发给另一个servlet  另一个servlet处理完再返给浏览器
     * 整个过程是只有一个request和response 所以浏览器的地址栏没变化
     * 重定向：浏览器请求->servlet1->返回浏览器->浏览器再次请求->servlet2->返回浏览器
     * 转发：浏览器请求->servlet1->servlet2->返回浏览器
     *
     * 2.请求的资源和写法不同
     * 重定向对于返回的url是完应用名+资源名 /JavaWebLearn/index.jsp
     * 而转发的资源地址是直接就是资源名 /form
     * 所以转发只能访问当前web的资源
     * 但重定向可以访问任意资源
     *
     * 3.传递数据的类型不同
     * 转发的request对象可以传递各种类型的数据，包括对象
     * 重定向只能传递字符
     *
     * 4.跳转的时间不同
     * 转发时：执行到跳转语句时就会立刻跳转
     * 重定向：整个页面执行完之后才执行跳转
     *
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setAttribute("username","yhs");
//        //转发到form
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/form");
//        requestDispatcher.forward(request,response);

        //requestDispatcher的include方法
        request.getRequestDispatcher("/first").include(request,response);
        response.getWriter().write("--------------------------");
        request.getRequestDispatcher("/getResponse").include(request,response);

    }
}
