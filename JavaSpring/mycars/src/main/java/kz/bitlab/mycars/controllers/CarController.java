package kz.bitlab.mycars.controllers;

import kz.bitlab.mycars.entities.Car;
import kz.bitlab.mycars.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/car")
public class CarController {
    @Autowired
    private CarRepository carRepository;
    @GetMapping(value="/add-car")
    public String openAddCar(){
        return "add-car";
    }

    @PostMapping(value="/add-car")
    public String addCar(@RequestParam(name="car-name")String name,
                         @RequestParam(name="car-price")int price){
        String redirect = "/car/add-car?error";
        Car car = new Car();
        car.setName(name);
        car.setPrice(price);
        if(carRepository.save(car) != null){
            redirect = "/car/add-car?success";
        }
        return "redirect:" + redirect;
    }


}
