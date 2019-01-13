package com.bawei.zkweekrewrite.ui.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bawei.zkweekrewrite.R;
import com.bawei.zkweekrewrite.data.bean.RightBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class DetailsAdapter extends BaseQuickAdapter<RightBean.DataBean,BaseViewHolder> {


    public DetailsAdapter(int layoutResId, @Nullable List<RightBean.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RightBean.DataBean item) {
          helper.setText(R.id.tv_text,item.getName());
          RecyclerView cycle_child = helper.getView(R.id.cycle_child);
          //商品条目
        List<RightBean.DataBean.ListBean> itemList = item.getList();
        //布局管理器
        GridLayoutManager manager = new GridLayoutManager(mContext, 2, GridLayoutManager.VERTICAL, false);
         cycle_child.setLayoutManager(manager);
        //设置适配器
        CommodityAdapter commodityAdapter = new CommodityAdapter(R.layout.commodity_item,itemList);
        cycle_child.setAdapter(commodityAdapter);

    }
}
