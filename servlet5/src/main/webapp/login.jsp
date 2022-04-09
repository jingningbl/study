<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/12/15
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<script src="./login.js"></script>
<body>
<h3>登录</h3>
<form action="login" method="get">
    用户名: <input type="text" name="username" id="username"> <br>
    密码: <input type="password" name="password" id="password"> <br>
    记住密码: <input type="checkbox" name="mycheckbox" id="mycheckbox" checked="checked"> <br>
    <input type="submit" value="登录">
</form>
</body>
</html>
