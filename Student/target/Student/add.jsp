<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/2/28
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加</title>
</head>
<body>
<form action="/AddServlet" method="post">
    <p>学号:<input type="text" name="id"></p>
    <p>姓名:<input type="text" name="name"></p>
    <p>性别:
        <input type="radio" name="sex">男
        <input type="radio" name="sex">女
    </p>
    <p>出生日期:<input type="text" name="birthdate"></p>
    <p>邮箱:<input type="text" name="email"></p>
    <p>备注:<input type="text" name="notes"></p>
    <p><input type="submit" value="提交"></p>
</form>

</body>
</html>
