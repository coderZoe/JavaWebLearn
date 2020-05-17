package Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import Servlet.Class25MyRequest;
/**
 * @author yhs
 * @date 2020/5/17 12:38
 * @description
 */
@WebFilter(filterName = "Class4BadLanguageFilter",urlPatterns = "/*")
public class Class4BadLanguageFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //将request和response强转成http协议的
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        Class25MyRequest myRequest = new Class25MyRequest(httpServletRequest);
        //传送给目标资源的是被增强后的request对象
        filterChain.doFilter(myRequest, httpServletResponse);
    }

    @Override
    public void destroy() {

    }
}
