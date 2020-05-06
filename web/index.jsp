<%--
  Created by IntelliJ IDEA.
  User: 90617
  Date: 2020/4/27
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  hello java web
  <a href = "/JavaWebLearn/request">点我看资源</a>

  <br/><br/>
  <form action="/JavaWebLearn/form" method="post">
    <table>
      <tr>
        <td>用户名</td>
        <td><input type="text" name = "userName"></td>
      </tr>
      <tr>
        <td>密码</td>
        <td><input type="password" name = "password"></td>
      </tr>
      <tr>
        <td>性别</td>
        <td><input type="radio" name = "sex" value="男">男</td>
        <td><input type="radio" name="sex" value="女">女</td>
      </tr>
      <tr>
        <td>爱好</td>
        <td><input type="checkbox" name="hobbies" value="打球">打球</td>
        <td><input type="checkbox" name="hobbies" value="电子游戏">电子游戏</td>
        <td><input type="checkbox" name="hobbies" value="唱歌">唱歌</td>
      </tr>
      <input type="hidden" name="test" value="my name is yhs">

      <tr>
        <td>你来自哪</td>
        <td><input type="text" name="from"></td>
      </tr>
      <tr>
        <td><input type="submit" value="提交">提交</td>
        <td><input type="reset" value="重置">重置</td>
      </tr>
    </table>
  </form>

  <a href="/JavaWebLearn/form?username=yhs">使用get请求传递参数</a>

  <form action="/JavaWebLearn/demo" method="post">
    用户名:<input type="text" name="username"><br/>
    密码:<input type="password" name="password"><br/>
    <input type="submit" value="提交">提交
    <input type="reset" value="重置">重置
  </form>

  </body>
</html>
