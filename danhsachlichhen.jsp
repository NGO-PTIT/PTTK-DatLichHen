<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
        <div>
            <a href="https://www.facebook.com/profile.php?id=100014726106548" class="navbar-brand"> Nguyễn Đức Ngọ - B20DCAT131 </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>" class="nav-link">Trang chủ</a></li>
        </ul>
    </nav>
    </header>
        <br>
    <div class="row" >
        <div class="container">
            <h3 class="text-center">Danh sách lịch hẹn</h3>
            <hr>
            <br>
            <div class="d-flex justify-content-center">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>STT</th>
                            <th>Ngày</th>
                            <th>Giờ</th>
                            <th>TênKH</th>
                            <th>Email</th>
                            <th>SÐT</th>
                            <th>Ghi chú</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>                
                        <c:forEach items="${requestScope.listLH}" var="lh">
                            <tr>
                                <td>${lh.id}</td>
                                <td>${lh.ngay}</td>
                                <td>${lh.gio}</td>
                                <td>${lh.tenKH}</td>
                                <td>${lh.email}</td>
                                <td>${lh.dienthoai}</td>
                                <td>${lh.ghichu}</td>
                                <td>
                                    <a href="edit?id=<c:out value='${lh.id}'/>">Edit</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>