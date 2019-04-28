package me.skornel.tortalefon;

import me.skornel.tortalefon.pjsip.SipManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    SipManager sipManager;

    @Override
    public void run(String... args) throws Exception {
        //CallWrapper call = sipManager.callAddress("sip:192.168.0.16");
    }


}
