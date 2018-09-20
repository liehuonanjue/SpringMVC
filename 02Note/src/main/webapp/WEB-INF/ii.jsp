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
<h1>${p}</h1>
<a href="/mvc/add?name">新增</a>
<a href="/mvc/update?name=1&pwd=2">修改</a>
<a href="/mvc/delete?name=a">删除</a>
<a href="/mvc/select1">查询mod2</a>
<a href="/mvc/select2">查询mod1</a>
<form action="/mvc/studen/2/2" method="post">
    <input type="text" name="idd">
    <input type="password" name="nam">
    <input type="submit" value="登陆">
</form>


<c:forEach items="${bookList}" var="node">
    <c:out value="${node}"></c:out>
</c:forEach>
<br/>
<br/>

<!-- 输出Map -->
<c:forEach items="${map}" var="node">
    姓名：<c:out value="${node.key}"></c:out>
    住址：<c:out value="${node.value}"></c:out>
    <br/>
</c:forEach>

${a}
${b}
${c}
${d}
</body>
</html>
