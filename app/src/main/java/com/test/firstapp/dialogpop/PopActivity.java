package com.test.firstapp.dialogpop;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.test.firstapp.R;

/**
 * Author:关震
 * Date:2020/6/25 11:15
 * Description:PopActivity
 **/
public class PopActivity extends Activity {
    private TextView tvShowpop;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);
        Button btnPop = findViewById(R.id.btn_pop);
        tvShowpop  = findViewById(R.id.tv_showpop);
        btnPop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPop();
            }
        });
    }

    private void showPop() {
        LayoutInflater mLayoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        ViewGroup menuView = (ViewGroup) mLayoutInflater.inflate(
                R.layout.pop_layout, null, true);
        PopupWindow popupWindow = new PopupWindow(menuView, ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        popupWindow.setOutsideTouchable(false);
        popupWindow.showAsDropDown(tvShowpop, 20, 0);
        popupWindow.update();
    }
}
