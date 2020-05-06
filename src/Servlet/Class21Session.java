package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yhs
 * @date 2020/5/5 21:37
 * @description session
 */
@WebServlet(name = "Class21Session",urlPatterns = "/buyBook")
public class Class21Session extends HttpServlet {
    /**
     * 笔记
     * Session是另一种记录浏览器状态的机制 不同的是Cookie保存在浏览器中 Session保存在服务器中
     * session相当于在服务器上建了一张用户明细表
     * session使用比Cookie方便 与此同时 Session可以存储对象 但Cookie只能存储字符串
     *
     * Session的API
     * long getCreationTime();【获取Session被创建时间】
     * String getId();【获取Session的id】
     * long getLastAccessedTime();【返回Session最后活跃的时间】
     * ServletContext getServletContext();【获取ServletContext对象】
     * void setMaxInactiveInterval(int var1);【设置Session超时时间】
     * int getMaxInactiveInterval();【获取Session超时时间】
     * Object getAttribute(String var1);【获取Session属性】
     * Enumeration getAttributeNames();【获取Session所有的属性名】
     * void setAttribute(String var1, Object var2);【设置Session属性】
     * void removeAttribute(String var1);【移除Session属性】
     * void invalidate();【销毁该Session】
     * boolean isNew();【该Session是否为新的】
     *
     * Session生命周期
     * 1.Session在用户第一次访问服务器Servlet，jsp等动态资源就会被自动创建
     * 2.如果访问HTML,IMAGE等静态资源Session不会被创建。
     * 3.Session生成后，只要用户继续访问，服务器就会更新Session的最后访问时间，无论是否对Session进行读写，服务器都会认为Session活跃了一次。
     * 4.由于会有越来越多的用户访问服务器，因此Session也会越来越多。为了防止内存溢出，
     * 服务器会把长时间没有活跃的Session从内存中删除，这个时间也就是Session的超时时间。
     * 5.Session的超时时间默认是30分钟，有三种方式可以对Session的超时时间进行修改
     * (1).在tomcat/conf/web.xml文件中设置 对所有的WEB应用都有效 单位为分钟
     * <session-config>
     *  <session-timeout>30</session-timeout>
     * </session-config>
     * (2).在单个的web.xml文件中设置 对单个web应用有效 如果有冲突，以自己的web应用为准
     * <session-config>
     *  <session-timeout>30</session-timeout>
     * </session-config>
     * (3).通过setMaxInactiveInterval()方法设置
     * httpSession.setMaxInactiveInterval(60);  //单位是秒
     *
     * 6.Session的有效期与Cookie的是不同的
     * (1).session周期指的是不活动时间 当在超时时间内访问session session会重新计时
     * (2).如果重启tomcat 或reload web应用 或者关机等 session也会消失
     * (3).通过invalidate()方法让Session中所有属性失效 常用于安全退出
     * (4).removeAttribute()使单个Session属性消失
     * Cookie的生命周期是按累计时间来算的 不管用户是否访问了Session
     *
     * 不同的用户使用的是不同的session  如下面的买书的例子
     * 用户点击进去购买书籍 则Servlet创建一个Session(或更新一个Session)
     * 但当不同的用户也点击购买书籍时 之前保存的Session并不适用于这个用户 相当于每个用户都有一份自己本身的Session信息
     * 那么服务器是如何实现一个session为一个用户浏览器服务的？
     * 首先HTTP协议是无状态的，Session不能依据HTTP连接来判断是否为同一个用户。
     * 于是乎：服务器向用户浏览器发送了一个名为JESSIONID的Cookie，它的值是Session的id值。
     * 其实Session依据Cookie来识别是否是同一个用户。
     * 简单来说：Session 之所以可以识别不同的用户，依靠的就是Cookie
     * 该Cookie是服务器自动颁发给浏览器的，不用我们手工创建的。
     * 该Cookie的maxAge值默认是-1，也就是说仅当前浏览器使用，不将该Cookie存在硬盘中。
     */

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Book book = BookCollector.getBookById(id);

        //获得Session对象
        HttpSession session = request.getSession();
        List<Book> bookList = (List<Book>) session.getAttribute("list");

        //判断是否为空 若为空 则新建一个list并保存在session中
        if(bookList==null){
            bookList = new ArrayList<>();
            session.setAttribute("list",bookList);
        }
        bookList.add(book);
        //做跳转
        //encodeURL(String url)
        //encodeRedirectURL(String url)
        //

        String url = "/JavaWebLearn/showBuyBook";
        response.sendRedirect(response.encodeURL(url));
    }
}
