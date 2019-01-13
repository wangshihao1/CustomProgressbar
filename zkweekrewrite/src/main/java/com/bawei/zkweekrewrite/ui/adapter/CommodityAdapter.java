package com.bawei.zkweekrewrite.ui.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bawei.zkweekrewrite.R;
import com.bawei.zkweekrewrite.data.bean.RightBean;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class CommodityAdapter extends BaseQuickAdapter<RightBean.DataBean.ListBean,BaseViewHolder> {


    public CommodityAdapter(int layoutResId, @Nullable List<RightBean.DataBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RightBean.DataBean.ListBean item) {
            helper.setText(R.id.tv_text,item.getName());
            ImageView image = helper.getView(R.id.iv_img);
            Glide.with(mContext).load(item.getIcon()).into(image);
    }
}
