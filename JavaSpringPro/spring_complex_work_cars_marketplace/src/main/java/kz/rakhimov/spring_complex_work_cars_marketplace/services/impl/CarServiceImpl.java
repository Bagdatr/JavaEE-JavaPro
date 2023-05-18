package kz.rakhimov.spring_complex_work_cars_marketplace.services.impl;

import kz.rakhimov.spring_complex_work_cars_marketplace.entities.Car;
import kz.rakhimov.spring_complex_work_cars_marketplace.entities.CarDto;
import kz.rakhimov.spring_complex_work_cars_marketplace.mapper.CarMapper;
import kz.rakhimov.spring_complex_work_cars_marketplace.repositories.CarRepository;
import kz.rakhimov.spring_complex_work_cars_marketplace.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    CarRepository carRepository;
    @Autowired
    CarMapper carMapper;
    @Override
    public CarDto addCar(CarDto carDto) {
        Car car = new Car();
        car.setModel(carDto.getModel());
        car.setYear(carDto.getYear());
        car.setMonth(carDto.getMonth());

        String uuidCode = UUID.randomUUID().toString();
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < uuidCode.length(); i++){
            if(uuidCode.charAt(i) == '-'){
                arr.add(i);
            }
        }
        String partOfUuid = "";
        for(int i = arr.get(1); i < arr.get(3); i++){
            partOfUuid += uuidCode.charAt(i);
        }

//        String [] uuidCodeArray = uuidCode.split("-");
//        String partOfUuidCode = uuidCode.substring(14,23);
        String month = String.valueOf(carDto.getMonth());
        if(carDto.getMonth()<10){
            month = "0" + carDto.getMonth();
        }
//        String vin = carDto.getYear() + "-" + month + "-" + uuidCodeArray[2] + "-" + uuidCodeArray[3];
        String vin = carDto.getYear() + "-" + month + partOfUuid;
        car.setVin(vin);
        car.setBrands(carDto.getBrands());

        return carMapper.mapToDto(carRepository.save(car));
    }

    @Override
    public List<CarDto> getAllCars() {
        return carMapper.mapToDtoList(carRepository.findAll());
    }

    @Override
    public CarDto getCar(Long id) {
        return carMapper.mapToDto(carRepository.findAllById(id));
    }

    @Override
    public CarDto updateCar(CarDto updCarDto) {
        Car car = carRepository.findAllById(updCarDto.getId());
        car.setModel(updCarDto.getModel());
        car.setYear(updCarDto.getYear());
        car.setMonth(updCarDto.getMonth());
        String uuidCode = UUID.randomUUID().toString();
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < uuidCode.length(); i++){
            if(uuidCode.charAt(i) == '-'){
                arr.add(i);
            }
        }
        String partOfUuid = "";
        for(int i = arr.get(1); i < arr.get(3); i++){
            partOfUuid += uuidCode.charAt(i);
        }
        String month = String.valueOf(updCarDto.getMonth());
        if(updCarDto.getMonth()<10){
            month = "0" + updCarDto.getMonth();
        }
        String vin = updCarDto.getYear() + "-" + month + partOfUuid;
        car.setVin(vin);
        return carMapper.mapToDto(carRepository.save(car));
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}
