package com.yuzhaigou.peilei.yuzhaigou.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/3/28.
 */
public class BannerData implements Serializable{
    private List<AdvList>advList;

    public List<AdvList> getAdvList() {
        return advList;
    }

    public void setAdvList(List<AdvList> advList) {
        this.advList = advList;
    }
}
