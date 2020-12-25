<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/21/2020
  Time: 8:54 AM
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
                        <h1>EDIT CONTRACT</h1>
                    </div>
                    <form class="col-12" method="post">
                        <div class="form-group col-12">
                            <label class="col-12 float-left" for="exampleInputName">Start date:</label>
                            <input type="date" name="contract_start_date" class="form-control col-12 float-left mt-1"
                                   id="exampleInputName" placeholder="Enter Start date...">
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-4" for="exampleInputBirthday">End date:</label>
                            <input type="date" name="contract_end_date" class="form-control col-12 float-left"
                                   id="exampleInputBirthday" placeholder="Enter End date...">
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-4" for="exampleInputCard">Deposit:</label>
                            <input type="text" name="contract_deposit" class="form-control col-12 float-left"
                                   id="exampleInputCard" placeholder="Enter Deposit...">
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-4" for="exampleInputSalary">Total money:</label>
                            <input type="text" name="contract_total_money" class="form-control col-12 float-left"
                                   id="exampleInputSalary" readonly>
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-4" for="exampleInputPosition">Employee:</label>
                            <select name="employee_id" id="exampleInputPosition" class="form-control col-12 float-left">
                                <option>Chose option ...</option>
                                <c:forEach var="employee" items="${requestScope['employees']}">
                                    <option value="${employee.getId()}">${employee.getName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-4" for="exampleInputEducation">Customer:</label>
                            <select name="customer_id" id="exampleInputEducation" class="form-control col-12 float-left">
                                <option>Chose option ...</option>
                                <c:forEach var="customer" items="${requestScope['customers']}">
                                    <option value="${customer.getId()}">${customer.getName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-4" for="exampleInputDivision">Service:</label>
                            <select name="service_id" onchange="
                                    document.getElementById('exampleInputSalary').value = parseInt(options[selectedIndex].text);
                                " id="exampleInputDivision" class="form-control col-12 float-left">
                                <option value="">Chose option ...</option>
                                <c:forEach var="service" items="${requestScope['services']}">
                                    <option value="${service.getId()}">
                                            ${service.getCost() * service.getRentType().getCost()}đ - ${service.getName()} - ${service.getCost()}đ - ${service.getRentType().getCost()}/${service.getRentType().getName()}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                        <button type="submit" class="btn btn-primary float-right">Create</button>
                        <a href="/admin/contracts"><button type="button" class="btn btn-info float-right">Back</button></a>
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
