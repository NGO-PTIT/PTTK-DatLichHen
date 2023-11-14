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
    </nav>
    </header>
        <br>
    <div class="row" >
        <div class="container">
            <h3 class="text-center">Trang Chủ Khách Hàng</h3>
            <hr>
            <br>
            
        </div>
    </div>
    <div class="text-center">
        <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Đặt Lịch Hẹn</a>
        <a href="<%=request.getContextPath()%>/list" class="btn btn-success">Xem Lịch Hẹn</a>
    </div>
</body>
</html>
