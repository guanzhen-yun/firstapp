package com.test.firstapp.timer;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.test.firstapp.R;

import java.lang.ref.WeakReference;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Author:关震
 * Date:2020/6/25 17:30
 * Description:HandlerActivity
 **/
public class HandlerActivity extends Activity {
    @BindView(R.id.tv_second)
    TextView mTvSecond;

    private MyHandler handler = new MyHandler(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_handler)
    public void onViewClicked() {
        Message message = new Message();
        message.arg1 = 10;
        handler.sendMessageDelayed(message, 1000);
    }

    static class MyHandler extends Handler {
        WeakReference<HandlerActivity> weakReference;

        public MyHandler(HandlerActivity handlerActivity) {
            weakReference = new WeakReference<>(handlerActivity);
        }
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            HandlerActivity handlerActivity = weakReference.get();
            handlerActivity.mTvSecond.setText(msg.arg1 + "s");
            if(msg.arg1 != 0) {
                Message message = new Message();
                message.arg1 = --msg.arg1;
                sendMessageDelayed(message, 1000);
            }
        }
    }
}
