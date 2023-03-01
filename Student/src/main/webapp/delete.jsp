<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/2/28
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除</title>
</head>
<body>

<form action="/DeleteServlet" method="post">
<p>请输入要删除的学生的姓名:<input type="text" name="deleteName"></p>
    <p><input type="submit" value="提交"></p>
</form>

</body>
</html>
