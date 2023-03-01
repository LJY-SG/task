<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/2/28
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示</title>
</head>
<body>
确实要查看学生信息吗？:
<form action="/ShowServlet" method="post">
    <input type="submit" value="确定">
</form>
<button><a href="index.jsp">退出</a></button>
</body>
</html>
