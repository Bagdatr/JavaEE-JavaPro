package kz.bitlab.springSprintTask_3_1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/student")
public class StudentSuccessController {
    @GetMapping(value="/add-student-success")
    public String openAddStudent(){
        return "add-student-success";
    }
    @PostMapping(value="/add-student-success")
    public String addStudent(@RequestParam(name="student-name") String name,
                             @RequestParam(name="student-surname") String surname,
                             @RequestParam(name="student-exam") int exam){
        String redirect = "/student/add-student?error";
        Student student = new Student();
        student.setName(name);
        student.setSurname(surname);
        student.setExam(exam);
        if(exam >=90){
            student.setMark("A");
        }else if(exam >= 75 && exam <= 89){
            student.setMark("B");
        }else if(exam >= 60 && exam <= 74){
            student.setMark("C");
        }else if(exam >= 50 && exam <= 59){
            student.setMark("D");
        }else{
            student.setMark("F");
        }
        if(DBManager.addStudent(student) == true){
            redirect = "/student/add-student-success";
        }
        return "redirect:" + redirect;
    }

}
