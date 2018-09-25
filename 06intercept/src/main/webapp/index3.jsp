<%--
  Created by IntelliJ IDEA.
  User: 齐亮
  Date: 2018/9/16
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/file" method="post" enctype="multipart/form-data">
    <input type="file" name="file"/>
    <input type="file" name="file"/>
    <input type="file" name="file"/>
    <input type="file" name="file"/>
    <input type="submit" value="上传">
</form>
<form action="/download" method="post" enctype="multipart/form-data">
    <input type="file" name="fileName"/>
    <input type="submit" value="下载">
</form>

<a href="download?filename=favicon.ico">
    用户头像：<img src="js/favicon.ico">
</a>
</body>
</html>
