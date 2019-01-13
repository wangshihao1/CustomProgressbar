package com.bawei.wangshihao0107.view;

import com.bawei.wangshihao0107.bean.LeftBean;
import com.bawei.wangshihao0107.bean.RightBean;

import java.util.List;

public interface IView {


    void leftSuccess(List<LeftBean.DataBean> left);
    void rightSuccess(List<RightBean.DataBean> left);
    void leftfialed(String e);
    void rightfialed(String e);
}
