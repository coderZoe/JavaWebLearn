package JSP;

/**
 * @author yhs
 * @date 2020/5/6 20:39
 * @description
 */
public class Class4EL {
    /**
     * EL表达式:
     * EL表达式是用"${}"括起来的脚本 用来更方便的读取对象
     * EL表达式主要用来读取数据，进行内容的显示
     *
     * ServletContext对象方法findAttribute(String name),EL表达式语句在执行的时候会调用该方法，
     * 用标识符作为关键字分别从page、request、session、application四个域中查找相应的对象。
     * 这也解释了为什么EL表达式可以仅仅通过标识符就能够获取到存进域对象的数据
     * findAttribute()的查找顺序：从小到大，也就是page->request->session->application
     *
     * EL表达式主要是来对内容的显示，为了显示的方便，EL表达式提供了11个内置对象
     * pageContext    对应于JSP页面中的pageContext对象（注意：取的是pageContext对象）
     * pageScope    代表page域中用于保存属性的Map对象
     * requestScope    代表request域中用于保存属性的Map对象
     * sessionScope    代表session域中用于保存属性的Map对象
     * applicationScope    代表application域中用于保存属性的Map对象
     * param    表示一个保存了所有请求参数的Map对象
     * paramValues表示一个保存了所有请求参数的Map对象，它对于某个请求参数，返回的是一个string[]
     * header    表示一个保存了所有http请求头字段的Map对象
     * headerValues同上，返回string[]数组。
     * cookie    表示一个保存了所有cookie的Map对象
     * initParam    表示一个保存了所有web应用初始化参数的map对象
     *
     * EL表达式最大的特点就是：如果获取到的数据为null，输出空白字符串""！这个特点可以让我们数据回显
     *
     * EL自定义函数
     *
     * EL函数库(fn函数库)
     * EL函数库就是fn方法库，是JSTL标签库中的一个库
     * fn方法库全都是跟字符串有关的（可以把它想成是String的方法）
     * fn:toLowerCase
     * fn:toUpperCase
     * fn:trim
     * fn:length
     * fn:split
     * fn:join 【接收字符数组，拼接字符串】
     * fn:indexOf
     * fn:contains
     * fn:startsWith
     * fn:replace
     * fn:substring
     * fn:substringAfter
     * fn:endsWith
     * fn:escapeXml【忽略XML标记字符】
     * fn:substringBefore
     */
    public static void main(String[] args) {

    }
}
