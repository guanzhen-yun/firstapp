package com.test.firstapp.broadcast;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.test.firstapp.R;

/**
 * 广播
 * 实现两个Activity之间的通讯 ??
 * RecyclerView B收到 增加一条消息  A收到 增加一条消息 list.add()  刷新页面
 */
public class BroadcastActivity extends Activity {
    private MyReceiver myReceiver;
    private MyReceiver2 myReceiver2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);
        Button btnSendmsg = findViewById(R.id.btn_sendmsg);

        myReceiver = new MyReceiver();
        myReceiver2 = new MyReceiver2();

        IntentFilter intentFilter1 = new IntentFilter("sendMsg1");
        registerReceiver(myReceiver, intentFilter1);

        IntentFilter intentFilter2 = new IntentFilter("sendMsg2");
        registerReceiver(myReceiver2, intentFilter2);

        btnSendmsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("sendMsg1");
                intent.putExtra("msg", "你好");
                sendBroadcast(intent);

                Intent intent2 = new Intent("sendMsg2");
                intent2.putExtra("msg", "张三");
                sendBroadcast(intent2);
            }
        });
    }

    //Activity生命周期--销毁进行反注册(回收)
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myReceiver);
        unregisterReceiver(myReceiver2);
    }
}
