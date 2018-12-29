package com.indeed.tortalefon;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.sip.SipAudioCall;
import android.net.sip.SipException;
import android.net.sip.SipManager;
import android.net.sip.SipProfile;
import android.net.sip.SipRegistrationListener;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.text.ParseException;

public class Attempt2Activity extends AppCompatActivity {

    public SipManager mSipManager = null;
    public SipProfile mSipProfile = null;
    public SipAudioCall call;
    private String domain = "192.168.1.101";
    private String  sipAddress = "192.168.1.120";


    SipAudioCall.Listener listener = new SipAudioCall.Listener() {
        @Override
        public void onCallEstablished(SipAudioCall call){
            call.startAudio();
            call.setSpeakerMode(true);
            call.toggleMute();

        }

        @Override
        public void onCallEnded(SipAudioCall call){
            // Call Ended
        }


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attempt2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);





        if (mSipManager == null){
            mSipManager = SipManager.newInstance(this);
        }

        // Create a SipProfile Object
        SipProfile.Builder builder = null;
        try {
            builder = new SipProfile.Builder("jani", domain); // "192.168.1.101"
        } catch (ParseException e) {
            e.printStackTrace();
            Log.e("hey", "parse exception");
        }
        builder.setPassword("12345678");
        mSipProfile = builder.build();

        // Open local profile for making call and receive generic SIP call
        Intent intent = new Intent();
        intent.setAction("android.SipDemo.INCOMING_CALL");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, Intent.FILL_IN_DATA);
        try {
            mSipManager.open(mSipProfile, pendingIntent, null);
        } catch (SipException e) {
            e.printStackTrace();
        }


        // nKeep track whether the SipProfile was successfully registered
        try {
            mSipManager.setRegistrationListener(mSipProfile.getUriString(), new SipRegistrationListener() {
                public void onRegistering(String localProfileUri){
                    //updateStatus("Registering with SIP server.");
                    Log.e("hey", "Registering with SIP server.");

                }
                public void onRegistrationDone(String localProfileUri, long expiryTime){
                  //  updateStatus("Ready.");
                    Log.e("hey", "Ready");

                }

                @Override
                public void onRegistrationFailed(String localProfileUri, int errorCode, String errorMessage) {
                    Log.e("hey", "Registration failed");
                    Log.e("hey", "error Code: " + errorCode );
                    Log.e("hey", "error mesage: " + errorMessage );
                }
            });
        } catch (SipException e) {
            e.printStackTrace();
        }


        // make the call
        try {
            call = mSipManager.makeAudioCall(mSipProfile.getUriString(), sipAddress, listener, 30);
        } catch (SipException e) {
            e.printStackTrace();
        }






      /*  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        }); */
    }

    public void closeLocalProfile(){
        if (mSipManager == null){
            return;
        }
        try{
            if (mSipProfile != null){
                mSipManager.close(mSipProfile.getUriString());
            }
        }catch(Exception ee){
            Log.d("TAG", "Failed to close local profile.");
        }
    }

}
