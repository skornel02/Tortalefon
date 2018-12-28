package me.skornel.tortalefon.pjsip;

import lombok.Data;
import me.skornel.tortalefon.pjsip.overrides.MyCall;
import org.pjsip.pjsua2.pjsip_inv_state;

import java.time.LocalDateTime;

@Data
public class CallWrapper {

    private LocalDateTime creation;
    private MyCall call;

    public CallWrapper(MyCall call) {
        this.call = call;
        creation = LocalDateTime.now();
    }

    public String getRemoteAddress(){
        try {
            if(!call.isActive())
                return "";

            return call.getInfo().getRemoteUri();
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public String getTimeInCall(){
        try {
            if(!call.isActive())
                return ";";

            int SecondsCounter = getCall().getInfo().getConnectDuration().getSec();
            return String.format("%02d:%02d:%02d",(SecondsCounter/3600), ((SecondsCounter % 3600)/60), (SecondsCounter % 60));
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public String getMutedStatus(){
        return call.isMute() && getStatusCode() == pjsip_inv_state.PJSIP_INV_STATE_CONFIRMED ?
                "Unmute" : "Mute";
    }

    public pjsip_inv_state getStatusCode(){
        try {
            if(!call.isActive())
                return pjsip_inv_state.PJSIP_INV_STATE_DISCONNECTED;

            return call.getInfo().getState();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public String getStatus(){
        try {
            if(!call.isActive())
                return "Terminating...";

            pjsip_inv_state state = getStatusCode();
            if(state == pjsip_inv_state.PJSIP_INV_STATE_CALLING){
                return "Calling...";
            }
            if (state == pjsip_inv_state.PJSIP_INV_STATE_CONNECTING){
                return "Connecting";
            }
            if(state == pjsip_inv_state.PJSIP_INV_STATE_EARLY){
                return "Ringing";
            }
            if(state == pjsip_inv_state.PJSIP_INV_STATE_DISCONNECTED){
                return "Disconnected";
            }
            if(call.isMute()){
                return "In hold";
            }
            if(state == pjsip_inv_state.PJSIP_INV_STATE_CONFIRMED){
                return "In call";
            }
            return "Unknown";
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
