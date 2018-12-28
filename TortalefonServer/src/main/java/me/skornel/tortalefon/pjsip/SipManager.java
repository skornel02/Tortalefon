package me.skornel.tortalefon.pjsip;

import lombok.Getter;
import me.skornel.tortalefon.pjsip.overrides.MyCall;
import me.skornel.tortalefon.wifi.WifiManager;
import org.pjsip.pjsua2.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class SipManager {

    @Getter
    private Endpoint endpoint;

    private final Account account;

    @Getter
    private Set<CallWrapper> calls;

    private final WifiManager wifiManager;

    @Autowired
    public SipManager(Account account, WifiManager wifiManager){
        this.wifiManager = wifiManager;
        try {
            calls = new HashSet<>();
            this.account = account;

            configureEndPoint();
            createLocalAccount();

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    private CallWrapper getCallOrNull(long id){
        return calls.stream().filter(c -> c.getCall().getId() == id).findFirst().orElse(null);
    }

    public void registerThread(){
        try {
            if(!endpoint.libIsThreadRegistered())
                endpoint.libRegisterThread(Thread.currentThread().getName());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void configureEndPoint() throws Exception {
        endpoint = new Endpoint();
        endpoint.libCreate();
        registerThread();

        EpConfig epConfig = new EpConfig();
        endpoint.libInit(epConfig);

        TransportConfig tpConfig = new TransportConfig();
        tpConfig.setPort(5060);
        endpoint.transportCreate(pjsip_transport_type_e.PJSIP_TRANSPORT_UDP, tpConfig);
        endpoint.libStart();
    }

    private void createLocalAccount() throws Exception {
        registerThread();
        AccountConfig accountConfig = new AccountConfig();
        accountConfig.setIdUri("sip:" + wifiManager.getAddress());

        account.create(accountConfig);
    }

    public CallWrapper callAddress(NewCall newCall){
        return callAddress(newCall.getAddress());
    }

    public CallWrapper callAddress(String address){
        try {
            registerThread();
            if(calls.stream().anyMatch(call -> call.getRemoteAddress().equals(address)))
                return null;

            MyCall call = new MyCall(account);
            CallWrapper wrapper = new CallWrapper(call);
            CallOpParam param = new CallOpParam();
            call.makeCall(address, param);
            calls.add(wrapper);
            return wrapper;
        }catch (Exception e){
            if(e.getMessage().contains("Invalid Request URI"))
                return null;

            throw new RuntimeException(e);
        }
    }

    public void addCall(MyCall call){
        calls.add(new CallWrapper(call));
    }

    public void addCall(CallWrapper call){
        calls.add(call);
    }

    public void removeCall(int id){
        registerThread();
        CallWrapper call = getCallOrNull(id);
        if(call == null)
            return;

        call.getCall().delete();
        calls.remove(call);
    }

    public void holdCall(int id){
        registerThread();
        CallWrapper call = getCallOrNull(id);
        if(call == null
            || !call.getCall().isActive()
            || call.getStatusCode() != pjsip_inv_state.PJSIP_INV_STATE_CONFIRMED)
            return;

        call.getCall().setMute(!call.getCall().isMute());
    }

    @Scheduled(cron = "*/5 * * * * *")
    public void updateCallList(){
        registerThread();
        try {
            calls.removeIf(call -> !call.getCall().isActive());
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
