package com.test.firstapp.donghua;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.test.firstapp.R;

/**
 * Author:关震
 * Date:2020/6/25 11:36
 * Description:FrameAnimActivity 帧动画
 **/
public class FrameAnimActivity extends Activity {
    private ImageView ivPic;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frameanim);
        ivPic = findViewById(R.id.iv_pic);
        Button btnPlayanim = findViewById(R.id.btn_playanim);
        btnPlayanim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivPic.setBackgroundResource(R.drawable.bg_frameanim);
                AnimationDrawable animationDrawable = (AnimationDrawable) ivPic.getBackground();
                animationDrawable.start();//开启动画
            }
        });

        Button btnStopanim = findViewById(R.id.btn_stopanim);
        btnStopanim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivPic.clearAnimation();
                ivPic.setBackgroundResource(R.drawable.img1);
            }
        });
    }
}
