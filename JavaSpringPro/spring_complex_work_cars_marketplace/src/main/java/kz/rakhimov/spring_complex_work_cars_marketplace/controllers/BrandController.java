package kz.rakhimov.spring_complex_work_cars_marketplace.controllers;

import kz.rakhimov.spring_complex_work_cars_marketplace.entities.Brand;
import kz.rakhimov.spring_complex_work_cars_marketplace.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/brand")
public class BrandController {
    @Autowired
    public BrandService brandService;
    @PostMapping
    public Brand addBrand(@RequestBody Brand brand){
        return brandService.addBrand(brand);
    }
    @GetMapping
    public List<Brand> getAllBrands(){
        return brandService.getAllBrands();
    }
    @PutMapping
    public Brand updateBrand(@RequestBody Brand updBrand){
        return brandService.updateBrand(updBrand);
    }
    @DeleteMapping(value = "/{id}")
    public void deleteBrand(@PathVariable("id") Long id){
        brandService.deleteBrand(id);
    }
}
