package kz.bitlab.springjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping(value="/add-user")
    public String openAddUser(){
        return "add-user";
    }
    @PostMapping(value="/add-user")
    public String addUserPost(@RequestParam(name="user-name")String name,
                              @RequestParam(name="user-surname")String surname,
                              @RequestParam(name="user-age")int age){
        String redirect = "/user/add-user?error";
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setAge(age);
        if(userRepository.save(user) != null){
            redirect = "/user/add-user?success";
        }
        return "redirect:" + redirect;
    }
}
