package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @author yhs
 * @date 2020/4/29 14:47
 * @description cookie
 */
@WebServlet(name = "Class16Cookie",urlPatterns = "/cookie")
public class Class16Cookie extends HttpServlet {
    /**
     * 会话：指用户开一个浏览器，访问一个网站,只要不关闭该浏览器，不管该用户点击多少个超链接，访问多少资源，直到用户关闭浏览器，整个这个过程我们称为一次会话
     * 会话跟踪技术有cookie和session
     * 我们都知道Http是无状态的数据传输协议 一旦浏览器和服务器完成了一次Http交互 连接就会关闭 再次建立Http请求的时候 服务器无法确定连接的用户信息
     * w3c提出了cookie的概念 cookie是说如果服务器需要记录用户的状态 就使用response向用户浏览器颁布一个通行证(cookie) 浏览器会将通行证保存起来
     * 当浏览器再次访问服务器的时候 浏览器会把请求和cookie一同交给服务器
     *
     * cookie具有不可跨域性 简单来说就是一个网站的cookie 你不会提交给另一个网站的服务器
     *
     * cookie的有效期通过setMaxAge(int time)函数来设置
     * 当time的值是负的时候 cookie的值是临时性的 仅在本浏览器内有效 关闭浏览器就失效了 cookie也不会写到硬盘中 其中创建cookie时提供的默认值就是-1
     * 当time = 0 时表示删除该cookie cookie并没有提供删除机制 通过setMaxAge(0)达到删除的目的
     * 当time是正数时 浏览器会将cookie写入硬盘中 只要还在time秒前登录该网站就有效
     *
     * cookie的修改
     * cookie不存在修改的方法 只存在覆盖的方法 当cookie的名相同通过response返给浏览器存储 原同名cookie就会被覆盖
     * 注意：
     * 删除，修改Cookie时，新建的Cookie除了value、maxAge之外的所有属性都要与原Cookie相同
     * 否则浏览器将视为不同的Cookie，不予覆盖，导致删除修改失败
     *
     * cookie本身可以被该项目下的所有web资源获取
     * 但cookie的path属性可以设置只能某个资源获取cookie 其他不可以
     * cookie.setPath("/getCookie") 这样只有getCookie路径的资源才能访问cookie 其他不允许
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //创建cookie 设置编码格式 避免乱码
        Cookie cookie = new Cookie("username", URLEncoder.encode("殷华盛", "UTF-8"));  //key value的形式创建
        cookie.setMaxAge(1000*3600);    //设置cookie的有效期

        //将cookie加入response 并返给浏览器
        response.addCookie(cookie);
        response.getWriter().write("我颁给了浏览器一个cookie");
    }
}
