package com.bawei.wangshihao0107.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bawei.wangshihao0107.fragment.FragClass;
import com.bawei.wangshihao0107.fragment.FragHome;
import com.bawei.wangshihao0107.fragment.FragMine;

public class FragPagerAdapter extends FragmentPagerAdapter {

    private String[] names = new String[]{
            "首页","分类","我的"
    };

    public FragPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                return new FragHome();
            case 1:
                return new FragClass();
            case 2:
                return new FragMine();
                default:
                    return new Fragment();
        }
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return names[position];
    }
}
