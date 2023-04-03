package javaEEFP;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value="/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<News>news = DBManager.getAllNews();
        req.setAttribute("news",news);
        ArrayList<News>newsSortedByAZ = DBManager.getAllNewsSortedAZ();
        req.setAttribute("newsSortedByAZ",newsSortedByAZ);
        ArrayList<News>newsSortedByDate = DBManager.getAllNewsSortedDate();
        req.setAttribute("newsSortedByDate",newsSortedByDate);
        req.getRequestDispatcher("/home.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
