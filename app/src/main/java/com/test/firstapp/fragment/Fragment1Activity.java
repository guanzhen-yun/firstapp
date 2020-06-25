package com.test.firstapp.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.test.firstapp.R;

/**
 * FragmentActivity 父类必须是这个  否则无法引入Fragment
 */
public class Fragment1Activity extends FragmentActivity {
    private FragmentManager fragmentManager;//管理Fragment的
    private Fragment1 fragment1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment1);
        Log.d("Fragment1", "Activity_onCreate");
        fragmentManager = getSupportFragmentManager();
        fragment1 = new Fragment1();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();//开启事务
        fragmentTransaction.replace(R.id.fl, fragment1);//replace替换id所对应的View  add 添加
//        fragment1 = new Fragment1();
//        fragmentTransaction.add(R.id.fl, fragment1);
//        fragment1 = new Fragment1();
//        fragmentTransaction.add(R.id.fl, fragment1);
//        fragment1 = new Fragment1();
//        fragmentTransaction.add(R.id.fl, fragment1);
        fragmentTransaction.commitAllowingStateLoss();//提交事务

    }

    //不需要写setOnClickListener
    public void changeName(View view) {
        //Activity对Fragment的一个操作
        fragment1.setName("李四");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Fragment1", "Activity_onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Fragment1", "Activity_onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Fragment1", "Activity_onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Fragment1", "Activity_onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Fragment1", "Activity_onDestroy");
    }
}
