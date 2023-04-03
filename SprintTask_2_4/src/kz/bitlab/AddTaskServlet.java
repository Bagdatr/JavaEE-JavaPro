package kz.bitlab;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value="/add-task")
public class AddTaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/addtask.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("task-name");
        String description = req.getParameter("task-description");
        String deadlineDate = req.getParameter("task-deadlineDate");
        String taskStatus = "Нет";
        Tasks task = new Tasks(name,description,deadlineDate,taskStatus);
        DBManager.addTask(task);
        resp.sendRedirect("/hom");
    }
}