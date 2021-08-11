<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<p align="center">
    | <a href="${pageContext.request.contextPath}/articles">TO ARTICLES</a> |
</p>
<br><br>
<br><br>
<h4>
    <div align="center">${article.title}</div>
</h4>
<div align="center">${article.text}</div>
<h5><div align="center"><fmt:setLocale value="en-EN"/>
    <fmt:parseDate value="${article.date}" pattern="yyyy-MM-dd" var="parsedDate" type="date"/>
    <fmt:formatDate value="${parsedDate}"/></div>
</h5>
</body>
</html>
