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
//public class Task_1_4_home extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ArrayList<Task_1_4_Item>items = Taske_1_4_DBManager.getAllItems();
//        resp.setContentType("text/html");
//        PrintWriter out = resp.getWriter();
//
//        for (int i=0;i<items.size();i++){
//            out.print("<h3>");
//            out.print(items.get(i).getName());
//            out.print(" ");
//            out.print(items.get(i).getSurname());
//            out.print(" ");
//            out.print(items.get(i).getFood());
//            out.print(" ");
//            out.print("</h3>");
//        }
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//    }
//}
