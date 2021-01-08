<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/5/2021
  Time: 5:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="mail" action="/up" method="post">
    <label>Language: </label>
    <form:select path="language" items="${languages}"/>
    <br/>
    <br/>
    <label>
        Page size:
    </label>
    show <form:select path="pageSize" items="${spamsFilters}"/> emails per page
    <br/>
    <br/>
    <label>Spams filter: </label>
    <form:radiobutton path="spamsFilter" value="1" label="Enable spam filter"/>
    <br/>
    <br/>
    <label>Signature: </label>
    <form:textarea path="signature"/>
    <input type="submit">
</form:form>
</body>
</html>
