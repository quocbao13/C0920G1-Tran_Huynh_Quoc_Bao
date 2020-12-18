<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/15/2020
  Time: 4:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<h1>Edit</h1>
<a href="/products">Back to list</a>
<c:if test="${requestScope['message'] != null}">
    <span>${requestScope["message"]}</span>
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
        <input type="submit" value="Edit"/>
    </form>
</body>
</html>
