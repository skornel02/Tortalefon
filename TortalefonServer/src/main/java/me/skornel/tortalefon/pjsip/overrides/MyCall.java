package me.skornel.tortalefon.pjsip.overrides;

import lombok.Getter;
import org.pjsip.pjsua2.*;

public class MyCall extends Call {

    @Getter
    private boolean mute = true;

    public MyCall(Account acc) {
        super(acc);
    }

    public MyCall(Account acc, int call_id) {
        super(acc, call_id);
    }

    @Override
    public void onCallMediaState(OnCallMediaStateParam prm) {
        setMute(false);
    }

    public void setMute(boolean muted){
        mute = muted;
        try {
            CallInfo ci = this.getInfo();

            for(int i = 0; i < ci.getMedia().size(); i++) {
                if(ci.getMedia().get(i).getType() == pjmedia_type.PJMEDIA_TYPE_AUDIO) {

                    AudioMedia aum = AudioMedia.typecastFromMedia(this.getMedia(i));

                    AudDevManager manager = Endpoint.instance().audDevManager();

                    if(muted){
                        manager.getCaptureDevMedia().stopTransmit(aum);
                        aum.stopTransmit(manager.getPlaybackDevMedia());
                    }else{
                        manager.getCaptureDevMedia().startTransmit(aum);
                        aum.startTransmit(manager.getPlaybackDevMedia());
                    }
                    return;
                }
            }

            delete();
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

}
