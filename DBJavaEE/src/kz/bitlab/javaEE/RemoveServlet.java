package kz.bitlab.javaEE;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(value="/remove")
public class RemoveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String redirect = "/remove?error";
        Long id = Long.valueOf(req.getParameter("item-id"));
        if(DBManager.removeItem(id) == true){
            redirect = "/home";
        }
        resp.sendRedirect(redirect);
    }
}
