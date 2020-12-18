<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/18/2020
  Time: 11:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../assets/bootstrap/datatables/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
          integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA=="
          crossorigin="anonymous" />
    <link rel="stylesheet" type="text/css" href="../assets/css/main.css">
</head>
<body>
<div class="wrapper ">
    <%@ include file="../shared/menuLeft.jsp"%>
    <div class="main-panel">
        <!-- Navbar -->
        <%@ include file="../shared/header.jsp"%>
        <!-- End Navbar -->
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div>
                        <h1>LIST </h1>
                    </div>
                    <table class="table table-striped table-hover table-bordered">
                        <thead>
                            <tr class="bg-info">
                                <th>Count</th>
                                <th>Name</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <%-- Footer --%>
        <%@ include file="../shared/footer.jsp"%>
    </div>
</div>
<script src="../assets/bootstrap/jquery/jquery-3.5.1.min.js"></script>
<script src="../assets/bootstrap/js/popper.min.js"></script>
<script src="../assets/bootstrap/datatables/js/jquery.dataTables.min.js"></script>
<script src="../assets/bootstrap/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="../assets/bootstrap/js/bootstrap.min.js"></script>
<script src="../assets/bootstrap/js/bootstrap.bundle.js"></script>
</body>
</html>
