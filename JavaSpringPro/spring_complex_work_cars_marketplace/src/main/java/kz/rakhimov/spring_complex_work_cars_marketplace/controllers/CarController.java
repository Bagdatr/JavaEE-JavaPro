package kz.rakhimov.spring_complex_work_cars_marketplace.controllers;

import kz.rakhimov.spring_complex_work_cars_marketplace.entities.CarDto;
import kz.rakhimov.spring_complex_work_cars_marketplace.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping
    public List<CarDto> getAllCars(){
        return carService.getAllCars();
    }

    @PostMapping
    public CarDto addCar(@RequestBody CarDto carDto){
        return carService.addCar(carDto);
    }

    @PutMapping
    public CarDto updateCar(@RequestBody CarDto updCarDto){
        return carService.updateCar(updCarDto);
    }

    @GetMapping(value="/{id}")
    public CarDto getCar(@PathVariable("id") Long id){
        return carService.getCar(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCar(@PathVariable("id") Long id){
        carService.deleteCar(id);
    }
}