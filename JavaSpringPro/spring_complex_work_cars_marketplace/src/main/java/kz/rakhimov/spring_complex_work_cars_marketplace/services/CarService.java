package kz.rakhimov.spring_complex_work_cars_marketplace.services;

import kz.rakhimov.spring_complex_work_cars_marketplace.entities.CarDto;

import java.util.List;

public interface CarService {
    CarDto addCar(CarDto carDto);
    List<CarDto> getAllCars();
    CarDto getCar(Long id);
    CarDto updateCar(CarDto updCarDto);
    void deleteCar(Long id);
}
