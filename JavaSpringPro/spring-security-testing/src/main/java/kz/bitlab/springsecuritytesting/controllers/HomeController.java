package kz.bitlab.springsecuritytesting.controllers;

import kz.bitlab.springsecuritytesting.entities.Users;
import kz.bitlab.springsecuritytesting.services.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value="/")
public class HomeController {
    @Autowired
    private MyUserService userService;
    @GetMapping(value="/login")
    public String openLogin(){
        return "login";
    }
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_MODERATOR')")
    @GetMapping(value="/home")
    public String openHome(){
        return "home";
    }
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
    @GetMapping(value="/profile")
    public String openProfile(){
        return "profile";
    }
    @GetMapping(value="/register")
    public String openRegister(){
        return "register";
    }
    @PostMapping(value="/register")
    public String registerPost(@RequestParam("user-full-name")String fullName,
                               @RequestParam("user-email")String email,
                               @RequestParam("user-password")String password,
                               @RequestParam("user-re-password")String rePassword){
        String redirect = "";
        String check = userService.registerUser(fullName,email,password,rePassword);
        if(check.equals("user_register_success")){
            redirect = "/register?success";
        }else if(check.equals("user_exists")){
            redirect = "/register?user_exists";
        }else{
            redirect = "register?password_not_match";
        }
        return "redirect:" + redirect;
    }
    @PreAuthorize("isAuthenticated()")
    @GetMapping(value="/change-password")
    public String openChangePassword(){
        return "change-password";
    }

    @PostMapping(value="/change-password")
    public String ChangePasswordPost(@RequestParam(name="user-email")String email,
                                     @RequestParam(name="user-old-password")String oldPassword,
                                     @RequestParam(name="user-new-password")String newPassword,
                                     @RequestParam(name="user-re-password")String rePassword){
        String redirect = "";
        String check = userService.changePassword(email,oldPassword,newPassword,rePassword);
        if(check.equals("change_password_success")){
            redirect = "/profile";
        }else if(check.equals("new_password_not_match")){
            redirect = "/change-password?new_password_not_match";
        }else if(check.equals("incorrect_old_password")){
            redirect = "/change-password?incorrect_old_password";
        }else{
            redirect = "/change-password?user_not_found";
        }
        return "redirect:" + redirect;
    }

    @GetMapping(value="/403")
    public String openAccessDenied(){
        return "403";
    }

}
