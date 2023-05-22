package kz.rakhimov.buildings_rest_ajax.controllers;

import kz.rakhimov.buildings_rest_ajax.entities.ServiceCompany;
import kz.rakhimov.buildings_rest_ajax.services.ServiceCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/service-company")
public class ServiceCompanyController {
    @Autowired
    public ServiceCompanyService serviceCompanyService;

    @GetMapping
    public List<ServiceCompany> getAllServiceCompanies(){
        return serviceCompanyService.getAllServiceCompanies();
    }
    @PostMapping
    public ServiceCompany addServiceCompany(@RequestBody ServiceCompany serviceCompany){
        return serviceCompanyService.addServiceCompany(serviceCompany);
    }
    @DeleteMapping(value="/{id}")
    public void deleteServiceCompaty(@PathVariable("id") Long id){
        serviceCompanyService.deleteServiceCompany(id);
    }
}
