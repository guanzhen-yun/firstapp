package com.test.firstapp.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver2 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        String msg = intent.getStringExtra("msg");
        Log.d("MyReceiver", action + "," + msg);
    }
}
