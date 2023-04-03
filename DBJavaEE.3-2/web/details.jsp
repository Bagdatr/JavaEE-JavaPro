<%@ page import="javaEE.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<%
    Student student = (Student) request.getAttribute("student");
%>
<div class="container">
    <div class="row">
        <label type="hidden" class="form-label" name="student-id" value="<%=student.getId()%>"></label>
    </div>
    <div class="row">
        <h6 class="form-label">NAME:</h6>
        <p name="student-name"><%=student.getName()%></p>
    </div>
    <div class="row">
        <h6 class="form-label">SURNAME:</h6>
        <p name="student-surname"><%=student.getSurname()%></p>
    </div>
    <div class="row">
        <h6 class="form-label">BIRTHDATE:</h6>
        <p name="student-birthdate"><%=student.getBirthdate()%></p>
    </div>
    <div class="row">
        <h6 class="form-label">CITY:</h6>
        <p name="student-city"><%=student.getCity()%></p>
    </div>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>
</html>
