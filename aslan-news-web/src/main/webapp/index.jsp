<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Form</title>
</head>
<body >
<c:redirect url="/articles"/>
<br><br>
<br><br>
<br><br>
<form action="info" method="post" align="center">
    Name: <input name="username" />
    <br><br>
    Age: <input name="userage" />
    <br><br>
    Gender: <input type="radio" name="gender" value="female" checked />Female
    <input type="radio" name="gender" value="male" />Male
    <br><br>
    Country: <select name="country">
    <option>Canada</option>
    <option>USA</option>
    <option>UK</option>
    <option>Australia</option>
</select>
    <br><br>
    Activity:
    <input type="checkbox" name="activity" value="IT" checked />IT
    <input type="checkbox" name="activity" value="Business" checked />Business
    <input type="checkbox" name="activity" value="Art" checked />Art
    <br><br>
    <input type="submit" value="Submit" />
</form>
</body>
</html>
