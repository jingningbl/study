<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/3/2
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>modelAndView</title>
</head>
<body>
提交的用户名为:${form.username}<br>
提交的用户喜欢的为:${form.goddess}<br>
从请求作用域拿到的用户名:${requestScope.form.username}<br>
从会话作用域拿到的用户名:${sessionScope.form.username}
</body>
</html>
