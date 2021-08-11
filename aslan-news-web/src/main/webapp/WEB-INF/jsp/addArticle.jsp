<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Add Article</title>
</head>
<body>
<br><br>
<p align="center">
   | <a href="${pageContext.request.contextPath}/articles">TO ARTICLES</a> |
    <br><br>
<h1 align="center">Add Article</h1>
</p>
<br><br>
<br><br>
<form method="post" action="${pageContext.request.contextPath}/addArticle" align="center">
    <input type="text" name="title" placeholder="enter title" value="${title}">
    <br><br>
    <input type="text" name="text" placeholder="enter text" value="${text}" >
    <br><br>
    <input type="submit" value="confirm" name="Article">
    <br><br>
    <div>${errorMessage}</div>
</form>
</body>
</html>
