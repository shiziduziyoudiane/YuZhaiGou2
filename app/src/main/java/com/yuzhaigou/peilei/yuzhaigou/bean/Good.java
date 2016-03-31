package com.yuzhaigou.peilei.yuzhaigou.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/3/28.
 */
public class Good implements Serializable{
    private Good2 goods;
    private String relId;

    public Good2 getGoods() {
        return goods;
    }

    public void setGoods(Good2 goods) {
        this.goods = goods;
    }

    public String getRelId() {
        return relId;
    }

    public void setRelId(String relId) {
        this.relId = relId;
    }
}
