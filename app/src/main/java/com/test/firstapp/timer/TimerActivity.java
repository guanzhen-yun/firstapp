package com.test.firstapp.timer;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.test.firstapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Author:关震
 * Date:2020/6/25 17:47
 * Description:TimerActivity
 **/
public class TimerActivity extends Activity {
    @BindView(R.id.tv_second)
    TextView mTvSecond;

    private CountDownTimer mCountDownTimer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_timer)
    public void onViewClicked() {
        openTimer(10 * 1000);//毫秒为单位
    }

    private void openTimer(long timeCount) {
        mCountDownTimer = new CountDownTimer(timeCount, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                    mTvSecond.setText(millisUntilFinished / 1000 + "s");
            }

            /**
             *倒计时结束后调用的
             */
            @Override
            public void onFinish() {
                mTvSecond.setText(0 + "s");
            }
        };
        mCountDownTimer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
            mCountDownTimer = null;
        }
    }
}
