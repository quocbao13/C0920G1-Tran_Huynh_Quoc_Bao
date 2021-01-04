<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/4/2021
  Time: 6:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/customers" method="post">
    <fieldset>
        <legend>Customer Information</legend>
        <input type="hidden" name="id" value="${customer.id}">
        <table>
            <tr>
                <td>Id</td>
                <td>
                    ${customer.id}
                </td>
            </tr>
            <tr>
                <td>Name</td>
                <td>
                    <input type="text" name="name" value="${customer.name}">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Update">
                </td>
            </tr>
        </table>
    </fieldset>
</form>
<a href="/customers">Back to list</a>.
</body>
</html>
