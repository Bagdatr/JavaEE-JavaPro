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
//@WebServlet(value="/home")
//public class Home extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html");
//        PrintWriter out = resp.getWriter();
//        ArrayList<Student>students = DBManager.getAllStudents();
//        for(int i=0;i<students.size();i++){
//            out.print("<p><h3>");
//            out.print(students.get(i).getFullName());
//            out.print(" got ");
//            if(students.get(i).getExamPoints()>=90){
//                out.print("'A'");
//            }else if(students.get(i).getExamPoints()>=75 && students.get(i).getExamPoints()<=89){
//                out.print("'B'");
//            }else if(students.get(i).getExamPoints()>=60 && students.get(i).getExamPoints()<=74) {
//                out.print("'C'");
//            }else if(students.get(i).getExamPoints()>=50 && students.get(i).getExamPoints()<=59) {
//                out.print("'D'");
//            }else{
//                out.print("'E'");
//            }
//            out.print(" for exam!");
//            out.print("</h3></p>");
//        }
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//    }
//}
