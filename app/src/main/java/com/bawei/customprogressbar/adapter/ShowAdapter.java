package com.bawei.customprogressbar.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bawei.customprogressbar.R;
import com.bawei.customprogressbar.bean.BeautifulBean;
import com.bawei.customprogressbar.bean.JingDongBean;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class ShowAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

     private List<BeautifulBean.ResultsBean> mdatas;
     private Context context;

    public ShowAdapter(Context context) {
        this.context = context;
         mdatas = new ArrayList<>();
    }

    public void setMdatas(List<BeautifulBean.ResultsBean> datas) {
        mdatas.clear();
        if (datas!=null){
            mdatas.addAll(datas);
        }
        notifyDataSetChanged();
    }

    public void addMdatas(List<BeautifulBean.ResultsBean> datas) {
        if (datas!=null){
            mdatas.addAll(datas);
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder holder;
        View view = LayoutInflater.from(context).inflate(R.layout.pubu,viewGroup,false);
        holder = new BeautifulViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        BeautifulViewHolder beautifulViewHolder = (BeautifulViewHolder) viewHolder;
        String s = mdatas.get(i).getUrl().replace("https", "http");
        Glide.with(context).load(s).into(beautifulViewHolder.icon);
        beautifulViewHolder.title.setText(mdatas.get(i).getDesc());
        beautifulViewHolder.time.setText(mdatas.get(i).getCreatedAt());
    }

    @Override
    public int getItemCount() {
        return mdatas.size();
    }


    class BeautifulViewHolder extends RecyclerView.ViewHolder{

        private final ImageView icon;
        private final TextView title,time;


        public BeautifulViewHolder(@NonNull View itemView) {
            super(itemView);
            icon  = itemView.findViewById(R.id.iv_icon);
            title = itemView.findViewById(R.id.tv_title);
            time = itemView.findViewById(R.id.tv_time);
        }
    }
}
