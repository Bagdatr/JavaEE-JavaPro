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
//@WebServlet(value="/login")
//public class Login extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html");
//        PrintWriter out = resp.getWriter();
//
//        out.print("<form action='/login' method='post'>");
//        out.print("<p>FULL NAME: <input type='text' name='user-fullName'></p>");
//        out.print("<p>AGE: <input type='number' name='user-age'></p>");
//        out.print("<p>GENDER:");
//        out.print("<input type='radio' name='user-gender' value='male'>male");
//        out.print("<input type='radio' name='user-gender' value='female'>female");
//        out.print("</p>");
//        out.print("<button>SEND</button");
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String fullName = req.getParameter("user-fullName");
//        int age = Integer.parseInt(req.getParameter("user-age"));
//        String gender = req.getParameter("user-gender");
//        User user = new User();
//        user.setFullName(fullName);
//        user.setAge(age);
//        user.setGender(gender);
//        DBManager.addUser(user);
//
//    }
//}
