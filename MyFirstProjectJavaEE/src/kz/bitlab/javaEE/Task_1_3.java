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
//@WebServlet(value="/add-item")
//public class Task_1_3 extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html");
//        PrintWriter out = resp.getWriter();
//
//        out.print("<form action='/add-item' method='post'>");
//        out.print("<input type='text' name='item-name'>");
//        out.print("<input type='number' name='item-price'>");
//        out.print("<button>SUBMIT</button>");
//        out.print("</form>");
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getParameter("item-name");
//        int price = Integer.parseInt(req.getParameter("item-price"));
//        Item item = new Item();
//        item.setName(name);
//        item.setPrice(price);
//        DBManager.addItem(item);
//    }
//}
