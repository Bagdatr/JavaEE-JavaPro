package kz.bagdat.springboot_tables_bunch.services;

import kz.bagdat.springboot_tables_bunch.entities.Categories;
import kz.bagdat.springboot_tables_bunch.entities.Countries;
import kz.bagdat.springboot_tables_bunch.entities.ShopItems;

import java.util.List;

public interface ItemService {

    ShopItems addItem(ShopItems item);
    List<ShopItems> getAllItems();
    ShopItems getItem(Long id);
    void deleteItem(ShopItems item);
    ShopItems saveItem(ShopItems item);

    List<Countries> getAllCountries();
    Countries addCountry(Countries country);
    Countries saveCountry(Countries country);
    Countries getCountry(Long id);

    List<Categories> getAllCategories();
    Categories getCategory(Long id);
    Categories saveCategory(Categories category);
    Categories addCategory(Categories categories);
}
