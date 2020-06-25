package com.test.firstapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.test.firstapp.R;
import com.test.firstapp.entity.RecyclerDao;

import java.util.List;

/**
 * 适配器
 *
 * extends RecyclerView.Adapter 继承RecyclerView 的适配器
 *
 * <> 泛型 RecyclerAdapter.MyHolder  要处理的类型
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyHolder> {
    private Context mContext;
    private List<RecyclerDao> mList;//列表

    public RecyclerAdapter(Context context, List<RecyclerDao> list) {
        this.mContext = context;
        this.mList = list;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //将子元素填充到RecycleView
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_recycler, parent, false);
        return new MyHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, final int position) {
        //赋值setText position取值 0~6
        RecyclerDao dao = mList.get(position);//获取到第position项的值
        holder.tvTitle.setText(dao.name);
        holder.tvDesc.setText(dao.desc);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onItemClickListener != null) {
                    onItemClickListener.onItemClick(position);
                }
            }
        });
    }

    //列表的大小
    @Override
    public int getItemCount() {
        //7
        return mList.size();
    }

    /**
     * extends RecyclerView.ViewHolder 继承RecyclerView 的填充器
     */
    class MyHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle;
        private TextView tvDesc;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDesc = itemView.findViewById(R.id.tv_desc);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    private OnItemClickListener onItemClickListener;//Alt + Enter

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
