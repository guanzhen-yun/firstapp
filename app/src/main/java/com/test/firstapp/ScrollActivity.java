package com.test.firstapp;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

/**
 * 滑动布局
 */
public class ScrollActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);
    }
}
