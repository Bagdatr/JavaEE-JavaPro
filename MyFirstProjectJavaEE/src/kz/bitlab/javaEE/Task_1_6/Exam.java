//package kz.bitlab.javaEE.Task_1_6;
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
//@WebServlet(value="/exam")
//public class Exam extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html");
//        PrintWriter out = resp.getWriter();
//        out.print("<form action='/exam' method='post'");
//        out.print("<p>FULL NAME: <input type='text' name='full-name'</p>");
//        out.print("<p>EXAM POINTS: <input type='number' name='exam-points'</p>");
//        out.print("<p><button>SUBMIT EXAM</button></p>");
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String fullName = req.getParameter("full-name");
//        int examPoints = Integer.parseInt(req.getParameter("exam-points"));
//        Student student = new Student();
//        student.fullName = fullName;
//        student.examPoints = examPoints;
//        DBManager.addStudent(student);
//    }
//}
