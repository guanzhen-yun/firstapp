package com.test.firstapp.contentprovider;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.test.firstapp.R;
import com.test.firstapp.adapter.ProviderAdapter;
import com.test.firstapp.entity.ProviderUserDao;

import java.util.ArrayList;
import java.util.List;

public class ProviderActivity extends Activity {
    private EditText etName;
    private Button btnAdd;
    private RecyclerView rvList;

    private List<ProviderUserDao> listName = new ArrayList<>();
    private ProviderAdapter providerAdapter;
    private Uri uri_user = Uri.parse("content://com.test.firstapp/user");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider);
        etName = findViewById(R.id.et_name);
        btnAdd = findViewById(R.id.btn_add);
        rvList = findViewById(R.id.rv_list);
        providerAdapter = new ProviderAdapter(this, listName);
        rvList.setLayoutManager(new LinearLayoutManager(this));
        rvList.setAdapter(providerAdapter);
        providerAdapter.setOnHandleClickListener(new ProviderAdapter.OnHandleClickListener() {
            @Override
            public void changeName(int id, String name) {
                updateName(id, name);
            }

            @Override
            public void deleteName(int id) {
delete(id);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertUser();
            }
        });
        getUsers();
    }

    private void delete(int id) {
        ContentResolver resolver = getContentResolver();
        resolver.delete(uri_user, "_id=?", new String[]{id + ""});
        getUsers();
    }

    private void updateName(int id, String name) {
        ContentResolver resolver = getContentResolver();
        ContentValues values = new ContentValues();
        values.put("name", name);
        resolver.update(uri_user, values, "_id=?", new String[]{id + ""});
        getUsers();
    }

    private void getUsers() {
        listName.clear();
        ContentResolver resolver = getContentResolver();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            Cursor query = resolver.query(uri_user, new String[]{"_id","name"}, null, null, null, null);
            if (query != null) {
                if(query.getCount() == 0) {
                    providerAdapter.notifyDataSetChanged();
                    return;
                }
                while (query.moveToNext()) {
                    String name = query.getString(1);
                    int id = query.getInt(0);
                    ProviderUserDao providerUserDao = new ProviderUserDao();
                    providerUserDao.id = id;
                    providerUserDao.name = name;
                    listName.add(providerUserDao);
                    providerAdapter.notifyDataSetChanged();
                }
                query.close();
            }
        }
    }

    private void insertUser() {
        // 插入表中数据
        ContentValues values = new ContentValues();
        values.put("name", etName.getText().toString());
        // 获取ContentResolver
        ContentResolver resolver = getContentResolver();
        // 通过ContentResolver 根据URI 向ContentProvider中插入数据
        resolver.insert(uri_user, values);
        getUsers();
        etName.setText("");
    }
}
