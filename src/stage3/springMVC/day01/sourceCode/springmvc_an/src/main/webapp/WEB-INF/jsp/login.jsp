<%--
  Created by IntelliJ IDEA.
  User: 程兴霖
  Date: 2021/10/27
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/loginDo" method="post">
    <label>
        <input type="text" name="username">
    </label><br>
    <label>
        <input type="password" name="password">
    </label><br>
    <input type="submit" name="提交"><br>
</form>
</body>
</html>
