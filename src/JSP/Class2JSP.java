package JSP;

/**
 * @author yhs
 * @date 2020/5/6 16:57
 * @description
 */
public class Class2JSP {
    /**
     * 笔记
     * JSP内置对象:
     * JSP引擎在调用JSP对应的jspServlet时，会传递或创建9个与web开发相关的对象供jspServlet使用
     * JSP技术的设计者为便于开发人员在编写JSP页面时获得这些web对象的引用，特意定义了9个相应的变量
     * 开发人员在JSP页面中通过这些变量就可以快速获得这9大对象的引用
     * pageContext page config request response session application exception out
     *
     * 1.out对象
     * out对象用于向浏览器输出数据，与之对应的是Servlet的PrintWriter对象
     * 然而这个out对象的类型并不是PrintWriter，是JspWriter 简单来说JspWriter就是带缓存的PrintWriter
     * 一般我们在JSP页面输出都是用表达式(<% %>)，所以out对象用得并不是很多
     *
     * 2.request对象
     * 内置对象request其实就是HttpServletRequest
     *
     * 3.response对象
     * 内置对象response其实就是HttpServletResponse
     *
     * 4.config对象
     * 内置对象config其实就是ServletConfig
     *
     * 5.session对象
     * 内置对象session其实就是HttpSession
     * <%@page session="false" %> 设置session不可用
     *
     * 6.application对象
     * 内置对象application其实就是ServletContext对象
     *
     * 7.page对象
     * 内置对象page是HttpJasPage对象 其实page对象代表的就是当前JSP页面，是当前JSP编译后的Servlet类的对象。也就是说：page对象相当于普通java类的this
     *
     * 8.exception对象
     * 内置对象exception是java.lang.Exception类的对象，exception封装了JSP页面抛出的异常信息 exception经常被用来处理错误页面
     *
     * 9.pageContext对象
     * pageContext是内置对象中最重要的一个对象，它代表着JSP页面编译后的内容(也就是JSP页面的运行环境)
     * 我们可以通过pageContext对象获得其他八个对象
     *
     * pageContext作为域对象
     * 类似于request，session，ServletContext作为域对象而言都有以下三个方法：
     * setAttribute(String name,Object o)
     * getAttribute(String name)
     * removeAttribute(String name)
     *
     * 作为域对象而言，它就代表着当前JSP页面（也就是page）
     * 也就是说：pageContext域对象只在page范围内有效，超出了page范围就无效了
     *
     * 引用和跳转
     * PageContext类中定义了一个forward方法和两个include方法来分别简化和替代RequestDispatcher.forward方法和include方法
     * pageContext.forward(String url)
     * pageContext.include(String url)
     *
     * 4种属性范围
     * page【只在一个页面中保存属性，跳转页面无效】
     * request【只在一次请求中保存属性，服务器跳转有效，浏览器跳转无效】
     * session【在一个会话范围中保存属性，无论何种跳转均有效，关闭浏览器后无效】
     * application【在整个服务器中保存，所有用户都可以使用】
     *
     * 4个内置对象都支持以下的方法：
     * setAttribute(String name, Object o )
     * getAttribute(String name)
     * removeAttribute(String name)
     */
    public static void main(String[] args) {

    }
}
