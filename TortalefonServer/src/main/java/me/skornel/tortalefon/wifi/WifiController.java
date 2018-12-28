package me.skornel.tortalefon.wifi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WifiController {

    private final WifiManager wifiManager;

    @Autowired
    public WifiController(WifiManager wifiManager) {
        this.wifiManager = wifiManager;
    }

    @GetMapping(path = "/wifi")
    public String returnWifiPage(Model model){
        model.addAttribute("online", wifiManager.isInternetAccess());
        model.addAttribute("address", wifiManager.getAddress());
        model.addAttribute("networks", wifiManager.getNetworks());
        model.addAttribute("newNetwork", new Network());
        return "wifi";
    }

    @GetMapping(path = "/getwifi")
    public ResponseEntity returnWifiData(){
        return ResponseEntity.ok(wifiManager.getNetworks());
    }

    @PostMapping(path = "/addwifi")
    public String addWifi(@ModelAttribute Network network, Model model){
        wifiManager.addNetwork(network);
        return "redirect:/wifi";
    }

    @PostMapping(path = "/removewifi")
    public String removeWifi(@RequestParam String ssid){
        wifiManager.removeNetwork(ssid);
        return "redirect:/wifi";
    }

}
