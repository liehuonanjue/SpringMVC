<%--
  Created by IntelliJ IDEA.
  User: 齐亮
  Date: 2018/9/16
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/mvc/studen1/login" method="post">
    <input type="text" name="idd">
    <input type="password" name="nam">
    <input type="submit" value="登陆">
</form>
<form action="/mvc/studen2/login" method="post">
    <input type="text" name="idd">
    <input type="password" name="nam">
    <input type="submit" value="登陆">
</form>

<form action="/mvc/studen3/login" method="post">
    <input type="text" name="idd">
    <input type="password" name="nam">
    <input type="submit" value="登陆">
</form>

</body>
</html>
