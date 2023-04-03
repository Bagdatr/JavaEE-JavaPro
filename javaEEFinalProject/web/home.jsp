<%@ page import="javaEEFP.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="javaEEFP.News" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row">
        <%
            User currentUser = (User) request.getSession().getAttribute("currentUser");
        %>
        <div class="row" style="background-color: grey">
            <div class="col-md-3">
                <label><a href="/home" class="text-decoration-none" style="color:white"><h3>Almaty Smog</h3></a></label>
            </div>
            <div class="col-md-5">

            </div>

            <%
                if (currentUser == null) {
            %>

            <div class="col-md-2">
                <a href="/login" class="text-decoration-none" style="font-size:12px; color:white; ">Sign in</a>
            </div>

            <div class="col-md-2">
                <a href="/add-user" class="text-decoration-none" style="font-size:12px; color:white">Sign up</a>
            </div>

            <%
            } else if (currentUser != null) {
            %>
            <div class="col-md-1">
                <form action="/logout" method="post">
                    <button class="btn btn-danger">LOG OUT</button>
                </form>
            </div>

            <div class="col-md-1">
                <form action="/update-profile" method="post">
                    <button class="btn btn-primary">PROFILE</button>
                </form>
            </div>

        </div>
        <p></p>

        <div class="container">
            <a href="/add-news" class="btn btn-success">Add News</a>
        </div>
        <p></p>

        <div class="container">
            <div class="row">
                <div class="col-md-2">
                    <label><h5>Post date</h5></label>
                </div>
                <div class="col-md-2">
                    <label><h5>Title</h5></label>
                </div>
                <div class="col-md-6">
                    <label><h5>News content</h5></label>
                </div>
                <div class="col-md-2">
                    <label><h5>Details</h5></label>
                </div>
                <div class="col-md-2">
                    <a href="/home?sortedAZ" class="btn btn-primary">sort A-Z</a>
                </div>
                <div class="col-md-2">
                    <a href="/home?sortedDate" class="btn btn-primary">sort by date</a>
                </div>
            </div>
            <%
                String sortedAZ = request.getParameter("sortedAZ");
                String sortedDate = request.getParameter("newsSortedByDate");
            %>
            <%
                ArrayList<News>news = (ArrayList<News>) request.getAttribute("news");
                if(sortedAZ == null){
                    for (News blog:news){
            %>

            <div class="row">
                <div class="col-md-2">
                    <label><%=blog.getPost_date()%></label>
                </div>
                <div class="col-md-2">
                    <label><%=blog.getTitle()%></label>
                </div>
                <div class="col-md-6">
                    <label><%=blog.getContent()%></label>
                </div>
                <div class="col-md-2">
                    <a href="/details?id=<%=blog.getId()%>" class="btn btn-primary">Details</a>
                </div>
            </div>
            <br>

            <%
                    }
                }
            %>
        </div>
        <%
            ArrayList<News>newsSortedByAZ = (ArrayList<News>) request.getAttribute("newsSortedByAZ");
            if(sortedAZ != null){
                for(News oneNews : newsSortedByAZ){
        %>
        <div class="row">
            <div class="col-md-2">
                <label><%=oneNews.getPost_date()%></label>
            </div>
            <div class="col-md-2">
                <label><%=oneNews.getTitle()%></label>
            </div>
            <div class="col-md-6">
                <label><%=oneNews.getContent()%></label>
            </div>
            <div class="col-md-2">
                <a href="/details?id=<%=oneNews.getId()%>" class="btn btn-primary">Details</a>
            </div>
        </div>
        <br>
        <%
                }
            }
        %>


            </div>
            <%
                ArrayList<News>newsSortedByDate = (ArrayList<News>) request.getAttribute("newsSortedByDate");
                if(sortedDate != null){
                    for(News oneNews : newsSortedByDate){
            %>
            <div class="row">
                <div class="col-md-2">
                    <label><%=oneNews.getPost_date()%></label>
                </div>
                <div class="col-md-2">
                    <label><%=oneNews.getTitle()%></label>
                </div>
                <div class="col-md-6">
                    <label><%=oneNews.getContent()%></label>
                </div>
                <div class="col-md-2">
                    <a href="/details?id=<%=oneNews.getId()%>" class="btn btn-primary">Details</a>
                </div>
            </div>
            <%
                    }
                }
            %>

        <%
            }
        %>
    </div>
</div>
<br>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N"
        crossorigin="anonymous"></script>
</body>
</html>
