<jsp:useBean id="sua" scope="request" type="QuanLyQuanNet.models.Product"/>
<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 12/4/2023
  Time: 4:52 PM
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
        <label >Giá Tiền</label>
        <input type="number" class="form-control" style="width: 300px" name="name" value="${sua.name}">
    </div>
    <div class="form-group">
        <label >Giá Tiền</label>
        <input type="number" class="form-control" style="width: 300px" name="price" value="${sua.price}">
    </div>
    <div class="form-group">
        <label >Giá Tiền</label>
        <input type="number" class="form-control" style="width: 300px" name="quantity" value="${sua.quantity}">
    </div>
    <button  class="btn btn-primary">Submit</button>
</form>
</body>
</html>
