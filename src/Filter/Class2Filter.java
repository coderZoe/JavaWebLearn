package Filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author yhs
 * @date 2020/5/17 10:59
 * @description
 */
public class Class2Filter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器2被创建");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器2被执行");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("过滤器2执行完毕 得到返回");
    }

    @Override
    public void destroy() {
        System.out.println("过滤器2被销毁");
    }
}
