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
                        <h1>LIST CUSTOMER</h1>
                    </div>
                    <div class="col-12">
                        <a class="mb-1" href="/admin/customers?action=create"><button class="btn btn-primary float-left">
                            Create
                        </button></a>
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
</body>
</html>
