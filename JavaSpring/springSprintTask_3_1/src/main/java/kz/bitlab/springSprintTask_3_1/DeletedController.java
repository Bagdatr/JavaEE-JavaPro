package kz.bitlab.springSprintTask_3_1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/deleted")
public class DeletedController {
    @GetMapping()
    public String openDeleted(){
        return "/deleted";
    }
}
