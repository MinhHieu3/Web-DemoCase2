<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 12/4/2023
  Time: 3:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <div class="form-group">
        <label>ID</label>
        <input type="number" class="form-control" style="width: 300px" name="id" value="${sua.id}">
    </div>
    <div class="form-group">
        <label >Tên Khách Hàng</label>
        <input type="number" class="form-control" style="width: 300px" name="name" value="${sua.name}">
    </div>
    <div class="form-group">
        <label >Tên Đăng Nhập</label>
        <input type="number" class="form-control" style="width: 300px" name="user" value="${sua.user}">
    </div>
    <div class="form-group">
        <label >Mật Khẩu</label>
        <input type="number" class="form-control" style="width: 300px" name="pass" value="${sua.pass}">
    </div>
    <div class="form-group">
        <label >Số Tiền Nạp</label>
        <input type="number" class="form-control" style="width: 300px" name="money" value="${sua.money}">
    </div>
    <button  class="btn btn-primary">Submit</button>
</form>
</body>
</html>
