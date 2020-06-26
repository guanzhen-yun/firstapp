package com.test.firstapp.sharedpreference;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.test.firstapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Author:关震
 * Date:2020/6/26 10:13
 * Description:SharedPreferenceActivity 文件保存
 **/
public class SharedPreferenceActivity extends Activity {
    @BindView(R.id.et_name)
    EditText mEtName;
    private SharedPreferences sp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp);
        ButterKnife.bind(this);
        getData();
    }

    //获取数据
    private void getData() {
        sp = getSharedPreferences("mysp", MODE_PRIVATE);
        String name = sp.getString("name", "");
        if(!TextUtils.isEmpty(name)) {
            mEtName.setText(name);
        }
    }

    @OnClick(R.id.btn_save)
    public void onViewClicked() {
        String name = mEtName.getText().toString();
        if(!TextUtils.isEmpty(name)) {
            sp.edit().putString("name", name).apply();
            Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
