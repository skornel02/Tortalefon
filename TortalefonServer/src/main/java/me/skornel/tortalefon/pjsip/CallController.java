package me.skornel.tortalefon.pjsip;

import me.skornel.tortalefon.callback.Callback;
import me.skornel.tortalefon.callback.CallbackManager;
import me.skornel.tortalefon.callback.CallbackType;
import me.skornel.tortalefon.pjsip.CallWrapper;
import me.skornel.tortalefon.pjsip.NewCall;
import me.skornel.tortalefon.pjsip.SipManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CallController {

    private final SipManager sipManager;
    private final CallbackManager callbackManager;

    @Autowired
    public CallController(SipManager sipManager,
                          CallbackManager callbackManager) {
        this.sipManager = sipManager;
        this.callbackManager = callbackManager;
    }

    @GetMapping(path = "/calls")
    public String returnCallsPage(Model model){
        sipManager.registerThread();
        model.addAttribute("name",SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("sip", sipManager.getCalls());
        return "calls";
    }

    @GetMapping(path = "getcalls")
    public ResponseEntity returnCalls(){
        return ResponseEntity.ok(sipManager.getCalls());
    }

    @GetMapping(path = "/callform")
    public String returnHomePage(Model model, @ModelAttribute("errors") String errors){
        sipManager.registerThread();
        model.addAttribute("call", new NewCall());
        model.addAttribute("erros", errors);
        return "callform";
    }

    @PostMapping(path = "/createcall")
    public String newCall(@ModelAttribute NewCall newCall, Model model, RedirectAttributes redirectAttributes){
        sipManager.registerThread();
        CallWrapper call = sipManager.callAddress(newCall);
        if(call == null){
            redirectAttributes.addAttribute("errors", "URL Invalid!");
            return "redirect:callform";
        }
        return "redirect:calls";
    }

    @PostMapping(path = "/terminatecall")
    public String terminateCall(@RequestParam int id){
        sipManager.registerThread();
        sipManager.removeCall(id);
        return "redirect:calls";
    }

    @PostMapping(path = "/holdcall")
    public String holdCall(@RequestParam int id){
        sipManager.registerThread();
        sipManager.holdCall(id);
        return "redirect:calls";
    }

    @GetMapping(path = "/callstatus")
    @ResponseBody
    public String isRinging(){
        sipManager.registerThread();
        StringBuilder builder = new StringBuilder();
        sipManager.getCalls().forEach(call -> builder.append(call.getStatus()).append("\n"));
        return builder.toString();
    }

    @GetMapping(path = "/ring")
    @ResponseBody
    public ResponseEntity ringEveryone(){
        List<Callback> callbacks = callbackManager.getCallbacks();
        for (Callback callback : callbacks){
            if(callback.getType() == CallbackType.FIX_ADDRESS){
                sipManager.callAddress(callback.getAddress());
            }
        }
        return ResponseEntity.accepted().build();
    }

}
