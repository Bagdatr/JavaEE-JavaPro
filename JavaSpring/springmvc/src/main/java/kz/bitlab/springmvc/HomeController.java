package kz.bitlab.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/home")
public class HomeController {
    @GetMapping (value="/id")
    public String openId(){
        return "id";
    }
    @GetMapping(value="/cards")
    public String openCards(){
        return "cards";
    }

}
