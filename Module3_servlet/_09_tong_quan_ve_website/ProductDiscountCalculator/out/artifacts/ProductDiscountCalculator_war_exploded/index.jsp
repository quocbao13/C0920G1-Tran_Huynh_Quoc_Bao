<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/11/2020
  Time: 8:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <form action="/calculator" method="post">
        Product Name: <input type="text" name="nameProduct"/>
        List Price: <input type="text" name="listPrice"/>
        Discount Percent: <input type="text" name="discountPercent"/>
      <input type="submit" id="submit" value="Action"/>
    </form>
  </body>
</html>
