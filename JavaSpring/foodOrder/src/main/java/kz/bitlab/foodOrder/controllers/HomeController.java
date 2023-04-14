package kz.bitlab.foodOrder.controllers;

import kz.bitlab.foodOrder.entities.Order;
import kz.bitlab.foodOrder.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value="/home")
public class HomeController {
    @Autowired
    private OrderRepository orderRepository;
    @GetMapping(value="/add-order")
    public String openAddOrder(){
        return "add-order";
    }
    @PostMapping(value="/add-order")
    public String addOrder(@RequestParam(name="user-name")String name,
                           @RequestParam(name="food-name")String food,
                           @RequestParam(name="food-amount")int amount,
                           @RequestParam(name="user-address")String address){
        String redirect = "/home/add-order?error";
        Order order = new Order();
        order.setUserName(name);
        String [] foodSplit = food.split(" ");
        order.setFoodName(foodSplit[0]);
        order.setAmount(amount);
        order.setPrice(Integer.parseInt(foodSplit[1]) * amount);
        order.setAddress(address);
        order.setLinkToImage(foodSplit[2]);
        if(orderRepository.save(order) != null){
            redirect = "/home/all-orders";
        }
        return "redirect:" + redirect;
    }

    @GetMapping(value="/all-orders")
    public String openAllOrders(Model model){
        List<Order> orders = orderRepository.findAll();
        model.addAttribute("orders",orders);
        return "all-orders";
    }

}
