package kz.bitlab.CrmSystem_SprintTask_6_1.controllers;

import kz.bitlab.CrmSystem_SprintTask_6_1.entities.ApplicationRequest;
import kz.bitlab.CrmSystem_SprintTask_6_1.entities.Courses;
import kz.bitlab.CrmSystem_SprintTask_6_1.entities.Operators;
import kz.bitlab.CrmSystem_SprintTask_6_1.repositories.CoursesRepository;
import kz.bitlab.CrmSystem_SprintTask_6_1.repositories.OperatorsRepository;
import kz.bitlab.CrmSystem_SprintTask_6_1.repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/application")
public class RequestController {
    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private CoursesRepository coursesRepository;
    @Autowired
    private OperatorsRepository operatorsRepository;

    @GetMapping(value = "/add-request")
    public String openAddRequest(Model model) {
        model.addAttribute("courses", coursesRepository.findAll());
        return "add-request";
    }

    @PostMapping(value = "/add-request")
    public String addRequest(@RequestParam(name = "user-name") String name,
                             @RequestParam(name = "course-name") Courses course,
                             @RequestParam(name = "user-phone") String phone,
                             @RequestParam(name = "user-commentary") String commentary) {
        String redirect = "/application/add-request?error";
        ApplicationRequest applicationRequest = new ApplicationRequest();
        applicationRequest.setUserName(name);
        applicationRequest.setCourse(course);
        applicationRequest.setPhone(phone);
        applicationRequest.setCommentary(commentary);
        applicationRequest.setHandled(false);
        if (requestRepository.save(applicationRequest) != null) {
            redirect = "/application/all-requests";
        }
        return "redirect:" + redirect;
    }

    @GetMapping(value = "/all-requests")
    public String openAllRequests(Model model) {
        model.addAttribute("requests",requestRepository.findAll());
        return "all-requests";
    }

    @GetMapping(value="/all-requests-search")
    public String openAllRequestsSearch(Model model,
                                        @RequestParam(name="name-search")String name){
        List<ApplicationRequest> requests = requestRepository.findAllByUserNameContainsIgnoreCase(name);
        model.addAttribute("requests",requests);
        return "all-requests";
    }

    @GetMapping(value = "/details/{id}")
    public String openDetails(@PathVariable("id") Long id,
                              Model model) {
        model.addAttribute("details", requestRepository.findAllById(id));
        model.addAttribute("courses",coursesRepository.findAll());
        model.addAttribute("operators",operatorsRepository.findAll());
        return "details";
    }

    @PostMapping(value = "/process")
    public String processRequest(@RequestParam(name="details_id") Long id,
                                 @RequestParam(name = "operator_check") List<Operators> operatorsList) {
        String redirect = "/application/process?error";
        ApplicationRequest applicationRequest = requestRepository.findAllById(id);
        applicationRequest.setOperators(operatorsList);
        applicationRequest.setHandled(true);

        if (requestRepository.save(applicationRequest) != null) {
            redirect = "/application/details/" + id;
        }
        return "redirect:" + redirect;
    }

    @PostMapping(value = "/delete")
    public String deleteRequest(@RequestParam(name = "user-id") Long id) {
        requestRepository.deleteById(id);
        return "redirect:/application/all-requests";
    }

    @GetMapping(value = "/handled-requests")
    public String openHandledRequests(Model model) {
        model.addAttribute("handledRequests", requestRepository.findAllByHandled(true));
        return "handled-requests";
    }
    @GetMapping(value="/new-requests")
    public String openNewRequests(Model model){
        model.addAttribute("newRequests", requestRepository.findAllByHandled(false));
        return "new-requests";
    }
    @GetMapping(value="/tasks")
    public String openTasks(Model model){
        List<ApplicationRequest>requests = requestRepository.findAll();
        model.addAttribute("requests",requests);
        return "tasks";
    }
    @PostMapping(value="/task-delete")
    public String deleteTask(@RequestParam(name="user-id")Long id){
        requestRepository.deleteById(id);
        return "redirect:/application/tasks";
    }

    @PostMapping(value="/delete-operators")
    public String deleteOperators(@RequestParam(name="operator_id_to_delete")Long operatorId,
                                  @RequestParam(name="details_id")Long detailsId){
        String redirect = "/application/delete-operators?error";
        ApplicationRequest applicationRequest = requestRepository.findAllById(detailsId);
        Operators operator = operatorsRepository.findAllById(operatorId);
        List<Operators> operatorsList = applicationRequest.getOperators();
        operatorsList.remove(operator);
        applicationRequest.setOperators(operatorsList);
        if(requestRepository.save(applicationRequest) != null){
            redirect = "/application/details/" + detailsId;
        }
        return "redirect:" + redirect;
    }
}
