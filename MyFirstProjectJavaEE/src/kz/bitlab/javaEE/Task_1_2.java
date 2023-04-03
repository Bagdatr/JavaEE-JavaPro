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
//@WebServlet (value="/home")
//public class Task_1_2 extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html");
//        PrintWriter out = resp.getWriter();
//
//        ArrayList<Employee>employees = new ArrayList<>();
//
//        Employee employee_1 = new Employee("Ilyas","Zhuanyshev","IT",550000);
//        Employee employee_2 = new Employee("Aybek","Bagit","Management",650000);
//        Employee employee_3 = new Employee("Alibek","Serikov","HR",350000);
//        Employee employee_4 = new Employee("Serzhan","Berikov","IT",450000);
//        Employee employee_5 = new Employee("Madina","Assetova","PR",350000);
//        Employee employee_6 = new Employee("Anel","Mukhamejanova","Management",400000);
//
//        employees.add(employee_1);
//        employees.add(employee_2);
//        employees.add(employee_3);
//        employees.add(employee_4);
//        employees.add(employee_5);
//        employees.add(employee_6);
//
//        out.print("<table>");
//        out.print("<tr>");
//        out.print("<td>");
//        out.print("<h4>NAME</h4>");
//        out.print("</td>");
//        out.print("<td>");
//        out.print("<h4>SURNAME</h4>");
//        out.print("</td>");
//        out.print("<td>");
//        out.print("<h4>DEPARTMENT</h4>");
//        out.print("</td>");
//        out.print("<td>");
//        out.print("<h4>SALARY</h4>");
//        out.print("</td>");
//        out.print("</tr>");
//
//        for(int i = 0; i < employees.size(); i++){
//            out.print("<tr>");
//            out.print("<td>");
//            out.print(employees.get(i).getName());
//            out.print("</td>");
//
//            out.print("<td>");
//            out.print(employees.get(i).getSurname());
//            out.print("</td>");
//
//            out.print("<td>");
//            out.print(employees.get(i).getDepartment());
//            out.print("</td>");
//
//            out.print("<td>");
//            out.print(employees.get(i).getSalary());
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
