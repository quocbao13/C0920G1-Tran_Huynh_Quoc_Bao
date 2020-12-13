<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/13/2020
  Time: 6:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
    <%String a = request.getParameter("a");%>
    <%String b = request.getParameter("b");%>
    <%String opera = request.getParameter("select");%>
    <%
        double c = 0;
        switch (opera) {
            case "+": c = Double.parseDouble(a) + Double.parseDouble(b);
                break;
            case "-": c = Double.parseDouble(a) - Double.parseDouble(b);
                break;
            case "*": c = Double.parseDouble(a) * Double.parseDouble(b);
                break;
            case "/": try {
                    c = Double.parseDouble(a) / Double.parseDouble(b);
                }catch (ArithmeticException m){
                    m.getMessage();
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + opera);
        }
        out.print("Ans = " + c);
    %>
</body>
</html>
