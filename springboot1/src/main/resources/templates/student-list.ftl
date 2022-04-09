<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
学生列表freemarker
<h4>
    <#list stuList as item>
        ${item.id}====${item.name}
    </#list>
</h4>
</body>
</html>