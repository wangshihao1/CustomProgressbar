package com.bawei.customprogressbar.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.bawei.customprogressbar.R;
import com.bawei.customprogressbar.adapter.FragPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowActivity extends AppCompatActivity {
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.tablayout)
    TabLayout tablayout;
    private FragPagerAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        ButterKnife.bind(this);
        adapter = new FragPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tablayout.setupWithViewPager(viewPager);
    }

}
