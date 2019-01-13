package com.bawei.wangshihao0107.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.wangshihao0107.R;
import com.bawei.wangshihao0107.bean.LeftBean;

import java.util.List;

public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.ViewHolderLeft> {

    private Context context;
    private List<LeftBean.DataBean> mdatas;

    public LeftAdapter(Context context, List<LeftBean.DataBean> mdatas) {
        this.context = context;
        this.mdatas = mdatas;
    }

    @NonNull
    @Override
    public ViewHolderLeft onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.left_item,viewGroup,false);
        ViewHolderLeft holderLeft = new ViewHolderLeft(view);
        return holderLeft;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderLeft viewHolderLeft, int i) {
            LeftBean.DataBean bean = mdatas.get(i);
            String name = bean.name.toString();
            viewHolderLeft.textView.setText(name);

    }

    @Override
    public int getItemCount() {
        return mdatas==null ? 0 :mdatas.size();
    }

    public class ViewHolderLeft extends RecyclerView.ViewHolder {

        private TextView textView;

        public ViewHolderLeft(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_item);
        }
    }

    public interface onItemClick{
        void onClick(String cid);
    }

    private onItemClick itemClick;

    public void setItemClick(onItemClick itemClick) {
        this.itemClick = itemClick;
    }
}
