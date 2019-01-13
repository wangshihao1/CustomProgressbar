package com.bawei.wangshihao0107.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.wangshihao0107.R;
import com.bawei.wangshihao0107.adapter.LeftAdapter;
import com.bawei.wangshihao0107.adapter.RigthAdapter;
import com.bawei.wangshihao0107.bean.LeftBean;
import com.bawei.wangshihao0107.bean.RightBean;
import com.bawei.wangshihao0107.presenter.IPresenterImp;
import com.bawei.wangshihao0107.view.IView;
import java.util.HashMap;
import java.util.List;


public class FragClass extends Fragment implements IView,LeftAdapter.onItemClick {

    private LeftAdapter leftAdapter;
    private RigthAdapter rigthAdapter;
    private RecyclerView leftt;
    private RecyclerView right;
    private IPresenterImp presenterImp;
    private String id = "1";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_class,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        leftt = view.findViewById(R.id.left_cycle);
        right = view.findViewById(R.id.right_cycle);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initData() {
        presenterImp = new IPresenterImp(this);
        leftt.setLayoutManager(new LinearLayoutManager(getActivity()));
        right.setLayoutManager(new LinearLayoutManager(getActivity()));
        presenterImp.leftResult(new HashMap<String, String>());
        getRight();
    }

    private void getRight() {
        HashMap<String,String> has = new HashMap<>();
        has.put("cid",id);
        presenterImp.rightResult(has);
    }

    @Override
    public void onClick(String cid) {
          id = cid;
          getRight();
    }


    @Override
    public void leftSuccess(List<LeftBean.DataBean> left) {
        if (leftAdapter == null) {
            leftAdapter = new LeftAdapter(getActivity(),left);
            leftt.setAdapter(leftAdapter);
        } else {
            leftAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void rightSuccess(List<RightBean.DataBean> left) {
        rigthAdapter = new RigthAdapter(getActivity(),left);
          right.setAdapter(rigthAdapter);
    }

    @Override
    public void leftfialed(String e) {

    }

    @Override
    public void rightfialed(String e) {

    }
}
