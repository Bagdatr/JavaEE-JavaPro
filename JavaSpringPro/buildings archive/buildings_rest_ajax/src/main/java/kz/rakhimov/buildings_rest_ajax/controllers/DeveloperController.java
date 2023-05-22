package kz.rakhimov.buildings_rest_ajax.controllers;

import kz.rakhimov.buildings_rest_ajax.entities.Developer;
import kz.rakhimov.buildings_rest_ajax.services.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/developer")
public class DeveloperController {
    @Autowired
    public DeveloperService developerService;
    @GetMapping
    public List<Developer> openAllDevelopers(){
        return developerService.getAllDevelopers();
    }
    @PostMapping
    public Developer addDeveloper(@RequestBody Developer developer){
        return developerService.addDeveloper(developer);
    }
    @GetMapping(value="/{id}")
    public Developer getDeveloper(@PathVariable("id") Long id){
        return developerService.getDeveloper(id);
    }
    @PutMapping
    public Developer updateDeveloper(@RequestBody Developer updDeveloper){
        return developerService.updateDeveloper(updDeveloper);
    }
    @DeleteMapping(value="/{id}")
    public void deleteDeveloper(@PathVariable("id") Long id){
        developerService.deleteDeveloper(id);
    }
}
