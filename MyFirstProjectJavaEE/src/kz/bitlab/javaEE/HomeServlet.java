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
//public class HomeServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html");
//        PrintWriter out = resp.getWriter();
//        out.print("<h1>Hello Bitlab</h1>");
//        out.print("<h1>This is my first servlet response</h1>");
//        out.print("<table>" +
//                    "<tr>" +
//                        "<td>Day</td>" +
//                        "<td>Month</td>" +
//                        "<td>Year</td>" +
//                    "</tr>" +
//                    "<tr>" +
//                        "<td>09</td)" +
//                        "<td>January</td>" +
//                        "<td>1987</td>" +
//                    "</tr>" +
//                "</table>");
//        out.print("");
//
//        ArrayList<String>items = new ArrayList<>();
//        items.add("IPhone14");
//        items.add("IPhone13");
//        items.add("IPhone12");
//        items.add("IPhone11");
//        items.add("IPhone10");
//        out.print("<table>");
//        for(int i = 0; i < items.size(); i++){
//            out.print("<tr>");
//            out.print("<td>");
//            out.print("<h1>");
//            out.print(i + 1 + ". ");
//            out.print("</h1>");
//            out.print("</td>");
//            out.print("<td>");
//            out.print(items.get(i));
//            out.print("</td>");
//            out.print("</tr>");
//        }
//        out.print("</table>");
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//    }
//}