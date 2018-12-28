package me.skornel.tortalefon.pjsip.overrides;

import me.skornel.tortalefon.pjsip.SipManager;
import org.pjsip.pjsua2.Account;
import org.pjsip.pjsua2.CallOpParam;
import org.pjsip.pjsua2.OnIncomingCallParam;
import org.pjsip.pjsua2.pjsip_status_code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class MyAccount extends Account {

    private SipManager manager;

    @Autowired
    public MyAccount(@Lazy SipManager manager) {
        super();
        this.manager = manager;
    }

    @Override
    public void onIncomingCall(OnIncomingCallParam prm) {
        try {
            MyCall call = new MyCall(this, prm.getCallId());
            CallOpParam param = new CallOpParam();
            param.setStatusCode(pjsip_status_code.PJSIP_SC_DECLINE);
            call.hangup(param);

            manager.addCall(call);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
