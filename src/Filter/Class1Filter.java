package Filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yhs
 * @date 2020/5/17 10:36
 * @description
 */
public class Class1Filter implements Filter {
    /**
     * 笔记
     * 过滤器是实现Filter接口的Java类
     * 一般情况下 浏览器向Web服务器发送请求 Web服务器向Web资源(JSP Servlet Html等)发送请求 得到返回
     * 过滤器是加在Web服务器和Web资源之间的 Web服务器先去经过过滤器 过滤器处理后再发送给Web资源 同理 Web资源返回会先经过过滤器 再回给Web服务器
     * 过滤器常用功能:过滤敏感字符串 避免乱码 权限验证等
     * 同Servlet一样: 过滤器也需要配置Mapping映射 在这个映射路径下的所有请求都会先经过过滤器 当然 不走这个映射路径 过滤器不会被加载
     * 不同于Servlet Servlet是第一次被访问的时候创建 过滤器是随着Web项目本身的执行而创建
     *
     * 通过下面的链式调用过滤器可以看到 下发流程为:
     * 浏览器->服务器->Filter1->Filter2->Servlet
     * 返回流程为:
     * Servlet->Filter2->Filter1->服务器->浏览器
     * 过滤器之间的执行顺序看在web.xml文件中mapping的先后顺序的 如果放在前面就先执行，放在后面就后执行！
     * 如果是通过注解的方式配置，就比较urlPatterns的字符串优先级
     *
     * Filter的三种典型应用:
     * filter根据条件来决定是否调用doFilter方法 这样可以决定是否让请求可以访问目标资源
     * 在目标资源执行前 对request和response做一些预处理 再提交给目标资源
     * 在目标资源执行后 对request或response做一些处理 再返回给服务器
     */

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器1被加载");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //实现编码的过滤 这样就不用在每个Servlet中重写一遍了
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=utf-8");
        System.out.println("我是过滤器1");

        //设置不加载缓存
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        response.setDateHeader("Expires", -1);
//        response.setHeader("Cache-Control", "no-cache");
//        response.setHeader("Pragma", "no-cache");

        //Filter在Java中是链式的结构 我们将所有的Filter都放到了filterChain里 这样就是说 我这个过滤器执行完了 该执行下一个过滤器了 要是都执行完了 那就访问目标资源
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("过滤器1执行完毕并返回");
    }

    @Override
    public void destroy() {
        System.out.println("过滤器1被销毁");
    }
}
