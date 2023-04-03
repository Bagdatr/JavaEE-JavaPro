<%@ page import="kz.bitlab.javaEE.Item" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <%
        Item item = (Item) request.getAttribute("item"); //получаем атрибут из бэка (servlet). Обязательно прописываем request полностью, чтобы получить объект
        if(item != null){
    %>
    <div class="row">
        <form action="/update" method="post">
            <div class="form-group">
                <input type="hidden" class="form-control" name="item-id" value="<%=item.getId()%>">
            </div>
            <div class="form-group">
                <laber class="form-label">ITEM-NAME:</laber>
                <input type="text" class="form-control" name="item-name" value="<%=item.getName()%>">
            </div>
            <div class="form-group">
                <laber class="form-label">ITEM-PRICE:</laber>
                <input type="number" class="form-control" name="item-price" value="<%=item.getPrice()%>">
            </div>
            <div class="form-group">
                <laber class="form-label">ITEM-AMOUNT:</laber>
                <input type="number" class="form-control" name="item-amount" value="<%=item.getAmount()%>">
            </div>
            <div class="form-group">
                <button class="btn btn-success">UPDATE</button>
            </div>
        </form>
        <form action="/remove" method="post">
            <div class="form-group">
                <input type="hidden" class="form-control" name="item-id" value="<%=item.getId()%>">
            </div>
            <button class="btn btn-danger">REMOVE</button>
        </form>
    </div>
    <%
        }
    %>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</body>
</html>
