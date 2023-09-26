package kz.rakhimov.spring_complex_work_cars_marketplace.controllers;

import kz.rakhimov.spring_complex_work_cars_marketplace.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/cars")
public class HomeController {
    @Autowired
    public CarService carService;
    @GetMapping(value = "/home")
    public String openHome(){
        return "home";
    }
    @GetMapping(value = "/add-car")
    public String openAddCar(){
        return "add-car";
    }
    @GetMapping(value="/details/{id}")
    public String openDetails(Model model, @PathVariable("id") Long id){
        model.addAttribute("car", carService.getCar(id));
        return "details";
    }
    @PostMapping(value="/{id}")
    public void deleteCar(@PathVariable("id") Long id){
        carService.deleteCar(id);
    }
}