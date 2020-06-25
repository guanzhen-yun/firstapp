package com.test.firstapp.dialogpop;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.test.firstapp.R;

/**
 * Author:关震
 * Date:2020/6/25 10:09
 * Description:DialogActivity
 **/
public class DialogActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        Button btnShowdialog = findViewById(R.id.btn_showdialog);
        btnShowdialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Dialog dialog = new Dialog(DialogActivity.this, R.style.Dialog_Fullscreen);
//                View dialogView = View.inflate(DialogActivity.this, R.layout.dialog_layout, null);
//                dialog.setContentView(dialogView);
//                //设置动画 从底部弹出
////                Window window = dialog.getWindow();
////                window.setWindowAnimations(R.style.DialogAnimations);
//                dialog.show();

                //内部支持多种android自带的样式效果
                AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this);
                builder.setTitle("删除用户").setMessage("确定删除这个用户吗?").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(DialogActivity.this, "确定删除", Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(DialogActivity.this, "取消", Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });
    }
}
