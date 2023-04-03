<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.Tasks" %>
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
        <div>
            <a href="/add-task" class="btn btn-warning">+ Добавить задание</a>
        </div>
    </div>
    <p></p>

    <div class="container">
        <div class="row border-bottom border-top">
            <div class="col-md-1">
                <h6>ID</h6>
            </div>
            <div class="col-md-5">
                <h6>Наименование</h6>
            </div>
            <div class="col-md-3">
                <h6>Крайний срок</h6>
            </div>
            <div class="col-md-2">
                <h6>Выполнено</h6>
            </div>
            <div class="col-md-1">
                <h6>Детали</h6>
            </div>
        </div>
    </div>
    <%
        ArrayList<Tasks>list = (ArrayList<Tasks>) request.getAttribute("list");
    %>

    <%
        for(Tasks task:list){
    %>
    <div class="container">
        <div class="row border-bottom">
            <div class="col-md-1">
                <p><%=task.getId()%></p>
            </div>
            <div class="col-md-5">
                <p><%=task.getName()%></p>
            </div>
            <div class="col-md-3">
                <p><%=task.getDeadlineDate()%></p>
            </div>
            <div class="col-md-2">
                <p><%=task.getTaskStatus()%></p>
            </div>
            <div class="col-md-1">
                <a href="/details?id=<%=task.getId()%>" class="btn btn-primary">Детали</a>
            </div>
        </div>
    </div>
    <%
        }
    %>



    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>
</body>
</html>
