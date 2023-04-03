//package kz.bitlab.javaEE.Task_1_5;
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
//        resp.setContentType("text/html");
//        PrintWriter out = resp.getWriter();
//        ArrayList<User> users = DBManager.getAllUsers();
//        for(int i=0;i<users.size();i++){
//            if(users.get(i).getAge() >= 18){
//                if(users.get(i).getGender().equals("male")){
//                    out.print("<p><h3>");
//                    out.print("Hello Dear Mister ");
//                    out.print(users.get(i).getFullName());
//                    out.print("!</h3></p>");
//                }else{
//                    out.print("<p><h3>");
//                    out.print("Hello Dear Miss ");
//                    out.print(users.get(i).getFullName());
//                    out.print("!</h3></p>");
//                }
//            }else{
//                out.print("<p><h3>");
//                out.print("Hello Dude ");
//                out.print(users.get(i).getFullName());
//                out.print("!</h3></p>");
//            }
//        }
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//    }
//}
