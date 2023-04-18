package kz.bitlab.CrmSystem_SprintTask_6_1.controllers;

import kz.bitlab.CrmSystem_SprintTask_6_1.entities.ApplicationRequest;
import kz.bitlab.CrmSystem_SprintTask_6_1.repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/application")
public class RequestController {
    @Autowired
    private RequestRepository requestRepository;

    @GetMapping(value = "/add-request")
    public String openAddRequest() {
        return "add-request";
    }

    @PostMapping(value = "/add-request")
    public String addRequest(@RequestParam(name = "user-name") String name,
                             @RequestParam(name = "course-name") String course,
                             @RequestParam(name = "user-phone") String phone,
                             @RequestParam(name = "user-commentary") String commentary) {
        String redirect = "/application/add-request?error";
        ApplicationRequest applicationRequest = new ApplicationRequest();
        applicationRequest.setUserName(name);
        applicationRequest.setCourseName(course);
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
        List<ApplicationRequest> requests = requestRepository.findAll();
        model.addAttribute("requests", requests);
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
        ApplicationRequest applicationRequest = requestRepository.findAllById(id);
        model.addAttribute("applicationRequest", applicationRequest);
        return "details";
    }

    @PostMapping(value = "/process")
    public String processRequest(@RequestParam(name = "user-id") Long id,
                                 @RequestParam(name = "user-name") String name,
                                 @RequestParam(name = "course-name") String course,
                                 @RequestParam(name = "user-phone") String phone,
                                 @RequestParam(name = "user-commentary") String commentary) {
        String redirect = "/application/process?error";
        ApplicationRequest applicationRequest = requestRepository.findAllById(id);
        applicationRequest.setUserName(name);
        applicationRequest.setCourseName(course);
        applicationRequest.setPhone(phone);
        applicationRequest.setCommentary(commentary);
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
        List<ApplicationRequest> handledRequests = requestRepository.findAllByHandled(true);
        model.addAttribute("handledRequests", handledRequests);
        return "handled-requests";
    }
    @GetMapping(value="/new-requests")
    public String openNewRequests(Model model){
        List<ApplicationRequest> newRequests = requestRepository.findAllByHandled(false);
        model.addAttribute("newRequests", newRequests);
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
}
