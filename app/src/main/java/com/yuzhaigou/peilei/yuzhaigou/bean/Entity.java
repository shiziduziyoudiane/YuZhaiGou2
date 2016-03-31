package com.yuzhaigou.peilei.yuzhaigou.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/3/28.
 */
public class Entity implements Serializable {
    private List<BannerData> data;

    public List<BannerData> getData() {
        return data;
    }

    public void setData(List<BannerData> data) {
        this.data = data;
    }
}
