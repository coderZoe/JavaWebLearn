package Servlet;

import com.sun.deploy.net.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yhs
 * @date 2020/5/17 12:24
 * @description 重写HttpServletRequest类 由于Sun公司提供的request不够强大 所有我们需要重新定义自己需要的HttpServletRequest
 *              Sun公司为我们提供了HttpServletRequestWrapper类 只需要继承这个类 自己实现自己想实现的方法即可
 */
public class Class25MyRequest extends HttpServletRequestWrapper {
    private HttpServletRequest request;
    private List<String> list = Arrays.asList("共产党","笨蛋","SB");

    public Class25MyRequest(HttpServletRequest request) {
        super(request);
        this.request = request;
    }
    @Override
    public String getParameter(String name) {
        String value = this.request.getParameter(name);
        if(value==null){
            return null;
        }
        for(String string:list){
            if(value.contains(string)){
                value = value.replaceAll(string,"***");
            }
        }
        return value;
    }
}
