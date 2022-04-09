<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">欢迎${sessionScope.username},您是第${applicationScope.count}个用户</a>
<a href="logout">注销</a>
</body>
</html>