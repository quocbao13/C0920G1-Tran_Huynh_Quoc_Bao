<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/4/2021
  Time: 3:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/save" method="post">
    <input type="checkbox" id="vehicle1" name="condiment" value="Lettuce">
    <label for="vehicle1"> I have a Lettuce</label><br>
    <input type="checkbox" id="vehicle2" name="condiment" value="Tomato">
    <label for="vehicle2"> I have a Tomato</label><br>
    <input type="checkbox" id="vehicle3" name="condiment" value="Mustard">
    <label for="vehicle3"> I have a Mustard</label><br>
    <input type="checkbox" id="vehicle4" name="condiment" value="Sprouts">
    <label for="vehicle4"> I have a Sprouts</label><br><br>
    <input type="submit" value="Submit">
</form>
${ans}
</body>
</html>
