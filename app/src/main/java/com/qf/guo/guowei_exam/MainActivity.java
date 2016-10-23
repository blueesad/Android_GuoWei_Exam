package com.qf.guo.guowei_exam;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.Gson;
import com.qf.guo.guowei_exam.adapter.MyPagerAdapter;
import com.qf.guo.guowei_exam.bean.Title;
import com.qf.guo.guowei_exam.bean.TitleJson;
import com.qf.guo.guowei_exam.util.MyLoadTask;
import com.qf.guo.guowei_exam.util.MyLoadTask.OnCompletedListener;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private String urlTitle = "http://www.tngou.net/api/top/classify";
    private OnCompletedListener listener;
    private MyPagerAdapter myPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//      初始化TabLayout
        initTabLayout();

//      分类接口 解析：http://www.tngou.net/api/top/classify
        getGsonTitle();


    }

    private void initTabLayout() {
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.view_pager);

    }

    public void getGsonTitle() {
        MyLoadTask myLoadTask = new MyLoadTask();

        //接口回调
        listener = new OnCompletedListener() {
            @Override
            public void onCompleted(List<TitleJson.TngouBean> list) {
                myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(),list);
                viewPager.setAdapter(myPagerAdapter);
                tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
                tabLayout.setupWithViewPager(viewPager);
            }
        };
        myLoadTask.setOnCompletedListener(listener);
        myLoadTask.execute(urlTitle);
    }
}
