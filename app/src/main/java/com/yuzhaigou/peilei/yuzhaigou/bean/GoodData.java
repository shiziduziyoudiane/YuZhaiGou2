package com.yuzhaigou.peilei.yuzhaigou.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/3/28.
 */
public class GoodData implements Serializable{
    private String floorName;
    private String floorType;
    private List<Good> goodList;
    private PanicBuyng panicBuyng;

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public String getFloorType() {
        return floorType;
    }

    public void setFloorType(String floorType) {
        this.floorType = floorType;
    }

    public List<Good> getGoodList() {
        return goodList;
    }

    public void setGoodList(List<Good> goodList) {
        this.goodList = goodList;
    }

    public PanicBuyng getPanicBuyng() {
        return panicBuyng;
    }

    public void setPanicBuyng(PanicBuyng panicBuyng) {
        this.panicBuyng = panicBuyng;
    }
}
