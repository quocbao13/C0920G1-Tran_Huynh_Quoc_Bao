<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/4/2021
  Time: 4:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/relay" method="post">
    <input type="text" name="num1">
    <input type="text" name="num2">
    <input type="submit" value="Addition" name="ans">
    <input type="submit" value="Subtraction" name="ans">
    <input type="submit" value="Multiplication" name="ans">
    <input type="submit" value="Division" name="ans">
</form>
<p>Answer: ${result}</p>
</body>
</html>
