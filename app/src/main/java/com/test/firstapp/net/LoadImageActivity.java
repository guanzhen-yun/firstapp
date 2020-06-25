package com.test.firstapp.net;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.test.firstapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Author:关震
 * Date:2020/6/25 17:10
 * Description:LoadImageActivity
 **/
public class LoadImageActivity extends Activity {
    @BindView(R.id.iv_pic)
    ImageView mIvPic;

    private String imageUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1593086530883&di=69a5584a0d066594eb597b0941d3f47a&imgtype=0&src=http%3A%2F%2Fa0.att.hudong.com%2F64%2F76%2F20300001349415131407760417677.jpg";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadimage);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_load)
    public void onViewClicked() {
        Glide.with(this).load(imageUrl).into(mIvPic);
    }
}
