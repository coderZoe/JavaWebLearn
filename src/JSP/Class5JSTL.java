package JSP;

/**
 * @author yhs
 * @date 2020/5/7 8:50
 * @description
 */
public class Class5JSTL {
    /**
     * 笔记
     * JSTL全称为 JSP Standard Tag Library 即JSP标准标签库
     * JSTL作为最基本的标签库，提供了一系列的JSP标签，实现了基本的功能：集合的遍历、数据的输出、字符串的处理、数据的格式化等等
     *
     * core标签库是JSTL的核心标签库，实现了最基本的功能：流程控制、迭代输出等操作！
     * core标签库的前缀一般是c
     *
     * c:out属性
     * value指定输出内容 escapeXml 是否将> < & 等字符进行HTML转码再输出 默认true
     * default: 指定如果过value的属性值为null时所输出的默认值
     * <c:out value="${name}"default=您要找的数据没找到"escapeXml="true"/>
     *
     * c:set属性
     * value 指定属性的值
     * var 指定要设置的web域属性的名称
     * scope 用于指定那个属性所在的web域
     * target 用于指定要设置属性的对象 这个对象必须是JavaBean或java.util.Map对象
     * property 用于指定当前要为对象设置的属性名称
     * <c:set var="name"value="fucheng"scope="page"/>
     * <c:set var="name"scope="page">
     *     zhongfucheng
     * </c:set>
     *
     * target属性与之配对的是property属性 target属性只能操作JavaBean或Map对象 property就是对应的成员变量或key
     * <jsp:useBean id="person"class="domain.Person"scope="session"/>
     * <c:set target= "${person}" property="age" value="32"/>
     * ${person.age}
     *
     * c:remove
     * <c:remove var="person"scope="session"></c:remove>
     *
     * c:catch
     * <jsp:useBean id = "person" class = "JSP.person" scope="session"/>
     * <c:catch var = message>
     *      <c:set target="person" property="age" value = "32"/>
     * </c:catch>
     * ${message}
     *
     * c:if
     * <c:if test = ""></c:if>
     *
     * c:choose
     * <c:choose>
     *     <c:when test=""></c:when>
     *     <c:when test=""></c:when>
     *     <c:otherwise></c:otherwise>
     * </c:choose>
     *
     * c:forEach 属性
     * var 当前迭代元素在page中的名字
     * items 迭代的集合对象
     * begin 开始迭代的位置 默认0
     * end 结束迭代的位置 默认最后一个元素
     * step:迭代的步速 默认1(1个1个迭代 不跳)
     * varStatus: 记录当前被遍历对象的信息
     * 包含:
     * 1.index【返回当前是第几个对象，从0开始计数】
     * 2.count【已经遍历多少个对象了，从1开始计数】
     * 3.first【是否是第一个】
     * 4.last【是否是最后一个】
     * 5.current【当前被迭代的对象】
     * 6.begin【开始的位置】
     * 7.end【最后的位置】
     * 8.step【步长】
     * <c:forEach var="item" items="${mapList}" begin="0" end="5" step="1" varStatus="state">
     *     ${item} ${state.index}
     * </c:forEach>
     *
     * c:forTokens
     * 该标签类似于String类的split()和for循环的一种集合
     * 它与forEach标签非常相似，都有begin、end、step、items、var、varStatus属性
     * 不同的是forTokens标签的items属性里面是字符串，这个字符串会被delims属性的内容分割成多个字符串
     * <c:forTokens items="zhongfucheng,ouzicheng,xiaoming,xiaohong" var="name" delims="," >
     *       ${name}
     * </c:forTokens>
     *
     * c:import
     * import标签类似于JSP行为<jsp:include/>和JSP指令<%include
     * import标签的属性：
     * url【指定要包含的路径，Internet所有的url都可以】
     * context【访问同一个web容器的其他资源，以"/"开头】
     * var【保存导入的文件的内容，以String类型存储】
     * socpe【保存的范围，默认是page】
     * charEncoding【字符编码】
     * varReader【保存导入文件的内容，以Reader类型存储】
     * import标签功能更加更大 import标签可以引入Internet网页上的内容​
     *   <c:import url="http://www.csdn.net" charEncoding="UTF-8" />
     *
     * c:param
     */
    public static void main(String[] args) {

    }
}
