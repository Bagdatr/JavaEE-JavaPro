package kz.bitlab.springSprintTask_3_1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/student")
public class StudentController {
    @GetMapping(value = "/add-student")
    public String openAddStudent() {
        return "add-student";
    }

    @PostMapping(value = "/add-student")
    public String addStudent(@RequestParam(name = "student-name") String name,
                             @RequestParam(name = "student-surname") String surname,
                             @RequestParam(name = "student-exam") int exam) {
        String redirect = "/student/add-student?error";
        Student student = new Student();
        student.setName(name);
        student.setSurname(surname);
        student.setExam(exam);
        if (exam >= 90) {
            student.setMark("A");
        } else if (exam >= 75 && exam <= 89) {
            student.setMark("B");
        } else if (exam >= 60 && exam <= 74) {
            student.setMark("C");
        } else if (exam >= 50 && exam <= 59) {
            student.setMark("D");
        } else {
            student.setMark("F");
        }
        if (DBManager.addStudent(student) == true) {
            redirect = "/home";
        }
        return "redirect:" + redirect;
    }

    @PostMapping(value = "/update-student")
    public String updateStudent(@RequestParam(name = "student-id") Long id,
                                @RequestParam(name = "student-name") String name,
                                @RequestParam(name = "student-surname") String surname,
                                @RequestParam(name = "student-exam") int exam) {
        String redirect = "/student/update-student?error";
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setSurname(surname);
        student.setExam(exam);
        if (exam >= 90) {
            student.setMark("A");
        } else if (exam >= 75 && exam <= 89) {
            student.setMark("B");
        } else if (exam >= 60 && exam <= 74) {
            student.setMark("C");
        } else if (exam >= 50 && exam <= 59) {
            student.setMark("D");
        } else {
            student.setMark("F");
        }
        if (DBManager.updateStudent(student) == true) {
            redirect = "/home";
        }
        return "redirect:" + redirect;
    }

    @PostMapping(value = "/delete-student")
    public String deleteStudent(@RequestParam(name = "student-id") Long id) {
        String redirect = "/student/delete-student?error";
        if (DBManager.deleteStudent(id) == true) {
            redirect = "/deleted";
        }
        return "redirect:" + redirect;
    }
}
