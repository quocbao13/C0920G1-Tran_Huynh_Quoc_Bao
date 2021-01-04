<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/4/2021
  Time: 6:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<style>
    table {
        border: 1px solid #000;
    }

    th, td {
        border: 1px dotted #555;
    }
</style>
There are ${requestScope.customerList.size()} customer(s) in list.
<table>
    <caption>Customers List</caption>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="c" items="${requestScope.customerList}">
        <tr>
            <td>
                <c:out value="${c.id}"/>
            </td>
            <td>
                <a href="/customers/${c.id}">${c.name}</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
