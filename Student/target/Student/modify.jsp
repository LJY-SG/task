<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/2/28
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改</title>
</head>
<body>

<form action="/ModifyServlet" method="post">
    <p>请输入要修改的学生的姓名:<input type="text" name="ModifyName"></p>
    <p><input type="submit" value="提交"></p>
</form>

</body>
</html>
