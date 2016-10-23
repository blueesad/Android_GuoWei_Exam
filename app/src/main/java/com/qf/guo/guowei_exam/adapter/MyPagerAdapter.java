package com.qf.guo.guowei_exam.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.qf.guo.guowei_exam.bean.TitleJson;
import com.qf.guo.guowei_exam.fragment.MyListFrament;

import java.util.List;

/**
 * Created by Administrator on 2016/10/9 0009.
 */
public class MyPagerAdapter extends FragmentPagerAdapter {
    private final List<TitleJson.TngouBean> titles;

    public MyPagerAdapter(FragmentManager fm, List<TitleJson.TngouBean> titles) {
        super(fm);
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new MyListFrament();
        Bundle bundle = new Bundle();
        bundle.putInt("id",titles.get(position).getId());
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return titles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position).getName();
    }
}
