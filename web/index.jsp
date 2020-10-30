<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2020-10-27
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>学生管理系统</title>
    <link href="Mycss.css" type="text/css" rel="stylesheet" >
  </head>
  <body>
  <form method="post" action="loginServlet">
  <div id="main">
    欢迎来到学生管理系统，请输入账号密码:<br>
    <div>
      UserName：<input width="40px" type="text" name="mid" id="mid"> <br>
      PassWord： <input width="40px" type="text" name="psw" id="psw"> <br>
    </div>
      <input type="submit" name="确认" value="确认" style="margin-top: 40px">
  </div>
  </form>
  </body>
</html>
