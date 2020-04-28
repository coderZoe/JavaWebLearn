package Servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @author yhs
 * @date 2020/4/28 14:40
 * @description
 */
@WebServlet(name = "Class7Download",urlPatterns = "/download")
public class Class7Download extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = this.getServletContext().getRealPath("/WEB-INF/resource/picture/西电.jpeg");
        String fileName = path.substring(path.lastIndexOf("\\") + 1);
        //告诉浏览器这是一个下载请求
        response.setHeader("Content-Disposition", "attachment; filename="+ URLEncoder.encode(fileName,"UTF-8"));
        try(FileInputStream fileInputStream = new FileInputStream(path);
            ServletOutputStream servletOutputStream = response.getOutputStream();) {
            int len = -1;
            byte[] bytes = new byte[1024];
            while ((len = fileInputStream.read(bytes))!=-1){
                servletOutputStream.write(bytes,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
