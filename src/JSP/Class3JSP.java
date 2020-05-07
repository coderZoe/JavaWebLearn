package JSP;

/**
 * @author yhs
 * @date 2020/5/6 19:56
 * @description
 */
public class Class3JSP {
    /**
     * 笔记
     * JavaBean就是一个普通的java类，也称之为简单java对象--POJO（Plain Ordinary Java Object）
     * 是Java程序设计中一种设计模式，是一种基于 Java 平台的软件组件思想
     * 有无参的构造函数
     * 成员属性私有化
     * 封装的属性如果需要被外所操作，必须编写public类型的setter、getter方法
     *
     * JSP技术提供了三个关于JavaBean组件的动作元素，即JSP行为（标签），它们分别为
     * <jsp:useBean>【在JSP页面中查找javaBean对象或者实例化javaBean对象】
     * <jsp:setProperty>【设置javaBean的属性】
     * <jsp:getProperty>【获取javaBean的属性】
     *
     * 1.<jsp:useBean>
     * <jsp:useBean>标签用于在指定的域范围内查找指定名称的JavaBean对象
     * 存在则直接返回该JavaBean对象的引用。
     * 不存在则实例化一个新的JavaBean对象并将它以指定的名称存储到指定的域范围中
     * <jsp:useBean id="实例化对象的名称" class="类的全名" scope="保存范围"/>
     *
     * <jsp:setProperty>
     * <jsp:setProperty name="对象名称" property="属性名" param="参数名" value="值">
     *
     * <jsp:getProperty>
     * <jsp:getProperty name="对象名" property="属性名"/>
     */
    public static void main(String[] args) {

    }
}
