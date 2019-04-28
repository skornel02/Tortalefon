package me.skornel.tortalefon.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final UserManager userManager;
    private final PasswordEncoder encoder;

    @Autowired
    public UserController(UserManager userManager, PasswordEncoder encoder) {
        this.userManager = userManager;
        this.encoder = encoder;
    }

    @GetMapping(path = "/users")
    public String returnUserPage(Model model){
        model.addAttribute("users", userManager.getUsers());
        model.addAttribute("newUser", new User());
        return "users";
    }

    @GetMapping(path = "/getusers")
    public ResponseEntity returnUsers(){
        return ResponseEntity.ok(userManager.getUsers());
    }

    @PostMapping(path = "/adduser")
    public String addUser(@ModelAttribute User user){
        user.setPassword(encoder.encode(user.getPassword()));
        userManager.addUser(user);
        return "redirect:/users";
    }

    @PostMapping(path = "/removeuser")
    public String removeUser(@RequestParam String username){
        userManager.removeUser(username);
        return "redirect:/users";
    }

}
