package javaEE;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(value="/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String redirect = "/register?email-already-exists";
        String email = req.getParameter("user-email");
        String password = req.getParameter("user-password");
        String rePassword = req.getParameter("user-re-password");

        User checkUser = DBManager.getUser(email);
        if(checkUser == null){
            redirect = "/register?password-not-matched";
            if(password.equals(rePassword)){
                User user = new User();
                user.setEmail(email);
                user.setPassword(password);
                if(DBManager.addUser(user) == true){
                    redirect = "/register?success";
                }
            }
        }

        resp.sendRedirect(redirect);
    }
}
