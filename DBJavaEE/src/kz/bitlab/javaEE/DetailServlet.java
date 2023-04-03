package kz.bitlab.javaEE;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(value="/details")
public class DetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));//вначале мы вытаскиваем id из details.jsp по тегу id
        Item item = DBManager.getItem(id);// затем мы втыкае найденный id в параметр getItem
        req.setAttribute("item",item);//создаем атрибут и готовим его к отправке во фронт
        req.getRequestDispatcher("/details.jsp").forward(req,resp);//это обязательно для открытия соответствующего jsp файла в браузере
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
