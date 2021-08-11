<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Aslan-News</title>
</head>
<body>

<h1 align="center">HELLO HONEY ${user.username} NICE TO SEE YOU</h1>
<table align="center">
    <td><a href="${pageContext.request.contextPath}/registration">| REGISTRATION |</a></td>
    <td><a href="${pageContext.request.contextPath}/login">| LOGIN |</a></td>
    <td><a href="${pageContext.request.contextPath}/addArticle">| ADD ARTICLE |</a></td>
    <td><a href="${pageContext.request.contextPath}/deleteArticles">| DELETE ARTICLE |</a></td>
    <td><a href="${pageContext.request.contextPath}/updateArticles">| UPDATE ARTICLE |</a></td>
    <td><a href="${pageContext.request.contextPath}/findArticle">| FIND ARTICLE |</a></td>
    <td><a href="${pageContext.request.contextPath}/logout">|LOGOUT |</a></td>
</table>
<br><br>
<br><br>
<table>
    <tr>
        <th>title</th>
        <th>text</th>
        <th>date</th>
        <th>author</th>

    </tr>
    <c:forEach items="${articles}" var="article">
        <tr>
            <td><a href="${pageContext.request.contextPath}/article?title=${article.title}">${article.title}</a></td>
            <td>${article.text}</td>
            <td>
                    <fmt:setLocale value="en-EN"/>
                    <fmt:parseDate value="${article.date}" pattern="yyyy-MM-dd" var="parsedDate" type="date"/>
                    <fmt:formatDate value="${parsedDate}"/>
            <td>${article.author.username}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
