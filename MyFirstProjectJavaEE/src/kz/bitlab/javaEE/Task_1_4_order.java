//package kz.bitlab.javaEE;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//@WebServlet(value="/order")
//public class Task_1_4_order extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html");
//        PrintWriter out = resp.getWriter();
//
//        out.print("<form action='/order' method='post'>");
//        out.print("<p>NAME:<input type='text' name='item-name'></p>");
//        out.print("<p>SURNAME:<input type='text' name='item-surname'></p>");
//        out.print("<p>FOOD:<select name='item-food'><option>Manty - 900 KZT</option><option>Plov - 800 KZT</option></select>");
//        out.print("<button>ORDER</button>");
//        out.print("</form>");
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getParameter("item-name");
//        String surname = req.getParameter("item-surname");
//        String food = req.getParameter("item-food");
//        Task_1_4_Item item = new Task_1_4_Item();
//        item.setName(name);
//        item.setSurname(surname);
//        item.setFood(food);
//        Taske_1_4_DBManager.addItem(item);
//    }
//}
