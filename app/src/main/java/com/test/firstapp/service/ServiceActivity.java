package com.test.firstapp.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.test.firstapp.R;

/**
 * 播放音乐
 * implements View.OnClickListener  实现接口OnClickListener
 */
public class ServiceActivity extends Activity implements View.OnClickListener {
    private Button btnStart;
    private Button btnStop;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        btnStart = findViewById(R.id.btn_start);
        btnStop = findViewById(R.id.btn_stop);
        btnStart.setOnClickListener(this);//this  --- View.OnClickListener
        btnStop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {//重写方法
        Intent intent = new Intent();
        intent.setClass(this, MusicService.class);//设置起始上下文
        switch (view.getId()) {
            case R.id.btn_start://开始播放
                startService(intent);
                break;
            case R.id.btn_stop://暂停播放
                stopService(intent);
                break;
        }
    }
}
