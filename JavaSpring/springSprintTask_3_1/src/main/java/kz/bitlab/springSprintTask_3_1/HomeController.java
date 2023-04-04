package kz.bitlab.springSprintTask_3_1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    @GetMapping(value="/details")
    public String getId(@RequestParam(name="id") Long id,Model model){
        Student student = DBManager.getStudent(id);
        model.addAttribute("student",student);
        return "details";
    }
}