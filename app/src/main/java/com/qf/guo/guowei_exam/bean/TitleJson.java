package com.qf.guo.guowei_exam.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/10/9 0009.
 */
public class TitleJson {

    /**
     * description : 天狗实时事件:民生热点事件，民生热词排行 做最好的民生热点、热词提取；推送最新的民生实时事件，挖掘最新的民生热词。
     * id : 1
     * keywords : 民生热点事件 民生热词排行 天狗实时事件
     * name : 民生热点
     * seq : 1
     * title : 民生热点事件_民生热词排行-天狗实时事件
     */

    private List<TngouBean> tngou;

    public List<TngouBean> getTngou() {
        return tngou;
    }

    public void setTngou(List<TngouBean> tngou) {
        this.tngou = tngou;
    }

    public static class TngouBean {
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
