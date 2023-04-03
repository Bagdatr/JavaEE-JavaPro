package kz.bitlab.springSprintTask_3_1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping(value="/home")
public class HomeController {
    @GetMapping()
    public String openHome(Model model){
        ArrayList<Student> students = DBManager.getAllStudents();
        model.addAttribute("students",students);
        return "home";
    }
}
