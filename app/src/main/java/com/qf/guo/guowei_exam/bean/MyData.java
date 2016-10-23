package com.qf.guo.guowei_exam.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/10/9 0009.
 */
public class MyData {

    /**
     * count : 35
     * description : 网络配图近日，王菲赴巴黎参加时装展，@感动王菲十大菲迷在微博曝光一组其看秀私照，天后实力演绎北京瘫，短发利落帅气
     * fcount : 0
     * fromname : 中国青年网
     * fromurl : http://minsheng.youth.cn/mszxgch/201610/t20161006_8718624.htm
     * id : 13628
     * img : /top/default.jpg
     * keywords : 王菲演绎北京瘫
     * rcount : 0
     * time : 1475840985000
     * title : 王菲演绎北京瘫 天后实力演绎北京瘫短发利落帅气
     * topclass : 2
     */

    private List<TngouBean> tngou;

    public List<TngouBean> getTngou() {
        return tngou;
    }

    public void setTngou(List<TngouBean> tngou) {
        this.tngou = tngou;
    }

    public static class TngouBean {
        private String description;
        private String fromname;
        private String img;
        private long time;
        private String title;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getFromname() {
            return fromname;
        }

        public void setFromname(String fromname) {
            this.fromname = fromname;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
