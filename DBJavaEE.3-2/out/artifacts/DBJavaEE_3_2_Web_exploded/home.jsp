<%@ page import="java.util.ArrayList" %>
<%@ page import="javaEE.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div>
        <a href="/add-student" class="btn btn-warning">+ Add student</a>
    </div>
    <p></p>

    <div class="container">
        <div class="row border border-top border-bottom">
            <div class="col-md-1">
                <h6>ID</h6>
            </div>
            <div class="col-md-3">
                <h6>NAME</h6>
            </div>
            <div class="col-md-3">
                <h6>SURNAME</h6>
            </div>
            <div class="col-md-2">
                <h6>BIRTHDATE</h6>
            </div>
            <div class="col-md-2">
                <h6>CITY</h6>
            </div>
            <div class="col-md-1">
                <h6>DETAILS</h6>
            </div>
        </div>
    </div>

    <%
        ArrayList<Student>students = (ArrayList<Student>) request.getAttribute("students");
        for(Student student:students){
    %>
    <div class="container">
        <div class="row border-bottom">
            <div class="col-md-1">
                <p><%=student.getId()%></p>
            </div>
            <div class="col-md-3">
                <p><%=student.getName()%></p>
            </div>
            <div class="col-md-3">
                <p><%=student.getSurname()%></p>
            </div>
            <div class="col-md-2">
                <p><%=student.getBirthdate()%></p>
            </div>
            <div class="col-md-2">
                <p><%=student.getCity()%></p>
            </div>
            <div class="col-md-1">
                <a href="/details?id=<%=student.getId()%>" class="btn btn-primary">DETAILS</a>
            </div>
        </div>
    </div>
    <%
        }
    %>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>
</html>