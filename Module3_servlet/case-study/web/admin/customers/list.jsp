<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/18/2020
  Time: 11:14 AM
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
<body onload="myFunction('${message}')">
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
                        <h1>LIST CUSTOMER</h1>
                    </div>
                    <div class="col-12">
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addNew">
                            Create
                        </button>
                    </div>
                    <div class="col-12">
                        <table id="tableList" class="table table-striped table-hover table-bordered">
                            <thead>
                            <tr style="height: 50px" class="text-center">
                                <th>Count</th>
                                <th>Name</th>
                                <th>Customer Type</th>
                                <th>Action</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="customer" items="${requestScope['customers']}" varStatus="count">
                                <tr>
                                    <td class="text-center">${count.count}</td>
                                    <td>${customer.getName()}</td>
                                    <td>${customer.getCustomerType().getName()}</td>
                                    <td class="text-center">
                                        <a href="/admin/customers?action=edit&id=${customer.getId()}"
                                           role="button" class="btn btn-large btn-warning">Edit</a>
                                        <!-- Button trigger modal -->
                                        <a href="#myModal_${customer.getId()}" role="button" class="btn btn-large btn-danger"
                                           data-toggle="modal">Delete</a>
                                    </td>
                                </tr>
                                <!-- Modal -->
                                <div id="myModal_${customer.getId()}" class="modal fade">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                                    &times;
                                                </button>
                                            </div>

                                            <div class="modal-body">
                                                <p>Are you sure you want to delete this customer? </p>
                                            </div>
                                            <div class="modal-footer">

                                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                <a href="/admin/customers?action=delete&id=${customer.getId()}"
                                                   role="button" class="btn btn-danger" title="Delete">Delete</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <%-- Footer --%>
    </div>
</div>
<div class="modal fade" id="addNew" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">CREATE CUSTOMER</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form class="col-12" method="post" action="/admin/customers?action=create" id="fomrAdd">
                <div class="form-group col-12">
                    <label class="col-12 float-left mt-1" for="exampleInputPosition">Customer type:</label>
                    <select name="customer_type_id" id="exampleInputPosition" class="form-control col-12 float-left">
                        <option>Chose option</option>
                        <c:forEach var="customerType" items="${customerTypes}">
                            <c:choose>
                                <c:when test="${customerType.getId().equals(customer.customerType.getId())}">
                                    <option value="<c:out value='${customerType.getId()}'/>" selected>
                                        <c:out value="${customerType.getName()}"/>
                                    </option>
                                </c:when>
                                <c:otherwise>
                                    <option value="<c:out value='${customerType.getId()}'/>">
                                        <c:out value="${customerType.getName()}"/>
                                    </option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group col-12">
                    <label class="col-12 float-left mt-4" for="exampleInputName">Name:</label>
                    <input type="text" name="customer_name" class="form-control col-12 float-left mt-1"
                           id="exampleInputName" placeholder="Enter name..."  value="<c:out value="${customer.getName()}"/>">
                </div>
                <p>
                    <c:if test='${message!= null}'>
                        <span style="color: red" class="message">${message}</span>
                    </c:if>
                </p>
                <div class="form-group col-12">
                    <label class="col-12 float-left mt-4" for="exampleInputBirthday">Birthday:</label>
                    <input type="date" name="customer_birthday" class="form-control col-12 float-left"
                           id="exampleInputBirthday" placeholder="Enter birthday..." value="<c:out value="${customer.getBirthday()}"/>">
                </div>
                <div class="form-group col-12">
                    <label class="col-12 float-left mt-4" for="exampleInputGender">Gender:</label>
                    <select name="customer_gender" id="exampleInputGender" class="form-control col-12 float-left">
                        <option value="0">Male</option>
                        <option value="1">Female</option>
                    </select>
                </div>
                <div class="form-group col-12">
                    <label class="col-12 float-left mt-4" for="exampleInputCard">Id card:</label>
                    <input type="text" name="customer_id_card" class="form-control col-12 float-left"
                           id="exampleInputCard" placeholder="Enter id card..."  value="<c:out value="${customer.getIdCard()}"/>">
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
                <button type="submit" class="btn btn-primary float-right">Create</button>
            </form>
        </div>
    </div>
</div>
<script src="../../assets/bootstrap/jquery/jquery-3.5.1.min.js"></script>
<script src="../../assets/bootstrap/js/popper.min.js"></script>
<script src="../../assets/bootstrap/datatables/js/jquery.dataTables.min.js"></script>
<script src="../../assets/bootstrap/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="../../assets/bootstrap/js/bootstrap.min.js"></script>
<script src="../../assets/bootstrap/js/bootstrap.bundle.js"></script>
<script>
    $(document).ready(function () {
        $('#tableList').dataTable({
            "lengthChange" : 'false',
            "pageLength" : 5
        });
    });
</script>
<script type="text/javascript">
    function myFunction(message) {
        if (message) {
            $('#addNew').modal('show');
        }
    }
</script>
</body>
</html>
