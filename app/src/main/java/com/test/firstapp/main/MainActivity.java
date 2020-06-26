package com.test.firstapp.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.test.firstapp.R;
import com.test.firstapp.viewpager.ViewPagerActivity;

/**
 * Author:关震
 * Date:2020/6/26 10:26
 * Description:MainActivity 主页
 **/
public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newmain);
    }

    public void jumpNextPage(View view) {
        startActivity(new Intent(MainActivity.this, ViewPagerActivity.class));
    }
}
