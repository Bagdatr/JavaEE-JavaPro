package kz.rakhimov.spring_complex_work_cars_marketplace;

import kz.rakhimov.spring_complex_work_cars_marketplace.entities.Brand;
import kz.rakhimov.spring_complex_work_cars_marketplace.entities.Car;
import kz.rakhimov.spring_complex_work_cars_marketplace.entities.CarDto;
import kz.rakhimov.spring_complex_work_cars_marketplace.mapper.CarMapper;
import kz.rakhimov.spring_complex_work_cars_marketplace.repositories.BrandRepository;
import kz.rakhimov.spring_complex_work_cars_marketplace.services.BrandService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringComplexWorkCarsMarketplaceApplicationTests {

	@Autowired
	private BrandService brandService;

	@Autowired
	private BrandRepository brandRepository;

	@Autowired
	private CarMapper carMapper;



	@Test
	void contextLoads() {
	}

	@Test
	void getAllBrandsTest(){
//		Создание листа:
		List<Brand> brands = brandService.getAllBrands();
//		Проверка факта, что лист не равен null:
		Assertions.assertNotNull(brands);
	}

	@Test
	void addBrandTest(){
//		Создание объекта brand с названием "testBrandName":
		Brand brand = Brand.builder()
				.name("testBrandName")
				.build();
//		До создания объекта, полностью стираем БД:
		brandRepository.deleteAll();
//		Сохранение в объект checkReturnBrand возвращения сохраняемого объекта brand:
		Brand checkReturnBrand = brandService.addBrand(brand);
//		Проверка, что checkReturnBrand не равен null:
		Assertions.assertNotNull(checkReturnBrand);
//		Создание листа всех сохраненных в БД объектов:
		List<Brand> brands = brandRepository.findAll();
//		Проверка факта сохранения объекта в БД:
		Assertions.assertNotNull(brands);
//		Проверка, что лист не является пустым:
		Assertions.assertTrue(brands.size() > 0);
//		Проверка соответствия сохраняемого объекта с сохранненым:
		Assertions.assertEquals(checkReturnBrand.getId(), brands.get(0).getId());
//		Проверка полей сохраняемого и сохраненного объекта:
		Assertions.assertEquals(checkReturnBrand.getName(), brands.get(0).getName());
	}

	@Test
	void mapToDtoTest(){
		List<Brand> brands = brandRepository.findAll();
		Car car = Car.builder()
				.model("Ferrari")
				.year(2020)
				.month(1)
				.brands(brands)
				.build();
		CarDto carDto = carMapper.mapToDto(car);
		Assertions.assertNotNull(carDto);
		Assertions.assertEquals(car.getId(),carDto.getId());
		Assertions.assertEquals(car.getModel(),carDto.getModel());
		Assertions.assertEquals(car.getYear(),carDto.getYear());
		Assertions.assertEquals(car.getMonth(),carDto.getMonth());
		Assertions.assertEquals(car.getBrands(),carDto.getBrands());
	}

	@Test
	void updateBrand(){
		Brand brand = Brand.builder()
				.name("testBrandName")
				.build();
		Assertions.assertNotNull(brandRepository.save(brand));
		Brand updBrand = brandRepository.findAllById(brand.getId());
		Assertions.assertNotNull(updBrand);
		updBrand.setName(brand.getName());
		Assertions.assertEquals(brand.getName(), updBrand.getName());
		Assertions.assertNotNull(brandRepository.save(updBrand));
	}

}
