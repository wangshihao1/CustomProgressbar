package com.bawei.wangshihao0107.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.wangshihao0107.R;
import com.bawei.wangshihao0107.bean.RightBean;

import java.util.List;

public class RigthAdapter extends RecyclerView.Adapter<RigthAdapter.ViewHolderRight> {

    private Context context;
    private List<RightBean.DataBean> mdatas;

    public RigthAdapter(Context context, List<RightBean.DataBean> mdatas) {
        this.context = context;
        this.mdatas = mdatas;
    }

    @NonNull
    @Override
    public ViewHolderRight onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.right_item,viewGroup,false);
        ViewHolderRight holderRight = new ViewHolderRight(view);
        return holderRight;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderRight viewHolderRight, int i) {
        RightBean.DataBean bean = mdatas.get(i);
        List<RightBean.DataBean.ChildData> childData = bean.list;
        String name = bean.name;
        viewHolderRight.title.setText(name);
        viewHolderRight.cycle.setLayoutManager(new GridLayoutManager(context,3));
        viewHolderRight.cycle.setAdapter(new RightChildAdapter(context,childData));
    }

    @Override
    public int getItemCount() {
        return mdatas==null ? 0:mdatas.size();
    }

    public class ViewHolderRight extends RecyclerView.ViewHolder {

        private TextView title;
        private RecyclerView cycle;


        public ViewHolderRight(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_title);
            cycle = itemView.findViewById(R.id.cycle);
        }
    }
}
