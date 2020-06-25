package com.test.firstapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.test.firstapp.R;

//碎片  生命周期一个View： TextView  EditText Button  ScrollView   RecyclerView

//View 树形结构

//                                 ViewGroup(四大布局) 根
//                        ViewGroup     ViewGroup
//                View(TextView)           View(TextView)

//创建时顺序:
//Activity_onCreate   Fragment_onAttach  Fragment_onCreate  Fragment_onCreateView
//Fragment_onActivityCreated  Fragment_onStart Activity_onStart  Activity_onResume   Fragment_onResume


//销毁时顺序
//Fragment_onPause  Activity_onPause  Fragment_onStop  Activity_onStop
//Fragment_onDestroyView  Fragment_onDestroy Fragment_onDetach  Activity_onDestroy
public class Fragment1 extends Fragment {
    private TextView tvName;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d("Fragment1", "Fragment_onAttach");
    }

    //onCreateView 设置布局文件
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);
        tvName = view.findViewById(R.id.tv_name);
        Log.d("Fragment1", "Fragment_onCreateView");
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Fragment1", "Fragment_onCreate");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("Fragment1", "Fragment_onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        //可见
        Log.d("Fragment1", "Fragment_onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        //可交互
        Log.d("Fragment1", "Fragment_onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("Fragment1", "Fragment_onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("Fragment1", "Fragment_onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Fragment1", "Fragment_onDestroy");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("Fragment1", "Fragment_onDestroyView");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //取消关联
        Log.d("Fragment1", "Fragment_onDetach");
    }

    public void setName(String name) {
        if(tvName != null) {
            tvName.setText("你好" + name);
        }
    }
}
