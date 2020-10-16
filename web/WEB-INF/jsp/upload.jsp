<%--
  Created by IntelliJ IDEA.
  User: lxl
  Date: 2020/9/27
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>测试文件上传</title>
</head>
<body>
<form action="/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="picture">
    <input type="submit" value="上 传">
</form>
</body>
</html>
