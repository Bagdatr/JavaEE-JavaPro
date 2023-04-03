
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
            <form action="" method="post">
                <div class="form-group">
                    <label class="form-label">STUDENT NAME:</label>
                    <input type="text" class="form-control" name="student-name">
                </div>
                <div class="form-group">
                    <label class="form-label">STUDENT SURNAME:</label>
                    <input type="text" class="form-control" name="student-surname">
                </div>
                <div class="form-group">
                    <label class="form-label">BIRTHDATE:</label>
                    <input type="date" class="form-control" name="student-birthdate">
                </div>
                <div class="form-group">
                    <label class="form-label">CITY:</label>
                    <input type="text" class="form-control" name="student-city">
                </div>
                <div class="form-group">
                    <button class="btn btn-success">ADD STUDENT</button>
                </div>
            </form>
        </div>
    </div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>
</html>
