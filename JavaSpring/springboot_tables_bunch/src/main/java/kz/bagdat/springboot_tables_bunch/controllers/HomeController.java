package kz.bagdat.springboot_tables_bunch.controllers;

import kz.bagdat.springboot_tables_bunch.beans.FirstBean;
import kz.bagdat.springboot_tables_bunch.beans.TestBean;
import kz.bagdat.springboot_tables_bunch.beans.ThirdBean;
import kz.bagdat.springboot_tables_bunch.beans.ThirdBeanImpl;
import kz.bagdat.springboot_tables_bunch.db.DBManager;
import kz.bagdat.springboot_tables_bunch.db.Items;
import kz.bagdat.springboot_tables_bunch.entities.Categories;
import kz.bagdat.springboot_tables_bunch.entities.Countries;
import kz.bagdat.springboot_tables_bunch.entities.ShopItems;
import kz.bagdat.springboot_tables_bunch.repositories.CountryRepository;
import kz.bagdat.springboot_tables_bunch.services.ItemService;
import kz.bagdat.springboot_tables_bunch.services.TestService;
import kz.bagdat.springboot_tables_bunch.services.impl.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ItemService itemService;

    @GetMapping(value="/")
    public String index(Model model){

        List<ShopItems> items = itemService.getAllItems();
        model.addAttribute("tovary",items);

        List<Countries> countries = itemService.getAllCountries();
        model.addAttribute("countries", countries);

        return "index";
    }

    @PostMapping(value="/additem")
    public String addItem(@RequestParam(name="country_id",defaultValue = "0") Long countryId,
                          @RequestParam(name="item_name",defaultValue = "No Item") String name,
                          @RequestParam(name="item_price",defaultValue = "0") int price,
                          @RequestParam(name="item_amount",defaultValue = "0") int amount){

        Countries cnt = itemService.getCountry(countryId);

        if(cnt!=null){
            ShopItems item = new ShopItems();
            item.setName(name);
            item.setPrice(price);
            item.setAmount(amount);
            item.setCountry(cnt);
            itemService.addItem(item);
        }
        return "redirect:/";
    }

    @GetMapping(value="/details/{idshka}")
    public String details(Model model, @PathVariable(name="idshka") Long id){

        ShopItems item = itemService.getItem(id);
        model.addAttribute("item", item);

        List<Countries> countries = itemService.getAllCountries();
        model.addAttribute("countries", countries);

        List<Categories> categories = itemService.getAllCategories();
        model.addAttribute("categories",categories);

        return "details";
    }

    @PostMapping(value="/saveitem")
    public String saveItem(@RequestParam(name="id",defaultValue = "0") Long id,
                           @RequestParam(name="country_id",defaultValue = "0") Long countryId,
                           @RequestParam(name="item_name",defaultValue = "No Item") String name,
                           @RequestParam(name="item_price",defaultValue = "0") int price,
                           @RequestParam(name="item_amount",defaultValue = "0") int amount){
        ShopItems item = itemService.getItem(id);

        if(item != null){

            Countries cnt = itemService.getCountry(countryId);

            if(cnt!=null) {

                item.setName(name);
                item.setPrice(price);
                item.setAmount(amount);
                item.setCountry(cnt);
                itemService.saveItem(item);

            }
        }
        return "redirect:/";
    }

    @PostMapping(value="/deleteitem")
    public String deleteItem(@RequestParam(name="id",defaultValue = "0") Long id){
        ShopItems item = itemService.getItem(id);
        itemService.deleteItem(item);
        return "redirect:/";
    }

    @PostMapping(value="/assigncategory")
    public String assignCategory(@RequestParam(name="item_id") Long itemId,
                                 @RequestParam(name="category_id") Long categoryId){
        Categories cat = itemService.getCategory(categoryId);
        if(cat != null){

            ShopItems item = itemService.getItem(itemId);
            if(item != null){

                List<Categories> categories = item.getCategories();
                if(categories == null){
                    categories = new ArrayList<>();
                }
                categories.add(cat);

                itemService.saveItem(item);

                return "redirect:/details/" + itemId;

            }

        }
        return "redirect:/";
    }
}
