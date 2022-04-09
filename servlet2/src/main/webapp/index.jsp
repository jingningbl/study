<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h3>EL的Song对象:${requestScope.song1.toString()}</h3>
<h3>EL的集合:${requestScope.list.toString()}</h3>
<h3>EL的数组:${requestScope.arr[0]}</h3>
</body>
</html>