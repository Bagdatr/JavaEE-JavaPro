package kz.bagdat.springboot_tables_bunch.services.impl;

import kz.bagdat.springboot_tables_bunch.entities.Categories;
import kz.bagdat.springboot_tables_bunch.entities.Countries;
import kz.bagdat.springboot_tables_bunch.entities.ShopItems;
import kz.bagdat.springboot_tables_bunch.repositories.CategoryRepository;
import kz.bagdat.springboot_tables_bunch.repositories.CountryRepository;
import kz.bagdat.springboot_tables_bunch.repositories.ShopItemRepository;
import kz.bagdat.springboot_tables_bunch.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ShopItemRepository shopItemRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public ShopItems addItem(ShopItems item) {
        return shopItemRepository.save(item);
    }

    @Override
    public List<ShopItems> getAllItems() {
        return shopItemRepository.findAllByAmountGreaterThanOrderByPriceDesc(0);
    }

    @Override
    public ShopItems getItem(Long id) {
        return shopItemRepository.findByIdAndAmountGreaterThan(id,0);
    }

    @Override
    public void deleteItem(ShopItems item) {
        shopItemRepository.delete(item);
    }

    @Override
    public ShopItems saveItem(ShopItems item) {
        return shopItemRepository.save(item);
    }

    @Override
    public List<Countries> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Countries addCountry(Countries country) {
        return countryRepository.save(country);
    }

    @Override
    public Countries saveCountry(Countries country) {
        return countryRepository.save(country);
    }

    @Override
    public Countries getCountry(Long id) {
        return countryRepository.getOne(id);
    }

    @Override
    public List<Categories> getAllCategories() {
        return categoryRepository.findAll() ;
    }

    @Override
    public Categories getCategory(Long id) {
        return categoryRepository.getReferenceById(id);
    }

    @Override
    public Categories saveCategory(Categories category) {
        return categoryRepository.save(category);
    }

    @Override
    public Categories addCategory(Categories category) {
        return categoryRepository.save(category);
    }
}
