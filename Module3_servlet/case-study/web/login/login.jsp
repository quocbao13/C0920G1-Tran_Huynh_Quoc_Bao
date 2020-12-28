<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/25/2020
  Time: 3:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Bookshop Website</title>
</head>
<body>
<div style="text-align: center">
    <h1>Admin Login</h1>
    <form action="/login" method="post">
        <label >Email:</label>
        <input type="text" name="username" size="30" />
        <br><br>
        <label >Password:</label>
        <input type="password" name="password" size="30" />
        <br>${message}
        <br><br>
        <button type="submit">Login</button>
    </form>
</div>
<script
        src="https://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
        crossorigin="anonymous"></script>
<script type="text/javascript"
        src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js"></script>
<script type="text/javascript">

    $(document).ready(function() {
        $("#loginForm").validate({
            rules: {
                email: {
                    required: true,
                    email: true
                },

                password: "required",
            },

            messages: {
                email: {
                    required: "Please enter email",
                    email: "Please enter a valid email address"
                },

                password: "Please enter password"
            }
        });

    });
</script>
</body>
</html>