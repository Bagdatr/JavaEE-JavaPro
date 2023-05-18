package kz.rakhimov.spring_complex_work_cars_marketplace.services;

import kz.rakhimov.spring_complex_work_cars_marketplace.entities.Brand;

import java.util.List;

public interface BrandService {
    Brand addBrand(Brand brand);
    List<Brand> getAllBrands();
    Brand updateBrand(Brand updBrand);
    void deleteBrand(Long id);
}
