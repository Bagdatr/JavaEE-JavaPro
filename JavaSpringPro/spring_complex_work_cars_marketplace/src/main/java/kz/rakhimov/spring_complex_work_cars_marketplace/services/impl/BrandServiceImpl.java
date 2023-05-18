package kz.rakhimov.spring_complex_work_cars_marketplace.services.impl;

import kz.rakhimov.spring_complex_work_cars_marketplace.entities.Brand;
import kz.rakhimov.spring_complex_work_cars_marketplace.repositories.BrandRepository;
import kz.rakhimov.spring_complex_work_cars_marketplace.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository brandRepository;
    @Override
    public Brand addBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    @Override
    public Brand updateBrand(Brand updBrand) {
        Brand brand = brandRepository.findAllById(updBrand.getId());
        brand.setName(updBrand.getName());
        return brandRepository.save(brand);
    }

    @Override
    public void deleteBrand(Long id) {
        brandRepository.deleteById(id);
    }
}
