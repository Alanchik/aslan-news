<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Login Service</title>
</head>
<body>
<br><br>
<p align="center">
    <a href="${pageContext.request.contextPath}/articles">TO ARTICLES</a> |
    <a href="${pageContext.request.contextPath}/registration">TO REGISTRATION</a>
    <br><br>
<h1 align="center">LogIN</h1>
</p>
<br><br>
<br><br>
<form method="post" action="${pageContext.request.contextPath}/login" align="center">
    <input type="text" name="username" placeholder="Username" value="${username}">
    <br><br>
    <input type="password" name="password" placeholder="Password" value="${password}">
    <br><br>
    <input type="submit" value="confirm" name="Login">
    <br><br>
    <div>${errorMessage}</div>
</form>
</body>
</html>
