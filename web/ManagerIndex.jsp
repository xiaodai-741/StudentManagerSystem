<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2020-10-29
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员首页</title>
    <script type="text/css">
        td {
            font-size: 20px;
            height: 100px;
            width: 340px;
        }
        a{
            text-decoration: none;
        }
    </script>
</head>
<body>
<div>
    <table border="1" style="width: 1024px;height: 400px ; text-align: center;margin: auto">
        <tr>
            <td colspan="3"> 欢迎管理员使用本系统<br/>
                功能如下:
            </td>
        </tr>
        <tr>
            <td><a href="addStudent.jsp">增添学生信息</a></td>
            <td>删除学生信息</td>
            <td>修改学生信息</td>
        </tr>
        <tr>
            <td>查询学生信息</td>
            <td>增添管理员账号</td>
            <td>删除管理员账号</td>
        </tr>
        <tr>
            <td colspan="3">
               <a href="index.jsp"> 退出系统</a>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
