<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/16/2020
  Time: 7:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete</title>
</head>
<body>
<h1>Delete</h1>
<a href="/products">Back to list</a>
<c:if test="${requestScope['message'] != null}">
    <script>
        alert('${requestScope["message"]}');
    </script>
</c:if>
<form method="post">
    <div>
        <label>Name:</label>
        <input type="text" name="name" value="${requestScope["product"].getName()}"/>
    </div>
    <div>
        <label>Price:</label>
        <input type="text" name="price" value="${requestScope["product"].getPrice()}"/>
    </div>
    <div>
        <label>Brand:</label>
        <input type="text" name="brand" value="${requestScope["product"].getBrand()}"/>
    </div>
    <input type="submit" value="Delete"/>
</form>
</body>
</html>
