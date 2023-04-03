
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<div class="container">
  <div class="row">
    <div class="col-md-3">
      <a href="/home" class="text-decoration-none" style="color: black"><h3>BITLAB SHOP</h3></a>
    </div>
    <div class="col-md-5">
    </div>
    <div class="col-md-1">
      <a href="#" class="text-decoration-none" style="font-size:12px; color:black">Top Sales</a>
    </div>
    <div class="col-md-1">
      <a href="#" class="text-decoration-none" style="font-size:12px; color:black">New Sales</a>
    </div>
    <div class="col-md-1">
      <a href="#" class="text-decoration-none" style="font-size:12px; color:black">By Category</a>
    </div>
    <div class="col-md-1">
      <a href="/register" class="text-decoration-none" style="font-size:12px; color:black">Register</a>
    </div>
  </div>

  <%--        окно авторизации--%>
  <div class="row">
    <form action="/login" method="post">
      <div class="form-group">
        <label class="form-label">EMAIL:</label>
        <input type="email" class="form-control" name="user-email">
      </div>
      <div class="form-group">
        <label class="form-label">PASSWORD:</label>
        <input type="password" class="form-control" name="user-password">
      </div>
      <br>
      <div class="form-group">
        <button class="btn btn-success">LOGIN</button>
      </div>
    </form>
  </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>
</html>
