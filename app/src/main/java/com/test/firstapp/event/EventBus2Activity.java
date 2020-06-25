package com.test.firstapp.event;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.test.firstapp.R;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Author:关震
 * Date:2020/6/25 17:20
 * Description:EventBus2Activity
 **/
public class EventBus2Activity extends Activity {
    @BindView(R.id.et_name)
    EditText mEtName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event2);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_change)
    public void onViewClicked() {
        if (!TextUtils.isEmpty(mEtName.getText().toString())) {
            EventBus.getDefault().post(new UserEvent(mEtName.getText().toString()));
            Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
