package com.test.firstapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.test.firstapp.R;
import com.test.firstapp.entity.ProviderUserDao;

import java.util.List;

public class ProviderAdapter extends RecyclerView.Adapter<ProviderAdapter.MyHolder> {
    private Context mContext;
    private List<ProviderUserDao> mList;//列表

    public ProviderAdapter(Context context, List<ProviderUserDao> list) {
        this.mContext = context;
        this.mList = list;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //将子元素填充到RecycleView
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_provider, parent, false);
        return new MyHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder holder, final int position) {
        //赋值setText position取值 0~6
        final ProviderUserDao user = mList.get(position);//获取到第position项的值
        holder.etName.setText(user.name);
        holder.etName.setEnabled(false);
        holder.btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.btnChange.getText().equals("确定修改")) {
                    if (onHandleClickListener != null) {
                        onHandleClickListener.changeName(user.id, holder.etName.getText().toString());
                    }
                    holder.btnChange.setText("修改");
                    holder.etName.setEnabled(false);
                } else {
                    holder.etName.setEnabled(true);
                    holder.btnChange.setText("确定修改");
                }
            }
        });

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onHandleClickListener != null) {
                    onHandleClickListener.deleteName(user.id);
                }
            }
        });
    }

    //列表的大小
    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setOnHandleClickListener(OnHandleClickListener onHandleClickListener) {
        this.onHandleClickListener = onHandleClickListener;
    }

    /**
     * extends RecyclerView.ViewHolder 继承RecyclerView 的填充器
     */
    class MyHolder extends RecyclerView.ViewHolder {
        private TextView etName;
        private Button btnChange;
        private Button btnDelete;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            etName = itemView.findViewById(R.id.et_name);
            btnChange = itemView.findViewById(R.id.btn_change);
            btnDelete = itemView.findViewById(R.id.btn_delete);
        }
    }

    public interface OnHandleClickListener {
        void changeName(int id, String name);

        void deleteName(int id);
    }

    private OnHandleClickListener onHandleClickListener;
}
