<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row" style="background-color: blueviolet">
        <div class="col-md-3">
            <h4 style="color:white">TASK MANAGER</h4>
        </div>
        <div class="col-md-9" style="display: flex">
            <a href="/hom" style="text-decoration: none"><h6 style="color:white">Все задания</h6></a>
        </div>
    </div>
</div>

<p></p>

<div class="container">
    <p><h4>Новое задание</h4></p>
</div>
<p></p>

<div class="container">
    <form action="/add-task" method="post">
        <div class="form-group">
            <label class="form-label">Наименование:</label>
            <input type="text" class="form-control" name="task-name">
        </div>
        <div class="form-group">
            <label class="form-label">Описание:</label>
            <textarea type="text" class="form-control h-25 d-inline-block" name="task-description"></textarea>
        </div>
        <div class="form-group">
            <label class="form-label">Крайний срок:</label>
            <input type="date" class="form-control" name="task-deadlineDate">
        </div>
        <p></p>
        <div class="form-group">
            <button class="btn btn-success">Добавить</button>
        </div>
    </form>
</div>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>
</html>
