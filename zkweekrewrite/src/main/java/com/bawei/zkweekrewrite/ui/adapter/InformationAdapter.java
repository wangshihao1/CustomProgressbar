package com.bawei.zkweekrewrite.ui.adapter;

import android.support.annotation.Nullable;

import com.bawei.zkweekrewrite.R;
import com.bawei.zkweekrewrite.data.bean.LeftBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class InformationAdapter extends BaseQuickAdapter<LeftBean.DataBean,BaseViewHolder> {



    public InformationAdapter(int layoutResId, @Nullable List<LeftBean.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, LeftBean.DataBean item) {
        helper.setText(R.id.tv_text,item.getName());
    }
}
