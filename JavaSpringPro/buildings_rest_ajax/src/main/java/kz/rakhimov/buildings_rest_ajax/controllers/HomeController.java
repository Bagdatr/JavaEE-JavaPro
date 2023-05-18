package kz.rakhimov.buildings_rest_ajax.controllers;

import kz.rakhimov.buildings_rest_ajax.entities.ServiceCompany;
import kz.rakhimov.buildings_rest_ajax.services.ServiceCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value="/buildings")
public class HomeController {
    @Autowired
    public ServiceCompanyService serviceCompanyService;
    @GetMapping(value="/home")
    public String openHome(){
        return "home";
    }
    @GetMapping(value = "/add-building")
    public String openAddBuilding(Model model){
        List<ServiceCompany> serviceCompanies = serviceCompanyService.getAllServiceCompanies();
        model.addAttribute("serviceCompanies", serviceCompanies);
        return "add-building";
    }

}
