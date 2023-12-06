<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 12/4/2023
  Time: 2:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</head>
<body>
<form method="post">
    <div class="form-group">
        <label>ID</label>
        <input type="number" class="form-control" style="width: 300px" name="id" >
    </div>
    <div class="form-group">
        <label >Tên Khách Hàng</label>
        <input type="number" class="form-control" style="width: 300px" name="name" >
    </div>
    <div class="form-group">
        <label >Tên Đăng Nhập </label>
        <input type="number" class="form-control" style="width: 300px" name="user">
    </div>
    <div class="form-group">
        <label >Mật Khẩu</label>
        <input type="number" class="form-control" style="width: 300px" name="pass" >
    </div>
    <div class="form-group">
        <label >Số Tiền Nạp</label>
        <input type="number" class="form-control" style="width: 300px" name="money" >
    </div>
    <button  class="btn btn-primary">Submit</button>
</form>
</body>
</html>
