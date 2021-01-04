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
    <script><%@include file="/assets/datepicker/js/jquery.min.js"%></script>
    <script><%@include file="/assets/datepicker/js/bootstrap-datepicker.js"%></script>
    <script>
        $(function () {
            'use strict';
            var nowTemp = new Date();
            var now = new Date(nowTemp.getFullYear(), nowTemp.getMonth(), nowTemp.getDate(), 0, 0, 0, 0);

            var checkin = $('#timeCheckIn').datepicker({
                onRender: function (date) {
                    return date.valueOf() < now.valueOf() ? 'disabled' : '';
                }
            }).on('changeDate', function (ev) {
                if (ev.date.valueOf() > checkout.date.valueOf()) {
                    var newDate = new Date(ev.date);
                    newDate.setDate(newDate.getDate() + 1);
                    checkout.setValue(newDate);
                }
                checkin.hide();
                $('#timeCheckOut')[0].focus();
            }).data('datepicker');
            var checkout = $('#timeCheckOut').datepicker({
                onRender: function (date) {
                    return date.valueOf() <= checkin.date.valueOf() ? 'disabled' : '';
                }
            }).on('changeDate', function (ev) {
                checkout.hide();
            }).data('datepicker');
        });
    </script>
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
                        <c:if test="${contract != null}">
                            <input type="hidden" name="id" value="<c:out value="${contract.getId()}"/>">
                        </c:if>
                        <div class="form-group col-12">
                            <label class="col-12 float-left" for="exampleInputName">Start date:</label>
                            <input type="text" name="contract_start_date" class="form-control col-12 float-left mt-1"
                                   id="exampleInputName" id="timeCheckIn" placeholder="Enter Start date..." value="<c:out value="${contract.getStartDate()}"/>">
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-4" for="exampleInputBirthday">End date:</label>
                            <input type="text" name="contract_end_date" class="form-control col-12 float-left"
                                   id="exampleInputBirthday" id="timeCheckOut" placeholder="Enter End date..." value="<c:out value="${contract.getEndDate()}"/>">
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-4" for="exampleInputCard">Deposit:</label>
                            <input type="text" name="contract_deposit" class="form-control col-12 float-left"
                                   id="exampleInputCard" placeholder="Enter id card..." value="<c:out value="${contract.getDeposit()}"/>">
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-4" for="exampleInputSalary">Total money:</label>
                            <input type="text" name="contract_total_money" class="form-control col-12 float-left"
                                   id="exampleInputSalary" placeholder="Enter salary..." value="<c:out value="${contract.getTotalMoney()}"/>">
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-4" for="exampleInputPosition">Employee:</label>
                            <select name="employee_id" id="exampleInputPosition" class="form-control col-12 float-left">
                                <option value="${contract.getEmployee().getId()}">${contract.getEmployee().getName()}</option>
                                <c:forEach var="employee" items="${requestScope['employees']}">
                                    <option value="${employee.getId()}">${employee.getName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-4" for="exampleInputEducation">Customer:</label>
                            <select name="customer_id" id="exampleInputEducation" class="form-control col-12 float-left">
                                <option value="${contract.getCustomer().getId()}">${contract.getCustomer().getName()}</option>
                                <c:forEach var="customer" items="${requestScope['customers']}">
                                    <option value="${customer.getId()}">${customer.getName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-4" for="exampleInputDivision">Service:</label>
                            <select name="service_id" id="exampleInputDivision" class="form-control col-12 float-left">
                                <option value="${contract.getService().getId()}">${contract.getService().getName()}</option>
                                <c:forEach var="service" items="${requestScope['services']}">
                                    <option value="${service.getId()}">${service.getName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <button type="submit" class="btn btn-primary float-right">Edit</button>
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
