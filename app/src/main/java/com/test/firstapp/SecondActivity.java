package com.test.firstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

/**
 * 相对布局
 * layout_toLeftOf 相对位置 上下左右
 * layout_marginRight  距离 上下左右
 *Log.d  日志查看
 * Log.e() 错误
 * Log.i() 信息
 * Logcat 查看Log的
 */


/**
 * A    B
 * A onPause  B onCreate  onStart  onResume(交互) A onStop  B完全遮盖住了A
 *
 * B属性是透明的 A onPause  B onCreate  onStart  onResume(交互)  不会执行A的onStop
 *
 * android:theme="@style/Theme.AppCompat.Light.Dialog"  让B Dialog(对话框)样式
 */
public class SecondActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Log.d("Activity_", "SecondActivity_" + "onCreate");
        //key --- value    key "name" 代表键(标记)    value name(值--张三)
        String name = getIntent().getStringExtra("name");
        TextView tvNameValue = findViewById(R.id.tv_name_value);
        tvNameValue.setText(name);//把name 赋值给TextView

        Button btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("name", "李四");
                setResult(RESULT_OK, intent);//参数回传
                finish();//关掉当前页面
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Activity_", "SecondActivity_" + "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Activity_", "SecondActivity_" + "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Activity_", "SecondActivity_" + "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Activity_", "SecondActivity_" + "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Activity_", "SecondActivity_" + "onDestroy");
    }
}
