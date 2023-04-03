<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row" style="background-color: grey">
        <div class="col-md-3">
            <label><a href="/home" class="text-decoration-none" style="color:white"><h3>Almaty Smog</h3></a></label>
        </div>
        <div class="col-md-5"></div>
        <div class="col-md-2">
            <a href="/add-user" class="text-decoration-none" style="font-size:12px; color:white; ">Sign up</a>
        </div>
    </div>
    <br>

    <div class="row">
        <form action="/login" method="post">
            <div class="form-group">
                <label class="form-label">Please enter your email</label>
                <input class="form-control" type="email" name="user-email">
            </div>
            <div class="form-group">
                <label class="form-label">Please input your password</label>
                <input class="form-control" type="password" name="user-password">
            </div>
            <br>
            <button class="btn btn-success">LOGIN</button>
        </form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N"
        crossorigin="anonymous"></script>
</body>
</html>
