package kz.bitlab.springsecuritytesting.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/")
public class HomeController {
    @GetMapping(value="/login")
    public String openLogin(){
        return "login";
    }
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_MODERATOR')")
    @GetMapping(value="/home")
    public String openHome(){
        return "home";
    }
}
