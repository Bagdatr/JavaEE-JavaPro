package javaEEFP;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Timestamp;

@WebServlet(value="/update")
public class UpdateNewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String redirect = "/update?error";
        String id = req.getParameter("news-id");
        String post_date = req.getParameter("news-post-date");
        String title = req.getParameter("news-title");
        String content = req.getParameter("news-content");
        News news = new News();
        news.setId(Long.valueOf(id));
        news.setPost_date(Timestamp.valueOf(post_date));
        news.setTitle(title);
        news.setContent(content);
        if(DBManager.updateNews(news) == true){
            redirect = "/home";
        }
        resp.sendRedirect(redirect);
    }
}
