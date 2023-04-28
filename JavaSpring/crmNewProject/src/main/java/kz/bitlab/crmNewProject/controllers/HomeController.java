package kz.bitlab.crmNewProject.controllers;

import kz.bitlab.crmNewProject.entities.Course;
import kz.bitlab.crmNewProject.entities.Operator;
import kz.bitlab.crmNewProject.entities.Request;
import kz.bitlab.crmNewProject.services.CourseService;
import kz.bitlab.crmNewProject.services.OperatorService;
import kz.bitlab.crmNewProject.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value="/request")
public class HomeController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private RequestService requestService;
    @Autowired
    private OperatorService operatorService;

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

    @GetMapping(value="/home")
    public String openHome(Model model){
        List<Request> requests = requestService.getAllRequests();
        model.addAttribute("requests",requests);
        return "home";
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
                .handle(false)
                .build();
        if(requestService.addRequest(request) != null){
            redirect = "/request/add-request?success";
        }
        return "redirect:" + redirect;
    }

    @GetMapping(value="/details/{id}")
    public String openDetails(@PathVariable("id") Long id,
                              Model model){
        Request request = requestService.getRequest(id);
        model.addAttribute("request",request);
        List<Course> courses = courseService.getAllCourses();
        model.addAttribute("courses",courses);
        List<Operator> operators = operatorService.getAllOperators();
        model.addAttribute("operators",operators);
        return "details";
    }

    @PostMapping(value="/operator-assign")
    public String operatorAssign(@RequestParam(name="operator") List<Operator> operators,
                                 @RequestParam(name="request-id") Long id){
        String redirect = "/request/operator-assign?error";
        Request request = requestService.getRequest(id);
        request.setOperators(operators);
        request.setHandle(true);
        if(requestService.addRequest(request) != null){
            redirect = "/request/home";
        }
        return "redirect:" + redirect;
    }

// THIS IS OPTION ONE:
//    @PostMapping(value="/operator-delete")
//    public String operatorDelete(@RequestParam(name="req-operator-id") Long operatorId,
//                                 @RequestParam(name="request-id") Long requestId){
//        Request request = requestService.getRequest(requestId);
//        int index = -1;
//        for(int i=0; i < request.getOperators().size(); i++){
//            if(request.getOperators().get(i).getId() == operatorId){
//                index = i;
//                break;
//            }
//        }
//        request.getOperators().remove(index);
//        requestService.addRequest(request);
//        return "redirect:details/" + requestId;
//    }

// THIS IS OPTION TWO:
    @PostMapping(value="/operator-delete")
    public String operatorDelete(@RequestParam(name="req-operator-id") Long operatorId,
                                 @RequestParam(name="request-id") Long requestId){
        String redirect = "/request/operator-delete?error";
        Request request = requestService.getRequest(requestId);
        Operator operator = operatorService.getOperator(operatorId);
        List<Operator> operators = request.getOperators();
        operators.remove(operator);
        request.setOperators(operators);
        if(requestService.addRequest(request) != null){
            redirect = "/request/details/" + requestId;
        }
        return "redirect:" + redirect;
    }

}
