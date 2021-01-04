<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/29/2020
  Time: 8:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style><jsp:include page="/shared/libCss.jsp"/></style>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
          integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA=="
          crossorigin="anonymous" />
</head>
<body>
<div class="wrapper ">
    <div class="main-panel">
        <!-- Navbar -->
        <!-- End Navbar -->
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-12 text-center">
                        <h1>THEM BENH AN</h1>
                    </div>
                    <c:if test='${requestScope["message"] != null}'>
                        <span class="col-12 border bg-light">${requestScope["message"]}</span>
                    </c:if>
                    <form class="col-12" method="post">
                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-1" for="exampleInputPosition">Customer type:</label>
                            <select name="benhnhan_id" id="exampleInputPosition" class="form-control col-12 float-left">
                                <option>Chose option ...</option>
                                <c:forEach var="benhNhan" items="${requestScope['benhNhans']}">
                                    <option value="${benhNhan.getId()}">${benhNhan.getId()} - ${benhNhan.getName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left" for="exampleInputVao">Ngay vao:</label>
                            <input type="date" name="ngaynhapvien" class="form-control col-12 float-left mt-2"
                                   id="exampleInputVao" placeholder="Enter Name">
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left" for="exampleInputRa">Ngay ra:</label>
                            <input type="date" name="ngayravien" class="form-control col-12 float-left mt-2"
                                   id="exampleInputRa" placeholder="Enter Name">
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left" for="exampleInputLyDo">Ly do nhap vien:</label>
                            <input type="text" name="lydonhapvien" class="form-control col-12 float-left mt-2"
                                   id="exampleInputLyDo" placeholder="Enter Name">
                        </div>
                        <button type="submit" class="btn btn-primary float-right">Create</button>
                        <a href="/benhans"><button type="button" class="btn btn-info float-right">Back</button></a>
                    </form>
                </div>
            </div>
        </div>
        <%-- Footer --%>
    </div>
</div>
<script><jsp:include page="/shared/libJs.jsp"/></script>
</body>
</html>
