package com.qf.guo.guowei_exam.util;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.qf.guo.guowei_exam.bean.Title;
import com.qf.guo.guowei_exam.bean.TitleJson;

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
public class MyLoadTask extends AsyncTask<String,Void,List<TitleJson.TngouBean> >{

    private List<TitleJson.TngouBean> tngou = new ArrayList<>();

    //   1.定义接口，声明能够传回数据的方法
        public interface OnCompletedListener{
            void onCompleted(List<TitleJson.TngouBean> list);
        }

        private OnCompletedListener listener;

        //2.接收监听器对象
    public void setOnCompletedListener(OnCompletedListener listener) {
        this.listener = listener;
    }


    //下载解析
    @Override
    protected List<TitleJson.TngouBean> doInBackground(String... params) {
        MyLoadUtil myLoadUtil = new MyLoadUtil();
        //下载
        byte[] data = myLoadUtil.loadData(params[0]);
        String jsonString = new String(data);
		Log.e("print", jsonString);

        //解析
        Gson gson = new Gson();
        TitleJson titleJson = gson.fromJson(jsonString, TitleJson.class);
        tngou.addAll(titleJson.getTngou());
        return tngou;
    }

    @Override
    protected void onPostExecute(List<TitleJson.TngouBean> result) {
        //通过一个监听器，把结果传回
        if (listener != null) {
            listener.onCompleted(result);
        }

    }

}