package kz.rakhimov.spring_complex_work_cars_marketplace.mapper;

import kz.rakhimov.spring_complex_work_cars_marketplace.entities.Car;
import kz.rakhimov.spring_complex_work_cars_marketplace.entities.CarDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {
    List<CarDto> mapToDtoList(List<Car> cars);
    CarDto mapToDto(Car car);
}
