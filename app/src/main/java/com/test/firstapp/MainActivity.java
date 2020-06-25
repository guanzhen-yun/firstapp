package com.test.firstapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * MainActivity  Activity 管理布局文件以及逻辑代码
 * activity_main  设计ui交互  页面
 * AndroidManifest.xml 配置清单
 * mipmap 存储图片 适配手机  美工图片--蓝湖开发 xh xxh xxxh
 *
 * 运行代码
 */

/**
 * LinearLayout  线性布局  orientation: vertical 竖直排列    horizontal 水平排列
 * TextView 文本控件  layout_width  layout_height  宽高 必须有的
 * text 添加文本  textColor  文本颜色  红绿蓝 3对十六进制(0~F) RGB颜色 前两位可以附加透明度(00 -- FF)
 * textSize 文本尺寸  18sp 18像素
 * paddingTop 布局的位置 Top上  Bottom下  Left左  Right右
 * textStyle 文本风格 bold加粗 默认就是normal
 * wrap_content 自适应宽高   match_parent 填充屏幕
 * gravity 对齐方式
 */

//Ctrl + Z 撤销
//git 版本管理 代码上传到git服务器上  gitLab  gitHub开源代码

/**
 * EditText 输入框
 *textColorHint 提示语颜色
 * hint 提示语
 * inputType  输入类型  numberPassword  数字密码
 * maxLength 最多输入6个字
 */

/**
 * Button 按钮
 * layout_marginLeft 左边距
 * layout_marginRight 右边距
 */

//id 为了得到控件的内容  定义规范  tv_   et_   btn_

    //findViewById 根据id获取到控件

    //Toast 吐司提示

    //startActivity  页面跳转
public class MainActivity extends AppCompatActivity {
    //全局变量 别的地方可以使用
    private EditText etPassword;
    private EditText etName;
    private TextView tvShow;

    private boolean isShow;//是否显示密码

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Activity_", "MainActivity" + "onCreate");
        //驼峰式

        //局部变量
        Button btnLogin = findViewById(R.id.btn_login);//登录
        etName = findViewById(R.id.et_name);//用户名
        etPassword = findViewById(R.id.et_password);//密码

        tvShow = findViewById(R.id.tv_show);//显示密码
        //点击监听事件
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Alt + Enter
                String name = etName.getText().toString();
                String password = etPassword.getText().toString();
                //Toast.LENGTH_SHORT  短时间提醒   LENGTH_LONG 长时间提醒
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("name", name);
                startActivityForResult(intent, 100);
//                Toast.makeText(MainActivity.this, name + "," + password, Toast.LENGTH_LONG).show();
            }
        });

        tvShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //&&  ||  !非  ! 修饰boolean
                isShow = !isShow;

                if(isShow) {
                    //显示数字密码
                    tvShow.setText("隐藏密码");
                    etPassword.setTransformationMethod(HideReturnsTransformationMethod
                            .getInstance());
                } else {
                    tvShow.setText("显示密码");
                    etPassword.setTransformationMethod(PasswordTransformationMethod
                            .getInstance());
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data == null) return;
        //接收回调
        String name = data.getStringExtra("name");
        etName.setText(name);
//        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Activity_", "MainActivity" + "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Activity_", "MainActivity" + "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Activity_", "MainActivity" + "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Activity_", "MainActivity" + "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Activity_", "MainActivity" + "onDestroy");
    }

}
