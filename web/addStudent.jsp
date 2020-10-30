<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2020-10-29
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生</title>
</head>
<body>
<form action="addStudent" method="post">
<table style="margin: auto">
    <tr>
        <td>学生编号</td>
        <td><input type="text" id="stuNO" name="stuNO"/></td>
    </tr>
    <tr>
        <td>学生姓名</td>
        <td><input type="text" id="SName" name="SName"/></td>
    </tr>
    <tr>
        <td>学生性别</td>
        <td><input type="text" id="Sex" name="Sex"/></td>
    </tr>
    <tr>
        <td>学生年龄</td>
        <td><input type="text" id="Age" name="Age"/></td>
    </tr>
    <tr>
        <td>学生密码</td>
        <td><input type="text" id="SPassWord" name="SPassWord"/></td>
    </tr>
    <tr>
        <td colspan="2" align="center">
            <input type="submit" value="提交"/>
            <input type="reset" value="重置"/>
        </td>
    </tr>
</table>
</form>
</body>
</html>
