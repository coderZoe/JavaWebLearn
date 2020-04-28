package Servlet;

/**
 * @author yhs
 * @date 2020/4/28 20:38
 * @description
 */
public class Class12GetWriterAndGetOutputStream {
    /**
     * getWriter()和getOutputStream()两个方法不能同时调用。如果同时调用就会出现异常
     *
     * Servlet程序向ServletOutputStream或PrintWriter对象中写入的数据将被Servlet引擎从response里面获取，
     * Servlet引擎将这些数据当作响应消息的正文，然后再与响应状态行和各响应头组合后输出到客户端。
     *
     * Servlet的serice()方法结束后【也就是doPost()或者doGet()结束后】，
     * Servlet引擎将检查getWriter或getOutputStream方法返回的输出流对象是否已经调用过close方法，
     * 如果没有，Servlet引擎将调用close方法关闭该输出流对象.
     */
}
