//package kz.bitlab.javaEE.Task_1_7;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import kz.bitlab.javaEE.JSP.DBManager;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//@WebServlet(value="/add-player")
//public class AddPlayer extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html");
//        PrintWriter out = resp.getWriter();
//        out.print("<from action='/add-player' method='post'");
//        out.print("<p>NAME: <input type='text' placeholder='Insert name' name='player-name'</p>");
//        out.print("<p>SURNAME: <input type='text' placeholder='Insert surname' name='player-surname'</p>");
//        out.print("<p>CLUB: <select name='player-club'><option>Real Madrid CF</option><option>Manchester United</option></select></p>");
//        out.print("<p>SALARY: <input type='number' placeholder='Insert salary' name='player-salary'</p>");
//        out.print("<p>TRANSFER PRICE: <input type='number' placeholder='Insert transfer price' name='player-transfer-price'</p>");
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getParameter("player-name");
//        String surname = req.getParameter("player-surname");
//        String club = req.getParameter("player-club");
//        int salary = Integer.parseInt(req.getParameter("player-salary"));
//        int transferPrice = Integer.parseInt(req.getParameter("player"));
//        Footballer player = new Footballer();
//        player.setName(name);
//        player.setSurname(surname);
//        player.setClub(club);
//        player.setSalary(salary);
//        player.setTransferPrice(transferPrice);
//        DBManager.addFootballer(player);
//
//    }
//}
