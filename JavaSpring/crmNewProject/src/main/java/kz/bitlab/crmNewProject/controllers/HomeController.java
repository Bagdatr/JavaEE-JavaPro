package kz.bitlab.crmNewProject.controllers;

import kz.bitlab.crmNewProject.entities.Course;
import kz.bitlab.crmNewProject.entities.Request;
import kz.bitlab.crmNewProject.services.CourseService;
import kz.bitlab.crmNewProject.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value="/request")
public class HomeController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private RequestService requestService;
    @GetMapping(value="/add-request")
    public String openAddRequest(Model model){
        List<Course> courses = courseService.getAllCourses();
        model.addAttribute("courses",courses);
        return "add-request";
    }
    @GetMapping(value="/add-course")
    public String openAddCourse(){
        return "add-course";
    }
    @PostMapping(value="/add-course")
    public String addCoursePost(@RequestParam(name="course-name")String name,
                                @RequestParam(name="course-description")String description,
                                @RequestParam(name="course-price")int price){
        String redirect = "/request/add-course?error";
        Course course = Course.builder()
                .name(name)
                .description(description)
                .price(price)
                .build();
        if(courseService.addCourse(course) != null) {
            redirect = "/request/add-course?success";
        }
        return "redirect:" + redirect;
    }
    @PostMapping(value="/add-request")
    public String addRequestPost(@RequestParam(name="request-name")String name,
                                 @RequestParam(name="request-course-id")Course course,
                                 @RequestParam(name="request-phone")String phone,
                                 @RequestParam(name="request-comment")String comment){
        String redirect = "/request/add-request?error";
        Request request = Request.builder()
                .fullName(name)
                .course(course)
                .phone(phone)
                .comment(comment)
                .build();
        if(requestService.addRequest(request) != null){
            redirect = "/request/add-request?success";
        }
        return "redirect:" + redirect;
    }
}
