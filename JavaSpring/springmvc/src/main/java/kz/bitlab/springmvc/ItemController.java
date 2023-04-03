package kz.bitlab.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;


@Controller
@RequestMapping(value = "/item")
public class ItemController {
    @GetMapping(value = "/add-item")
    public String openAddItem() {
        return "add-item";
    }

    @PostMapping(value = "/add-item")
    public String addItemPost(@RequestParam(name = "item-name") String name,
                              @RequestParam(name = "item-price") int price,
                              @RequestParam(name = "item-amount") int amount) {
        String redirect = "/item/add-item?error";
        Item item = new Item();
        item.setName(name);
        item.setPrice(price);
        item.setAmount(amount);
        if (DBManager.addItem(item) == true) {
            redirect = "/item/add-item?success";
        }
        return "redirect:" + redirect;
    }
    @GetMapping(value="/home")
    public String openHome(Model model){
        ArrayList<Item> items = DBManager.getAllItems();
        model.addAttribute("items",items);
        return "home";
    }
}
