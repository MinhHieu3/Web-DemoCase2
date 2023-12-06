<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 12/4/2023
  Time: 10:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh Sách Máy Tính</h1>
<button type="button" class="btn btn-light"><a href="/abc?action=create">Thêm Mới</a></button>
<table class="table table-striped">
    <thead>
    <tr>

        <th scope="col">ID</th>
        <th scope="col">Giá Tiền</th>
        <th scope="col"></th>
        <th scope="col"></th>
    </tr>
    </thead>
    <c:forEach items='${danhSachComputer}' var="computers">
    <tr>
        <td>${computers.id}</td>
        <td>${computers.price}</td>
        <td><button type="button" class="btn btn-light"><a href="/abc?action=edit&id=${computers.id}">Sửa</a></button></td>
        <td><button type="button" class="btn btn-light"><a href="/abc?action=delete&id=${computers.id}">Xóa</a></button></td>
    </tr>
    </c:forEach>
</table>
<button type="button" class="btn btn-light"><a href="http://localhost:8080">Quay Lại</a></button>

</body>
</html>
