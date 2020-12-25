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
                        <h1>EDIT CUSTOMER</h1>
                    </div>
                    <form class="col-12" method="post">
                        <c:if test="${customer != null}">
                            <input type="hidden" name="id" value="<c:out value="${customer.getId()}"/>">
                        </c:if>
                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-4" for="exampleInputPosition">Customer type:</label>
                            <select name="customer_type_id" id="exampleInputPosition" class="form-control col-12 float-left">
                                <option value="${customer.getCustomerType().getId()}">${customer.getCustomerType().getName()}</option>
                                <c:forEach var="customerType" items="${requestScope['customerTypes']}">
                                    <option value="${customerType.getId()}">${customerType.getName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left" for="exampleInputName">Name:</label>
                            <input type="text" name="customer_name" class="form-control col-12 float-left mt-1"
                                   id="exampleInputName" placeholder="Enter name..." value="<c:out value="${customer.getName()}"/>">
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-4" for="exampleInputBirthday">Birthday:</label>
                            <input type="date" name="customer_birthday" class="form-control col-12 float-left"
                                   id="exampleInputBirthday" placeholder="Enter birthday..." value="<c:out value="${customer.getBirthday()}"/>">
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-4" for="exampleInputGender">Gender:</label>
                            <select name="customer_gender" id="exampleInputGender">
                                <option value="0">Male</option>
                                <option value="1">Female</option>
                            </select>
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-4" for="exampleInputCard">Id card:</label>
                            <input type="text" name="customer_id_card" class="form-control col-12 float-left"
                                   id="exampleInputCard" placeholder="Enter id card..." value="<c:out value="${customer.getIdCard()}"/>">
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-4" for="exampleInputPhone">Phone:</label>
                            <input type="text" name="customer_phone" class="form-control col-12 float-left"
                                   id="exampleInputPhone" placeholder="Enter salary..." value="<c:out value="${customer.getPhone()}"/>">
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-4" for="exampleInputEmail">Email:</label>
                            <input type="text" name="customer_email" class="form-control col-12 float-left"
                                   id="exampleInputEmail" placeholder="Enter email..." value="<c:out value="${customer.getEmail()}"/>">
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-4" for="exampleInputAddress">Address:</label>
                            <input type="text" name="customer_address" class="form-control col-12 float-left"
                                   id="exampleInputAddress" placeholder="Enter address..." value="<c:out value="${customer.getAddress()}"/>">
                        </div>
                        <button type="submit" class="btn btn-primary float-right">Edit</button>
                        <a href="/admin/customers"><button type="button" class="btn btn-info float-right">Back</button></a>
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
