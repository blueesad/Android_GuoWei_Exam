package com.qf.guo.guowei_exam.bean;

/**
 * Created by asus on 2016/10/8.
 */
public class Title {
    String tabName;
    int cat;

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }

    public int getCat() {
        return cat;
    }

    public void setCat(int cat) {
        this.cat = cat;
    }

    public Title(String tabName, int cat) {
        this.tabName = tabName;
        this.cat = cat;
    }

    public Title() {
    }
}
