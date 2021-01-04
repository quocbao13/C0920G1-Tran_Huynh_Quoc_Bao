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
    <style><jsp:include page="/WEB-INF/lib/bootstrap/css/bootstrap.min.css"/></style>
    <style><jsp:include page="/WEB-INF/lib/bootstrap/datatables/css/dataTables.bootstrap4.min.css"/></style>
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
                        <h1>DANH SACH BENH AN</h1>
                    </div>
                    <div class="col-12">
                        <a class="mb-1" href="/benhans?action=create"><button class="btn btn-primary float-left">
                            Create
                        </button></a>
                    </div>
                    <div class="col-12">
                        <table id="tableList" class="table table-striped table-hover table-bordered">
                            <thead>
                            <tr style="height: 50px" class="text-center">
                                <th>Count</th>
                                <th>Ma Benh An</th>
                                <th>Ma Benh Nhan</th>
                                <th>Ten Benh Nhan</th>
                                <th>Ngay Nhap Vien</th>
                                <th>Ngay Ra Vien</th>
                                <th>Ly Do Nhap Vien</th>
                                <th>Tac Vu</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="benhAn" items="${requestScope['benhAns']}" varStatus="count">
                                <tr>
                                    <td class="text-center">${count.count}</td>
                                    <td>BA-${benhAn.getId()}</td>
                                    <td>BN-${benhAn.getBenhNhan().getId()}</td>
                                    <td>${benhAn.getBenhNhan().getName()}</td>
                                    <td>${benhAn.getNgayVao()}</td>
                                    <td>${benhAn.getNgayRa()}</td>
                                    <td>${benhAn.getLyDoNhapVien()}</td>
                                    <td class="text-center">
                                        <a href="/benhans?action=edit&id=${benhAn.getId()}"
                                           role="button" class="btn btn-large btn-warning">Sua</a>
                                        <!-- Button trigger modal -->
                                        <a href="#myModal_${benhAn.getId()}" role="button" class="btn btn-large btn-danger"
                                           data-toggle="modal">Xoa</a>
                                    </td>
                                </tr>
                                <!-- Modal -->
                                <div id="myModal_${benhAn.getId()}" class="modal fade">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                                    &times;
                                                </button>
                                            </div>

                                            <div class="modal-body">
                                                <p>Ban co mun xoa benh an BA-${benhAn.getId()} nay</p>
                                            </div>
                                            <div class="modal-footer">

                                                <button type="button" class="btn btn-default" data-dismiss="modal">Dong</button>
                                                <a href="/benhans?action=delete&id=${benhAn.getId()}"
                                                   role="button" class="btn btn-danger" title="Xoa">Xoa</a>
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
<script><jsp:include page="/shared/libJs.jsp"/></script>
<script><jsp:include page="/WEB-INF/lib/bootstrap/jquery/jquery-3.5.1.min.js"/></script>
<script><jsp:include page="/WEB-INF/lib/bootstrap/js/popper.min.js"/></script>
<script><jsp:include page="/WEB-INF/lib/bootstrap/datatables/js/jquery.dataTables.min.js"/></script>
<script><jsp:include page="/WEB-INF/lib/bootstrap/datatables/js/dataTables.bootstrap4.min.js"/></script>
<script><jsp:include page="/WEB-INF/lib/bootstrap/js/bootstrap.min.js"/></script>
<script><jsp:include page="/WEB-INF/lib/bootstrap/js/bootstrap.bundle.js"/></script>

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

