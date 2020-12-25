<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/18/2020
  Time: 3:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../../assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../assets/bootstrap/datatables/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
          integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA=="
          crossorigin="anonymous" />
</head>
<body>
<div class="wrapper ">

    <jsp:include page="/admin/shared/menuLeft.jsp"/>
    <div class="main-panel">
        <!-- Navbar -->
        <jsp:include page="/admin/shared/header.jsp"/>
        <!-- End Navbar -->
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-12 text-center">
                        <h1>CREATE POSITION</h1>
                    </div>
                    <c:if test='${requestScope["message"] != null}'>
                        <span class="col-12 border bg-light">${requestScope["message"]}</span>
                    </c:if>
                    <form class="col-12" method="post">
                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-1" for="exampleInputName">Name:</label>
                            <input type="text" name="employee_name" class="form-control col-12 float-left "
                                   id="exampleInputName" placeholder="Ex: Saw Home">
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-4" for="exampleInputBirthday">Birthday:</label>
                            <input type="date" name="employee_brithday" class="form-control col-12 float-left "
                                   id="exampleInputBirthday" placeholder="Ex: 2000-01-01">
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-4" for="exampleInputCard">Id card:</label>
                            <input type="text" name="employee_id_card" class="form-control col-12 float-left "
                                   id="exampleInputCard" placeholder="Ex: 20495xxxx">
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-4" for="exampleInputSalary">Salary:</label>
                            <input type="text" name="employee_salary" class="form-control col-12 float-left "
                                   id="exampleInputSalary" placeholder="Ex: 200000xxx">
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-4" for="exampleInputPhone">Phone:</label>
                            <input type="text" name="employee_phone" class="form-control col-12 float-left "
                                   id="exampleInputPhone" placeholder="Ex: 0987657xxx">
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-4" for="exampleInputEmail">Email:</label>
                            <input type="text" name="employee_email" class="form-control col-12 float-left"
                                   id="exampleInputEmail" placeholder="Ex: abc@gmail.com">
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-4" for="exampleInputAddress">Address:</label>
                            <input type="text" name="employee_address" class="form-control col-12 float-left "
                                   id="exampleInputAddress" placeholder="74/23 Abc">
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-4" for="exampleInputPosition">Position:</label>
                            <select name="position_id" id="exampleInputPosition" class="form-control col-12 float-left">
                                <option>Chose option ...</option>
                                <c:forEach var="position" items="${requestScope['positions']}">
                                    <option value="${position.getId()}">${position.getName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-4" for="exampleInputEducation">Education level:</label>
                            <select name="education_degree_id" id="exampleInputEducation" class="form-control col-12 float-left">
                                <option>Chose option ...</option>
                                <c:forEach var="educationLevel" items="${requestScope['educationLevels']}">
                                    <option value="${educationLevel.getId()}">${educationLevel.getName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-4" for="exampleInputDivision">Division:</label>
                            <select name="division_id" id="exampleInputDivision" class="form-control col-12 float-left">
                                <option>Chose option ...</option>
                                <c:forEach var="division" items="${requestScope['divisions']}">
                                    <option value="${division.getId()}">${division.getName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-4" for="exampleInputUser">User:</label>
                            <input type="text" name="username" class="form-control col-12 float-left "
                                   id="exampleInputUser" placeholder="Enter User">
                        </div>
                        <button type="submit" class="btn btn-primary float-right">Create</button>
                        <a href="/admin/employees"><button type="button" class="btn btn-info float-right">Back</button></a>
                    </form>
                </div>
            </div>
        </div>
        <%-- Footer --%>
    </div>
</div>
<script src="../../assets/bootstrap/jquery/jquery-3.5.1.min.js"></script>
<script src="../../assets/bootstrap/js/popper.min.js"></script>
<script src="../../assets/bootstrap/datatables/js/jquery.dataTables.min.js"></script>
<script src="../../assets/bootstrap/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="../../assets/bootstrap/js/bootstrap.min.js"></script>
<script src="../../assets/bootstrap/js/bootstrap.bundle.js"></script>
</body>
</html>
