package com.yuzhaigou.peilei.yuzhaigou.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/3/28.
 */
public class GoodEntity implements Serializable {
    private GoodData data;

    public GoodData getData() {
        return data;
    }

    public void setData(GoodData data) {
        this.data = data;
    }
}
