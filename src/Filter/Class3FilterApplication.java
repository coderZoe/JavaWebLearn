package Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import Servlet.Class23UserDemo;
/**
 * @author yhs
 * @date 2020/5/17 11:23
 * @description 过滤器应用
 */
@WebFilter(filterName = "filterLogin",urlPatterns = "/*")
public class Class3FilterApplication implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器3被创建");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("开始执行过滤器操作");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if(request.getSession().getAttribute("user")!=null){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        Cookie[] cookies = request.getCookies();
        String value = null;
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("autoLogin")){
                value = cookie.getValue();
            }
        }
        if(value!=null){
            String userName = (value.split("\\."))[0];
            String password = (value.split("\\."))[1];
            request.getSession().setAttribute("user",Class23UserDemo.getUSer(userName,password));
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("过滤器3被销毁");
    }
}
