package com.test.firstapp.event;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.test.firstapp.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author:关震
 * Date:2020/6/25 17:18
 * Description:EventActivity
 **/
public class EventActivity extends Activity {
    @BindView(R.id.tv_name)
    TextView mTvName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void refreshUser(UserEvent event) {
        if (event != null && !TextUtils.isEmpty(event.name)) {
            mTvName.setText(event.name);
        }
    }

    public void changename(View view) {
        startActivity(new Intent(EventActivity.this, EventBus2Activity.class));
    }
}
