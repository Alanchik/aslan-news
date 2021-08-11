<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Update</title>
</head>
<body>
<br><br>
<p align="center">
    | <a href="${pageContext.request.contextPath}/updateArticles">BACK</a> |
    <br><br>
<h1 align="center">Update Article: <td>${article.title}</td> </h1>
</p>
<br><br>
<br><br>
<form method="post" action="${pageContext.request.contextPath}/updateFormArticle?id=${article.id}" align="center">
    <input type="text" name="title" value="${article.title}">
    <br><br>
    <input type="text" name="text"  value="${article.text}">
    <br><br>
    <input type="submit" value="update" name="Update">
    <br><br>
    <div>${errorMessage}</div>
</form>
</body>
</html>
