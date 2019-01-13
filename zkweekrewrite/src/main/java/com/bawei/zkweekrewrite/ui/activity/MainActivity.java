package com.bawei.zkweekrewrite.ui.activity;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.bawei.zkweekrewrite.R;
import com.bawei.zkweekrewrite.data.bean.LeftBean;
import com.bawei.zkweekrewrite.data.bean.RightBean;
import com.bawei.zkweekrewrite.di.contract.IContract;
import com.bawei.zkweekrewrite.di.presemter.IPresenterImp;
import com.bawei.zkweekrewrite.ui.adapter.DetailsAdapter;
import com.bawei.zkweekrewrite.ui.adapter.InformationAdapter;
import com.bawei.zkweekrewrite.ui.custom.CustomTitleBar;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements IContract.IView {

    @BindView(R.id.custom_title)
    CustomTitleBar customTitle;
    @BindView(R.id.cycle_left)
    RecyclerView cycleLeft;
    @BindView(R.id.cycle_right)
    RecyclerView cycleRight;
    private InformationAdapter informationAdapter;
    private CustomTitleBar customTitleBar;
    private Context context;
    private IPresenterImp presenterImp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        context = this;
        presenterImp = new IPresenterImp();
        presenterImp.attachView(this);
        presenterImp.requestInformation();
        customTitleBar = findViewById(R.id.custom_title);
        customTitleBar.setCallBackListener(new CustomTitleBar.onCallBackListener() {
            @Override
            public void onCallBack() {
                MainActivity.this.finish();
            }
        });
        customTitleBar.setMenuBackListener(new CustomTitleBar.onMenuBackListener() {
            @Override
            public void onCallBack() {
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(customTitleBar, "alpha", 0.1f, 0.8f);
                objectAnimator.setDuration(2000);
                objectAnimator.start();
            }
        });
    }

    @OnClick({R.id.custom_title, R.id.cycle_left})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.custom_title:
                break;
            case R.id.cycle_left:
                break;
        }
    }

    @Override
    public void showInformation(final String data) {
          runOnUiThread(new Runnable() {
              @Override
              public void run() {
                  Gson gson = new Gson();
                  LeftBean leftBean = gson.fromJson(data, LeftBean.class);
                  //获取数据源
                  final List<LeftBean.DataBean> beans = leftBean.getData();
                  LinearLayoutManager manager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
                  cycleLeft.setLayoutManager(manager);
                  informationAdapter = new InformationAdapter(R.layout.left_item,beans);
                  cycleLeft.setAdapter(informationAdapter);
                  // 封装自带setOnItemClickListener点击事件
                  informationAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                      @Override
                      public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                          // 获取请求参数的id
                          int cid = beans.get(position).getCid();
                          //点击子条目 请求详情数据
                          presenterImp.requestDetails(cid);
                      }
                  });


              }
          });
    }

    @Override
    public void showDetails(final String data) {
           runOnUiThread(new Runnable() {
               @Override
               public void run() {
                   Gson gson = new Gson();
                   RightBean rightBean = gson.fromJson(data, RightBean.class);
                   // 获取数据源
                   List<RightBean.DataBean> beanData = rightBean.getData();
                   LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
                   cycleRight.setLayoutManager(layoutManager);
                   DetailsAdapter detailsAdapter = new DetailsAdapter(R.layout.right_title_bar,beanData);
                   cycleRight.setAdapter(detailsAdapter);

               }
           });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenterImp.dectach(this);
    }
}
