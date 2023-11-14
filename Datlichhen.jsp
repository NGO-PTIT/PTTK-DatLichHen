<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Student</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <style> input{width: 100%;}</style>
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
    <div class="container col-md-5">
        <div class="card">
            <div class="card-body">
                <c:if test="${lh != null}"><form action="update" method="post"></c:if>
                <c:if test="${lh == null}"><form action="insert" method="post"></c:if>

                <caption>
                    <h2>
                        <c:if test="${lh != null}">Sửa lịch hẹn</c:if>
                        <c:if test="${lh == null}">Đặt lịch hẹn</c:if>
                    </h2>
                </caption>
                <fieldset class="form-group">
                    <label for="date">Chọn Ngày:</label> 
                    <input style = "width: 100%" type="date" value="<c:out value='${lh.ngay}' />" name="ngay" required="required">
                </fieldset>
      
                <fieldset class="form-group">
                    <label for="time">Chọn Giờ:</label> 
                    <input type="time" value="<c:out value='${lh.gio}' />" name="gio" required="required">
                </fieldset>

                <fieldset class="form-group">
                    <label>Tên Khách Hàng</label> 
                    <input type="text" value="<c:out value='${lh.tenKH}' />" name="tenKH" required="required">
                </fieldset>

                <fieldset class="form-group">
                    <label>Email:</label> 
                    <input type="text" value="<c:out value='${lh.email}' />" name="email" required="required">
                </fieldset>
                
                <fieldset class="form-group">
                    <label>SÐT:</label> 
                    <input type="text" value="<c:out value='${lh.dienthoai}' />" name="dienthoai" required="required">
                </fieldset>
                
                <fieldset class="form-group">
                    <label>Ghi chú:</label> 
                    <input type="text" value="<c:out value='${lh.ghichu}' />" name="ghichu" required="required">
                </fieldset>
                
                <button type="submit" class="btn btn-success">Save</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
