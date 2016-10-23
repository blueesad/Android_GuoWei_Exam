package com.qf.guo.guowei_exam.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;
import com.qf.guo.guowei_exam.R;
import com.qf.guo.guowei_exam.adapter.MyListAdapter;
import com.qf.guo.guowei_exam.bean.MyData;
import com.qf.guo.guowei_exam.bean.TitleJson;
import com.qf.guo.guowei_exam.util.MyLoadUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/9 0009.
 */
public class MyListFrament extends Fragment {

    private MyListAdapter adapter;
    private String urlString = "http://www.tngou.net/api/top/list?rows=20&page=1&id=";
    private List<MyData.TngouBean> tngou = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_layout, null);
        ListView listView = (ListView) view.findViewById(R.id.list_view);

        adapter = new MyListAdapter(getContext(),tngou);
        listView.setAdapter(adapter);

        //开启异步任务
        int id = getArguments().getInt("id");
        startLoadTask(id);
        return view;
    }

    private void startLoadTask(int id) {

        MyLoadTask myLoadTask = new MyLoadTask();
        myLoadTask.execute(urlString+id);
    }

    private class MyLoadTask extends AsyncTask<String,Void,Void> {

        @Override
        protected Void doInBackground(String... params) {
            MyLoadUtil myLoadUtil = new MyLoadUtil();
            //下载
            byte[] data = myLoadUtil.loadData(params[0]);
            String jsonString = new String(data);
            Log.e("print", jsonString);

            //解析
            Gson gson = new Gson();
            MyData myData = gson.fromJson(jsonString, MyData.class);
            tngou.addAll(myData.getTngou());

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            adapter.notifyDataSetChanged();
        }
    }
}
