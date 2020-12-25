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
                        <h1>EDIT SERVICE</h1>
                    </div>
                    <form class="col-12" method="post">
                        <c:if test="${service != null}">
                            <input type="hidden" name="id" value="<c:out value="${service.getId()}"/>">
                        </c:if>
                        <div class="form-group col-12">
                            <label class="col-12 float-left" for="exampleInputName">Name:</label>
                            <input type="text" name="service_name" class="form-control col-12 float-left mt-1"
                                   id="exampleInputName" placeholder="Enter name..." value="<c:out value="${service.getName()}"/>">
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-4" for="exampleInputArea">Area:</label>
                            <input type="text" name="service_area" class="form-control col-12 float-left"
                                   id="exampleInputArea" placeholder="Enter Area..." value="<c:out value="${service.getArea()}"/>">
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-4" for="exampleInputCost">Cost:</label>
                            <input type="text" name="service_cost" class="form-control col-12 float-left"
                                   id="exampleInputCost" placeholder="Enter Cost..." value="<c:out value="${service.getCost()}"/>">
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-4" for="exampleInputMaxPeople">Max people:</label>
                            <input type="text" name="service_max_people" class="form-control col-12 float-left"
                                   id="exampleInputMaxPeople" placeholder="Enter Max people..." value="<c:out value="${service.getMaxPeople()}"/>">
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-4" for="exampleInputRentType">Rent type:</label>
                            <select name="rent_type_id" id="exampleInputRentType" class="form-control col-12 float-left">
                                <option value="${service.getRentType().getId()}">
                                    ${service.getRentType().getName()} - ${service.getRentType().getCost()}$
                                </option>
                                <c:forEach var="rentType" items="${requestScope['rentTypes']}">
                                    <option value="${rentType.getId()}">${rentType.getName()} - ${rentType.getCost()}$</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-4" for="exampleInputServiceType">Service type:</label>
                            <select name="service_type_id" id="exampleInputServiceType" class="form-control col-12 float-left">
                                <option value="${service.getServiceType().getId()}">${service.getServiceType().getName()}</option>
                                <c:forEach var="serviceType" items="${requestScope['serviceTypes']}">
                                    <option value="${serviceType.getId()}">${serviceType.getName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-4" for="exampleInputStandard">Standard room:</label>
                            <input type="text" name="standard_room" class="form-control col-12 float-left"
                                   id="exampleInputStandard" placeholder="Enter Standard room..." value="<c:out value="${service.getStandardRoom()}"/>">
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-4" for="exampleInputD">Description other convenience:</label>
                            <input type="text" name="description_other_convenience" class="form-control col-12 float-left"
                                   id="exampleInputD" placeholder="Enter Description other convenience..." value="<c:out value="${service.getDescriptionOtherConvenience()}"/>">
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-4" for="exampleInputPool">Pool area:</label>
                            <input type="text" name="pool_area" class="form-control col-12 float-left"
                                   id="exampleInputPool" placeholder="Enter Pool area..." value="<c:out value="${service.getPoolArea()}"/>">
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-4" for="exampleInputFloor">Number of floors:</label>
                            <input type="text" name="number_of_floors" class="form-control col-12 float-left"
                                   id="exampleInputFloor" placeholder="Enter address..." value="<c:out value="${service.getNumberOfFloor()}"/>">
                        </div>
                        <button type="submit" class="btn btn-primary float-right">Edit</button>
                        <a href="/admin/services"><button type="button" class="btn btn-info float-right">Back</button></a>
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
