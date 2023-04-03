package javaEE;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(value="/add-student")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/addstudent.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String redirect = "/add-student?error";
        String name = req.getParameter("student-name");
        String surname = req.getParameter("student-surname");
        String birthdate = req.getParameter("student-birthdate");
        String city = req.getParameter("student-city");
        Student student = new Student();
        student.setName(name);
        student.setSurname(surname);
        student.setBirthdate(birthdate);
        student.setCity(city);
        if(DBManager.addStudent(student) == true){
            redirect = "/home";
        }
        resp.sendRedirect(redirect);
    }
}
