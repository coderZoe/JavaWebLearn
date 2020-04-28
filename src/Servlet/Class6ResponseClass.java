package Servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

/**
 * @author yhs
 * @date 2020/4/27 21:49
 * @description response对象 回复给浏览器
 */
@WebServlet(name = "Class6ResponseClass",urlPatterns = "/getResponse")
public class Class6ResponseClass extends HttpServlet {

    /**
     * request对象代表http请求，里面包含了浏览器提交过来的数据
     * response对象代表http响应，是我们向浏览器输出的数据
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /**
         * 字节流
         */
//
//        ServletOutputStream servletOutputStream = response.getOutputStream();
////        servletOutputStream.print("这是我的消息");
//        //上面的print方法会报错你 因为Tomcat无法对中文进行编码成二进制流
//
//        servletOutputStream.write(new String("这是我的消息").getBytes());
//        //但是这个方法不会返回错误 因为这个方法会先将你的字符串按gbk进行转码，再发给浏览器
//
//        //但我们一般用utf-8转码 不用gbk 所以
//        servletOutputStream.write(new String("这是我的消息").getBytes(StandardCharsets.UTF_8));
//        //但实际上面的数据是乱码 因为你按UTF-8发给浏览器 但浏览器是按gbk解码的 还需要在浏览器里设置将编码改为utf-8
//
//        //当然 我们不可能每次都设置浏览器来更改编码 我们可以设置http的消息头告诉浏览器 应该用何种编码形式进行解析信息
//        response.setHeader("Content-type","text/html;charset = UTF-8");
//        servletOutputStream.write(new String("这是设置了http头编码格式的消息").getBytes(StandardCharsets.UTF_8));

        /**
         * 字符流
         */
//        response.setContentType("text/html;charset=UTF-8");        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter printWriter = response.getWriter();
//        printWriter.write("这是字符流消息");   //同样会编码异常
        //同样我们可以设置头部信息进行编码

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.write("这是编码后的消息");
    }
}
