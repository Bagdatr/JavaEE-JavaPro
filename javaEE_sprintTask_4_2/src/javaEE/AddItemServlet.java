package javaEE;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(value="/add-item")
public class AddItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/additem.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String redirect = "/add-item?error";
        String name = req.getParameter("item-name");
        String description = req.getParameter("item-description");
        Double price = Double.valueOf(req.getParameter("item-price"));
        Item item = new Item();
        item.setName(name);
        item.setDescription(description);
        item.setPrice(price);
        if(DBManager.addItem(item) == true){
            redirect = "/add-item?success";
        }
        resp.sendRedirect(redirect);
    }
}
