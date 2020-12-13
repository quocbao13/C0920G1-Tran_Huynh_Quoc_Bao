<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/13/2020
  Time: 6:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <h1>Simple Calculator</h1>
    <form method="get" action="calculator.jsp">
        First operand: <input type="text" name="a"/>
        <br/>
        Operator:
        <select name="select">
          <option value="+">+</option>
          <option value="-">-</option>
          <option value="*">*</option>
          <option value="/">/</option>
        </select>
        <br/>

        Second operand: <input type="text" name="b"/>
        <br/>

        <input type="submit" value="Calculate"/>
    </form>
  </body>
</html>
