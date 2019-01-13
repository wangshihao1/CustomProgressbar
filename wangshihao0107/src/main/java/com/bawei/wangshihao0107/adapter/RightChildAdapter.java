package com.bawei.wangshihao0107.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.wangshihao0107.R;
import com.bawei.wangshihao0107.bean.RightBean;
import com.bumptech.glide.Glide;

import java.util.List;

public class RightChildAdapter extends RecyclerView.Adapter<RightChildAdapter.ViewHolderChild> {
    private Context context;
    private List<RightBean.DataBean.ChildData> mdatas;

    public RightChildAdapter(Context context, List<RightBean.DataBean.ChildData> mdatas) {
        this.context = context;
        this.mdatas = mdatas;
    }

    @NonNull
    @Override
    public ViewHolderChild onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.right_item_child,viewGroup,false);
        ViewHolderChild holderChild = new ViewHolderChild(view);
        return holderChild;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderChild viewHolderChild, int i) {
        RightBean.DataBean.ChildData data = mdatas.get(i);
        String icon = data.icon;
        String name = data.name;
        Glide.with(context).load(icon).into(viewHolderChild.imageView);
        viewHolderChild.textView.setText(name);
    }

    @Override
    public int getItemCount() {
        return mdatas==null ? 0 :mdatas.size();
    }

    public class ViewHolderChild extends RecyclerView.ViewHolder {

        private TextView textView;
        private ImageView imageView;

        public ViewHolderChild(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_id);
            itemView = itemView.findViewById(R.id.iv_icon);
        }
    }
}
