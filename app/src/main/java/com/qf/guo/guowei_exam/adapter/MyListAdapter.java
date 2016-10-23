package com.qf.guo.guowei_exam.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.qf.guo.guowei_exam.R;
import com.qf.guo.guowei_exam.bean.MyData;
import com.qf.guo.guowei_exam.bean.TitleJson;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/10/9 0009.
 */
public class MyListAdapter extends BaseAdapter {
    private final Context context;
    private final List<MyData.TngouBean> tngou;

    public MyListAdapter(Context context, List<MyData.TngouBean> tngou) {
        this.context = context;
        this.tngou = tngou;
    }


    @Override
    public int getCount() {
        return tngou.size();
    }

    @Override
    public Object getItem(int position) {
        return tngou.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHodler myViewHodler;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_layout,null);
            myViewHodler = new MyViewHodler();
            myViewHodler.imageView = (ImageView) convertView.findViewById(R.id.imageView);
            myViewHodler.titleTextView = (TextView) convertView.findViewById(R.id.title_textView);
            myViewHodler.contentTextView = (TextView) convertView.findViewById(R.id.content_textView);
            myViewHodler.newsTextView = (TextView) convertView.findViewById(R.id.news_textView);
            myViewHodler.timeTextView = (TextView) convertView.findViewById(R.id.time_textView);

            convertView.setTag(myViewHodler);
        }else
            myViewHodler = (MyViewHodler) convertView.getTag();

        //绑定数据
        myViewHodler.titleTextView.setText(tngou.get(position).getTitle());
        myViewHodler.contentTextView.setText(tngou.get(position).getDescription());
        myViewHodler.newsTextView.setText(tngou.get(position).getFromname());

        //时间转换
        Date d = new Date(tngou.get(position).getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(d);

        myViewHodler.timeTextView.setText(time);


//        /top/161008/683e484b6266aa0d24c0863cf1dd6b4a.png
//        http://tnfs.tngou.net/image/top/default.jpg_180x120
        String picUrl = tngou.get(position).getImg();
        picUrl = "http://tnfs.tngou.net/image/" +picUrl;

         Picasso.with(context).load(picUrl).into(myViewHodler.imageView);

        return convertView;
    }

    class  MyViewHodler{
        ImageView imageView;
        TextView titleTextView ,contentTextView,timeTextView,newsTextView;
    }

}
