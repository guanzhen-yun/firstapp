package com.test.firstapp;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

//ConstraintLayout 约束布局  相当于用看不见的线来约束位置
//app:layout_constraintTop_toTopOf="parent"  位于屏幕的顶部
// app:layout_constraintLeft_toLeftOf="parent"  位于屏幕的左侧
public class FourActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
    }
}
