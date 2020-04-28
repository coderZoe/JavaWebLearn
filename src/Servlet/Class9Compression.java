package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/**
 * @author yhs
 * @date 2020/4/28 17:45
 * @description
 */
@WebServlet(name = "Class9Compression",urlPatterns = "/compress")
public class Class9Compression extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //对数据进行压缩 返给浏览器 浏览器再进行解码展示

        //gzip函数是一种压缩方式 他通过接受源数据的字节流，将源数据字节流写到一个字节输出流内 可以看出gzip是属于IO装饰流
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gzipOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        String path = this.getServletContext().getRealPath("/WEB-INF/resource/picture/西电.jpeg");
        FileInputStream inputStream = new FileInputStream(path);

        int len = -1;
        byte[] bytes = new byte[1024];
        while ((len = inputStream.read(bytes))!=-1){
            gzipOutputStream.write(bytes,0,len);
        }
        //取出gzip写入后压缩的字节 传给浏览器
        byte[] result = byteArrayOutputStream.toByteArray();
        System.out.println(result.length);

        //告诉浏览器压缩格式 用于浏览器解析
        response.setHeader("Content-Encoding","gzip");
        response.getOutputStream().write(result);

        //关闭资源
        inputStream.close();
        gzipOutputStream.close();
    }
}
