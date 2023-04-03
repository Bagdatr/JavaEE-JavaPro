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
//import java.util.ArrayList;
//
//@WebServlet(value="/home")
//public class Home extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ArrayList<Item> items = DBManager.getAllItems();
//        resp.setContentType("text/html");
//        PrintWriter out = resp.getWriter();
//        for(int i=0;i<items.size();i++){
//            out.print("<h1>");
//            out.print(items.get(i).getName());
//            out.print("</h1>");
//            out.print("<h1>");
//            out.print(items.get(i).getPrice());
//            out.print("</h1>");
//        }
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//    }
//}
