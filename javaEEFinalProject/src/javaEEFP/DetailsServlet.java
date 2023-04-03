package javaEEFP;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

@WebServlet(value="/details")
public class DetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        News news = DBManager.getNews(id);
        req.setAttribute("news",news);

        ArrayList<Comment>comments = DBManager.getAllComments(id);
        req.setAttribute("comments",comments);

        req.getRequestDispatcher("/details.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}
