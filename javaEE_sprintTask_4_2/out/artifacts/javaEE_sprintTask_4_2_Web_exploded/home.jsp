<%@ page import="java.util.ArrayList" %>
<%@ page import="javaEE.Item" %>
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
    %>b
    <%--navbar--%>
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

        <div class="container">
           <a href="/add-item" class="btn btn-success">Add item</a>
        </div>

        <%
            }
        %>
    </div>


    <%--шапка--%>
    <div class="row text-center">
        <h1>Welcome to BITLAB SHOP</h1>
    </div>
    <div class="row text-center">
        <h6>Electronic devices with high quality and service</h6>
    </div>
    <br>

    <div class="row justify-content-center">
        <%
            ArrayList<Item> items = (ArrayList<Item>) request.getAttribute("items");
            for (Item item : items) {
        %>

        <%--  карточки товаров--%>

        <div class="card text-center col-sm-4 m-1" style="width: 18rem;">
            <div class="card-header">
                <%=item.getName()%>
            </div>
            <div class="card-body d-flex flex-column">
                <h5 class="card-title">$<%=item.getPrice()%>
                </h5>
                <p class="card-text"><%=item.getDescription()%>
                </p>
                <a href="#" class="btn btn-success" style="width: 14rem;">Buy Now</a>
            </div>
        </div>
        <%
            }
        %>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>
</html>
