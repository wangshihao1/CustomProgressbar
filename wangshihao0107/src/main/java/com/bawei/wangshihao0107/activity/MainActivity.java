package com.bawei.wangshihao0107.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bawei.wangshihao0107.R;
import com.bawei.wangshihao0107.adapter.FragPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private FragPagerAdapter adapter;
    private ViewPager pager;
    private TabLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        pager = findViewById(R.id.vp_pager);
        layout = findViewById(R.id.tablayout);
        adapter = new FragPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        layout.setupWithViewPager(pager);
    }
}
