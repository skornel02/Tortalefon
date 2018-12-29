package com.indeed.tortalefon;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class WalkieTalkieActivity extends Activity implements View.OnTouchListener {

    public IncomingCallReceiver callReceiver;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.SipDemo.INCOMING_CALL");
        callReceiver = new IncomingCallReceiver();
        this.registerReceiver(callReceiver, filter);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}