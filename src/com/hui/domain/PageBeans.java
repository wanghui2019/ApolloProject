package com.hui.domain;

import java.util.List;

public class PageBeans<T> {
    //当前页
    private int currPage;
    //一页显示多少
    private int showNum;
    //总页数
    private int totalPage;
    //总数量
    private int totalNum;
    //该页显示的具体列表
    private List<T> list;

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public int getShowNum() {
        return showNum;
    }

    public void setShowNum(int showNum) {
        this.showNum = showNum;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageBeans{" +
                "currPage=" + currPage +
                ", showNum=" + showNum +
                ", totalPage=" + totalPage +
                ", totalNum=" + totalNum +
                ", list=" + list +
                '}';
    }
}
