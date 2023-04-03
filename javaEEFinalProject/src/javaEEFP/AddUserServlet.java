package javaEEFP;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(value="/add-user")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("adduser.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String redirect ="/add-user&error";
        String name = req.getParameter("user-full_name");
        String email = req.getParameter("user-email");
        String password = req.getParameter("user-password");
        String rePassword = req.getParameter("user-re-password");

        User checkUser = DBManager.getUser(email);
        if(checkUser == null){
            redirect ="/add-user?password-not-match";
            if(rePassword.equals(password)) {
                User user = new User();
                user.setFull_name(name);
                user.setEmail(email);
                user.setPassword(password);
                user.setRole_id(2L);
                if (DBManager.addUser(user) == true) {
                    redirect = "/home";
                    req.getSession().setAttribute("currentUser",user);
                }
            }
        }
        resp.sendRedirect(redirect);
    }
}
