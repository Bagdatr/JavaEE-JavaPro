package kz.bitlab.javaEE;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(value="/update")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String redirect = "/update?error";
        String name = req.getParameter("item-name");
        int price = Integer.parseInt(req.getParameter("item-price"));
        int amount = Integer.parseInt(req.getParameter("item-amount"));
        Long id = Long.valueOf(req.getParameter("item-id"));
        Item item = new Item();
        item.setName(name);
        item.setPrice(price);
        item.setAmount(amount);
        item.setId(id);
        if(DBManager.updateItem(item) == true){
            redirect = "/home";
        }
        resp.sendRedirect(redirect);
    }
}
