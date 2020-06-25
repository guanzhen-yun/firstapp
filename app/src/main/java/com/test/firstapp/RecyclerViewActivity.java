package com.test.firstapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.test.firstapp.adapter.RecyclerAdapter;
import com.test.firstapp.entity.RecyclerDao;

import java.util.ArrayList;
import java.util.List;

/**
 * RecyclerView列表
 *
 * item_xxx.xml   子元素
 *
 * RecyclerAdapter 适配器
 *
 * 下拉刷新 + 分页加载 + 网络请求
 */
public class RecyclerViewActivity extends Activity {
    private RecyclerAdapter recyclerAdapter;
    private RecyclerView rv;
    private Button btnDelete;
    private List<RecyclerDao> list;//Ctrl + Alt + F 变成全局的变量

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        rv = findViewById(R.id.rv);
        btnDelete = findViewById(R.id.btn_delete);
        setAdapter();//填充数据并且设置适配器
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                java.lang.IndexOutOfBoundsException: Index: 0, Size: 0 //数组越界异常
                if(list.size() > 0) {//list.size() 列表的长度大于0
                    list.remove(0);
                    recyclerAdapter.notifyDataSetChanged();//适配器刷新
                }
            }
        });
    }

    private void setAdapter() {
        list = new ArrayList<>();
        //add 列表添加元素
        for (int i=0;i<30;i++) {
            list.add(new RecyclerDao("图片标题" + i, "图片描述"+ i));
        }
//        list.clear();//清空 初始化数据
//        list.remove(0);//删除第0个
        //生成适配器
        recyclerAdapter = new RecyclerAdapter(this, list);
        //给RecyclerView设置适配器
        rv.setAdapter(recyclerAdapter);

        recyclerAdapter.setOnItemClickListener(new RecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //点击RecyclerView的某一项
                list.remove(position);
                recyclerAdapter.notifyDataSetChanged();//适配器刷新
                //点击某一项删除 不友好  dialog对话框 确认是否删除
//                Toast.makeText(RecyclerViewActivity.this, list.get(position).name, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
