package com.test.firstapp.net;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.test.firstapp.R;
import com.test.net.ApiUtil;
import com.test.net.OnResponseListener;
import com.test.net.exception.ApiException;

import io.reactivex.disposables.Disposable;

/**
 * Author:关震
 * Date:2020/6/25 16:28
 * Description:NetActivity
 **/
public class NetActivity extends Activity {
    private EditText etName;
    private EditText etPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net);
        etName = findViewById(R.id.et_name);
        etPassword  = findViewById(R.id.et_password);
        Button btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    private void login() {
        LoginModel loginModel = new LoginModel();
        loginModel.username = etName.getText().toString();//cuichen
        loginModel.password = etPassword.getText().toString();//123456a
        ApiUtil.getResponse(ApiUtil.getService(AppService.class).login(loginModel), new OnResponseListener<LoginSuccess>() {
            @Override
            public void onSubscribe(Disposable d) {
                //TODO 增加网络请求处理
            }

            @Override
            public void onNext(LoginSuccess entity) {
                loginResult(entity);
            }

            @Override
            public void onError(ApiException e) {
                Toast.makeText(NetActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loginResult(LoginSuccess entity) {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
    }
}
