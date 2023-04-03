package kz.bitlab;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(value="/details")
public class DetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));//ловим айдишник
        Tasks task = DBManager.getTask(id);//вытаскиваем тот Таск, Айди которого мы словили с URL
        req.setAttribute("task",task);//тут мы сэтим в атрибут, чтобы перетащить из бэка во фронт
        req.getRequestDispatcher("/details.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
