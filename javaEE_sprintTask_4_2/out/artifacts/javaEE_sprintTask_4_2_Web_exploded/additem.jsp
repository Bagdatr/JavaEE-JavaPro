<%@ page import="javaEE.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <%
            User currentUser = (User) request.getSession().getAttribute("currentUser");
        %>
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

            <%
                if(currentUser == null){
            %>
            <div class="col-md-1">
                <a href="/login" class="text-decoration-none" style="font-size:12px; color:black">Log in</a>
            </div>

            <%
                }else if(currentUser != null){
            %>
            <div class="col-md-1">
                <form action="/logout" method="post">
                    <button class="btn btn-danger">Log out</button>
                </form>
            </div>
            <%
                }
            %>
        </div>
    </div>
    <%
        if(currentUser != null){
    %>
    <div class="container">
        <div class="row">
            <form action="/add-item" method="post">
                <div class="form-group">
                    <label class="form-group">Наименование товара:</label>
                    <input type="text" class="form-control" name="item-name">
                </div>
                <div class="form-group">
                    <label class="form-group">Описание:</label>
                    <textarea type="text" class="form-control h-50" name="item-description"></textarea>
                </div>
                <div class="form-group">
                    <label class="form-group">Цена:</label>
                    <input type="number" class="form-control" name="item-price">
                </div>
                <br>
                <div class="form-group">
                    <button class="btn btn-success">Сохранить</button>
                </div>
            </form>
        </div>
    </div>
    <%
        } else {
    %>
    <div class="alert alert-danger">
        You are not logged in. Please log in or register
    </div>
    <%
        }
    %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>
</html>
