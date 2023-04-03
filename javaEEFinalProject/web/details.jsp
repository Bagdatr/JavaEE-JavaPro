<%@ page import="javaEEFP.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="javaEEFP.News" %>
<%@ page import="javaEEFP.Comment" %>
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
                <form action="/profile" method="get">
                    <button class="btn btn-primary">PROFILE</button>
                </form>
            </div>

        </div>
        <p></p>

        <%
            News news = (News) request.getAttribute("news");
        %>

            <div class="row">
                <form action="/update" method="post">
                    <div>
                        <input type="hidden" value="<%=news.getId()%>" name="news-id">
                    </div>
                    <div class="form-group">
                        <label class="form-label">Post date</label>
                        <input class="form-control" type="text" name="news-post-date" value="<%=news.getPost_date()%>">
                    </div>
                    <div class="form-group">
                        <label class="form-label">Title</label>
                        <input class="form-control" type="text" name="news-title" value="<%=news.getTitle()%>">
                    </div>
                    <div class="form-group">
                        <label class="form-label">Content</label>
                        <textarea class="form-control" type="text" name="news-content"><%=news.getContent()%></textarea>
                    </div>
                    <br>
                    <button class="btn btn-success">SAVE</button>
                </form>
            </div>



            <%
                }
            %>

            <%
                News news = (News) request.getAttribute("news");
                if(currentUser != null){
            %>

            <div class="row">
                <form action="/comment" method="post">
                    <input class="form-control" type="hidden" value="<%=currentUser.getId()%>" name="user-id">
                    <input class="form-control" type="hidden" value="<%=news.getId()%>" name="news-id">
                    <textarea class="form-control" name="comment-text"></textarea>
                    <button class="btn btn-success">ADD COMMENT</button>
                </form>
            </div>

                    <%
                        ArrayList<Comment>comments = (ArrayList<Comment>) request.getAttribute("comments");
                        for(Comment comment:comments){
                    %>

                    <div class="row">
                        <div class="card">
                            <h4 class="card-title"><%=comment.getComment()%></h4>
                            <h5 class="card-text"><%=comment.getUserComment().getEmail()%></h5>
                            <h5 class="card-text"><%=comment.getUserComment().getFull_name()%></h5>
                            <h5 class="card-text text-bg-success"><%=comment.getPost_date()%></h5>
                        </div>
                    </div>
                    <p></p>

                    <%
                        }
                    %>

                <%
                    }
                %>

        </div>
    </div>
</div>
<br>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N"
        crossorigin="anonymous"></script>
</body>
</html>
