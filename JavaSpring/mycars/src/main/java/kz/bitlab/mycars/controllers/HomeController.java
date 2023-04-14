package kz.bitlab.mycars.controllers;

import kz.bitlab.mycars.entities.Car;
import kz.bitlab.mycars.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value="/home")
public class HomeController {
    @Autowired
    private CarRepository carRepository;
    @GetMapping()
    public String openHome(Model model){
        List<Car> cars = carRepository.findAll();
        model.addAttribute("cars",cars);
        return "home";
    }
}
