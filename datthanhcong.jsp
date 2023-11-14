<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đặt Lịch Hẹn Thành Công</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        .success-container {
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            text-align: center;
            width: 300px;
        }

        .success-icon {
            color: #4CAF50;
            font-size: 48px;
        }

        .success-message {
            font-size: 18px;
            color: #333;
            margin-top: 10px;
        }

        .back-to-home {
            display: inline-block;
            margin-top: 20px;
            text-decoration: none;
            background-color: #4CAF50;
            color: #fff;
            padding: 10px 20px;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }

        .back-to-home:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

    <div class="success-container">
        <div class="success-icon">&#10004;</div>
        <div class="success-message">Đặt lịch hẹn thành công!</div>
        <a href="<%=request.getContextPath()%>" class="back-to-home">Quay lại trang chủ</a>
    </div>

</body>
</html>
