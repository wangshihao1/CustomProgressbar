package com.bawei.customprogressbar.fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.bawei.customprogressbar.R;
import com.bawei.customprogressbar.adapter.ShowAdapter;
import com.bawei.customprogressbar.api.Apis;
import com.bawei.customprogressbar.bean.BeautifulBean;
import com.bawei.customprogressbar.presenter.IPrensenterImp;
import com.bawei.customprogressbar.view.IView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;
import java.util.Map;

public class FragmentHome extends Fragment implements IView {

    private ShowAdapter adapter;
    private IPrensenterImp prensenterImp;
    private XRecyclerView recyclerView;
    private int mPage = 1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_home,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPage = 1;
        recyclerView = view.findViewById(R.id.xrcycle);
        prensenterImp = new IPrensenterImp(this);
        adapter = new ShowAdapter(getActivity());
        recyclerView.setAdapter(adapter);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setPullRefreshEnabled(true);
        recyclerView.setLoadingMoreEnabled(true);
        recyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mPage = 1;
                initData();
            }

            @Override
            public void onLoadMore() {
                initData();
            }
        });

    }

    private void initData(){
        Map<String,String> map = new HashMap<>();
        prensenterImp.getData(Apis.BEAUTIFY_URL,map,BeautifulBean.class);
    }

    @Override
    public void showData(Object datas) {
          if (datas instanceof BeautifulBean){
              BeautifulBean bean = (BeautifulBean) datas;
              if (bean==null){
                  Toast.makeText(getActivity(),"获取数据失败",Toast.LENGTH_SHORT).show();
              }else {
                   if (mPage==1){
                       adapter.setMdatas(bean.getResults());
                   }else{
                       adapter.addMdatas(bean.getResults());
                   }
                   mPage++;
                   recyclerView.refreshComplete();
                   recyclerView.loadMoreComplete();
              }
          }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        prensenterImp.onDetach();
    }
}
