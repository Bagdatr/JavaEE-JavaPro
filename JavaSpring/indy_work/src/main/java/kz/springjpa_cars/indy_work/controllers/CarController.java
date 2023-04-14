package kz.springjpa_cars.indy_work.controllers;

import kz.springjpa_cars.indy_work.entities.Car;
import kz.springjpa_cars.indy_work.repositories.CarRepository;
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
                         @RequestParam(name="car-body")String body,
                         @RequestParam(name="car-engine")double engine,
                         @RequestParam(name="car-price")int price){
        String redirect = "/car/add-car?error";
        Car car = new Car();
        car.setName(name);
        car.setBodyType(body);
        car.setEngine(engine);
        car.setPrice(price);
        if(carRepository.save(car) != null){
            redirect = "/car/add-car?success";
        }
        return "redirect:" + redirect;
    }
}
