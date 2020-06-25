package com.test.firstapp.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * 继承系统广播BroadcastReceiver
 */
public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //接收
        //广播的key --action
        String action = intent.getAction();
        //一个参数
        String msg = intent.getStringExtra("msg");//null msg为空
        //获取广播接收的结果
        Log.d("MyReceiver", action + "," + msg);
    }
}
