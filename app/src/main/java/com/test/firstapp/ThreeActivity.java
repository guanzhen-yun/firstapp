package com.test.firstapp;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

//FrameLayout 帧布局  所有控件默认堆积在左上角
//layout_gravity 在布局中的对齐方式
public class ThreeActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
    }
}
