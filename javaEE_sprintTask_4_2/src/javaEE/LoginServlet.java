package javaEE;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(value="/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String redirect = "/login?email-error";
        String email = req.getParameter("user-email");
        String password = req.getParameter("user-password");
        User user = DBManager.getUser(email);
        if(user != null){
            redirect = "/login?password-error";
            User checkUser = new User();
            checkUser.setEmail(email);
            checkUser.setPassword(password);
            if(user.getPassword().equals(checkUser.getPassword())){
                redirect = "/home";
                req.getSession().setAttribute("currentUser",user);
            }
        }
        resp.sendRedirect(redirect);
    }
}
