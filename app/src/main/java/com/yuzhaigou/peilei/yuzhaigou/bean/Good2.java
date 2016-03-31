package com.yuzhaigou.peilei.yuzhaigou.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/3/28.
 */
public class Good2 implements Serializable{
    private String goodsId;
    private String goodsImage;
    private String goodsName;
    private String goodsStorePrice;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsStorePrice() {
        return goodsStorePrice;
    }

    public void setGoodsStorePrice(String goodsStorePrice) {
        this.goodsStorePrice = goodsStorePrice;
    }
}
