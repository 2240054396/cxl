<%--
  Created by IntelliJ IDEA.
  User: 程兴霖
  Date: 2021/10/28
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/upload" method="post" enctype="multipart/form-data">
    <label>
        <input type="text" name="name">
    </label><br>
    <label>
        <input type="file" name="photo" multiple="multiple">
    </label><br>
    <input type="submit" name="提交"><br>
</form>
</body>
</html>
