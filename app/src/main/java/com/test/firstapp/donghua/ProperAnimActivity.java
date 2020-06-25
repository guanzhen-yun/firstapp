package com.test.firstapp.donghua;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.test.firstapp.R;

/**
 * Author:关震
 * Date:2020/6/25 15:16
 * Description:ProperAnimActivity 属性动画
 **/
public class ProperAnimActivity extends Activity {
    private TextView tvNum;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_properanim);
        tvNum = findViewById(R.id.tv_num);
        Button btnCount = findViewById(R.id.btn_count);
        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playAnim();
            }
        });

        Button btnObj = findViewById(R.id.btn_obj);
        btnObj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                objAnim();
            }
        });
    }

    private void objAnim() {
        ObjectAnimator animator0 = ObjectAnimator.ofFloat(
                tvNum,//这里传入的是一个任意对象，此处是imageview对象
                "alpha",
                1F,
                0.0f, 1F);

        ObjectAnimator animator1 = ObjectAnimator.ofFloat(
                tvNum,//这里传入的是一个任意对象，此处是imageview对象
                "translationX",
                0F, 200F, 0F);

        AnimatorSet set = new AnimatorSet();
        set.setDuration(3000);
        set.setInterpolator(new BounceInterpolator());
        set.playTogether(
                animator0,
                animator1);
        set.start();
//        animator1.setDuration(3000);
//        animator1.start();
    }

    private void playAnim() {
        ValueAnimator animator = ValueAnimator.ofInt(0,100);
        animator.setDuration(10000);
        animator.start();
//        animator.setInterpolator(new LinearInterpolator());//BounceInterpolator   CycleInterpolator 插值方式
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int value = (int) valueAnimator.getAnimatedValue();
                tvNum.setText(String.valueOf(value));
            }
        });
    }
}
