package me.skornel.tortalefon.authentication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping(path = "/login")
    public String returnLoginForm(){
        return "login";
    }

    @PostMapping(path = "/login")
    public String successRedirect(){
        return "redirect:calls";
    }

}
