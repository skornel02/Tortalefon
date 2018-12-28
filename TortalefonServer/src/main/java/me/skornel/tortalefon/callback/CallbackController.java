package me.skornel.tortalefon.callback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CallbackController {

    private final CallbackManager callbackManager;

    @Autowired
    public CallbackController(CallbackManager callbackManager) {
        this.callbackManager = callbackManager;
    }
    @GetMapping(path = "/callbacks")
    public String returnCallbacks(Model model){
        model.addAttribute("newCallback", new Callback());
        model.addAttribute("callbacks", callbackManager.getCallbacks());
        return "callbacks";
    }

    @GetMapping(path = "/getcallbacks")
    public ResponseEntity returnCallbacks(){
        return ResponseEntity.ok(callbackManager.getCallbacks());
    }

    @PostMapping(path = "/addcallback")
    public String addWifi(@ModelAttribute Callback callback, Model model){
        callbackManager.addCallback(callback);
        return "redirect:/callbacks";
    }

    @PostMapping(path = "/removecallback")
    public String removeWifi(@RequestParam String name){
        callbackManager.removeCallback(name);
        return "redirect:/callbacks";
    }

}
