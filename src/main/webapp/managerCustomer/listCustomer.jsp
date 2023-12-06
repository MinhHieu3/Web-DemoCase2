<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 12/4/2023
  Time: 2:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</head>
<body>
<h1>Danh Sách Khách Hàng</h1>
<button type="button" class="btn btn-light"><a href="/customers?action=create">Thêm Mới</a></button>
<table class="table table-striped">
    <thead>
    <tr>

        <th scope="col">ID</th>
        <th scope="col">Họ Và Tên</th>
        <th scope="col">Tên Đăng Nhập</th>
        <th scope="col">Mật Khẩu</th>
        <th scope="col">Số Tiền Nạp</th>
    </tr>
    </thead>
    <c:forEach items='${danhSachCustomer}' var="customers">
        <tr>
            <td>${customers.id}</td>
            <td>${customers.name}</td>
            <td>${customers.userName}</td>
            <td>${customers.passWorld}</td>
            <td>${customers.money}</td>
            <td><button type="button" class="btn btn-light"><a href="/customers?action=edit&id=${customers.id}">Sửa</a></button></td>
            <td><button type="button" class="btn btn-light"><a href="/customers?action=delete&id=${customers.id}">Xóa</a></button></td>
        </tr>
    </c:forEach>
</table>
<button type="button" class="btn btn-light"><a href="http://localhost:8080">Quay Lại</a></button>
</body>
</html>
