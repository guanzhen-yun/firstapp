package com.test.firstapp.donghua;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.test.firstapp.R;

/**
 * Author:关震
 * Date:2020/6/25 14:13
 * Description:ViewAnimActivity View动画 也叫补间动画
 **/
public class ViewAnimActivity extends Activity {
    private Button btnAnim;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewanim);
        btnAnim = findViewById(R.id.btn_anim);
        btnAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                translate();
//                scale();
//                rotate();
//                alpha();
                setAnim();
            }
        });
    }

    /**
     * 平移
     */
    private void translate() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.translate_animation);
        animation.setDuration(1000);
//        animation.setFillAfter(true);//播放完停留在最终位置
        btnAnim.startAnimation(animation);

        //代码动画
//        Animation translateAnimation = new TranslateAnimation(0,500,0,500);
//        translateAnimation.setDuration(3000);
//        btnAnim.startAnimation(translateAnimation);
    }

    /**
     * 缩放
     */
    private void scale() {
        //pivotX和pivotY表示以缩放中心的位置。
//        Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale_animation);
//        btnAnim.startAnimation(animation);

        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f);
        scaleAnimation.setDuration(1000);
        btnAnim.startAnimation(scaleAnimation);
    }

    /**
     * 旋转
     */

    private void rotate() {
//        Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate_animation);
//        btnAnim.startAnimation(animation);

        RotateAnimation rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, TranslateAnimation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setDuration(1000);
        btnAnim.startAnimation(rotateAnimation);
    }

    /**
     * 透明度
     */

    private void alpha() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha_animation);
        btnAnim.startAnimation(animation);

//        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
//        alphaAnimation.setDuration(2000);
//        btnAnim.startAnimation(alphaAnimation);
    }

    /**
     * 动画组合
     */

    private void setAnim() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.set_anim);
        btnAnim.startAnimation(animation);
    }

}
