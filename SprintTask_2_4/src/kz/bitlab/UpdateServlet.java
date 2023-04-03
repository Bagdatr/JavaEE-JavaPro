package kz.bitlab;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value="/update")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("task-id"));
        String name = req.getParameter("task-name");
        String description = req.getParameter("task-description");
        String deadlineDate = req.getParameter("task-deadlineDate");
        String taskStatus = req.getParameter("task-taskStatus");
        Tasks task = new Tasks();
        task.setId(id);
        task.setName(name);
        task.setDescription(description);
        task.setDeadlineDate(deadlineDate);
        task.setTaskStatus(taskStatus);
        DBManager.updateTask(task);
        resp.sendRedirect("/hom");
    }
}
