package javaEEFP;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(value="/comment")
public class CommentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String redirect = "/comment?error";
        Long userId = Long.valueOf(req.getParameter("user-id"));
        User user = new User();
        user.setId(userId);
        Long newsId = Long.valueOf(req.getParameter("news-id"));
        News news = new News();
        news.setId(newsId);
        String commentText = req.getParameter("comment-text");
        Comment comment = new Comment();
        comment.setComment(commentText);
        comment.setNewsComment(news);
        comment.setUserComment(user);
        if(DBManager.addComment(comment)==true){
            redirect = "/details?id=" + newsId;
        }
        resp.sendRedirect(redirect);
    }
}
