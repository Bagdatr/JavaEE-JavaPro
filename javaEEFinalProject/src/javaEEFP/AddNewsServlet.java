package javaEEFP;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;

@WebServlet(value = "/add-news")
public class AddNewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("addnews.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("news-title");
        String content = req.getParameter("news-content");
        News news = new News();
        news.setTitle(title);
        news.setContent(content);
        DBManager.addNews(news);
        resp.sendRedirect("/home");
    }
}
