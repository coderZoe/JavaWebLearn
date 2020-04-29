package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author yhs
 * @date 2020/4/29 11:09
 * @description 处理表单提交问题
 */
@WebServlet(name = "Class14FormRequest",urlPatterns = "/form")
public class Class14FormRequest extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        //获得form表单提交的信息
        String userName = request.getParameter("userName");
        System.out.println("userName"+userName);
        String password = request.getParameter("password");
        System.out.println("password"+password);
        String sex = request.getParameter("sex");
        System.out.println("sex"+sex);
        String[] hobbies = request.getParameterValues("hobbies");
        System.out.println("hobbies"+ Arrays.toString(hobbies));
        String hiddenInfo = request.getParameter("test");
        System.out.println("hiddenInfo"+hiddenInfo);
        String from = request.getParameter("from");
        System.out.println("from"+from);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //这里尝试通过get请求来传递信息
        //get请求传递信息的方式是通过url+?+参数
        //与post不同 get请求会将参数信息出现在地址栏

        request.setCharacterEncoding(StandardCharsets.UTF_8.toString());

        String userName = request.getParameter("username");

        String userName1 = (String) request.getAttribute("username");
        System.out.println("userName:"+userName1);
    }
}
