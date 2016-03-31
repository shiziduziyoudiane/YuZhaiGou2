package com.yuzhaigou.peilei.yuzhaigou.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/3/28.
 */
public class AdvList implements Serializable{
    private String advId;
    private String advTitle;
    private String advUrl;
    private String apId;
    private String endDate;
    private String endDateStr;
    private String operationContent;
    private String operationType;
    private String resUrl;
    private String sort;
    private String startData;
    private String startDataStr;

    public String getAdvId() {
        return advId;
    }

    public void setAdvId(String advId) {
        this.advId = advId;
    }

    public String getAdvTitle() {
        return advTitle;
    }

    public void setAdvTitle(String advTitle) {
        this.advTitle = advTitle;
    }

    public String getAdvUrl() {
        return advUrl;
    }

    public void setAdvUrl(String advUrl) {
        this.advUrl = advUrl;
    }

    public String getApId() {
        return apId;
    }

    public void setApId(String apId) {
        this.apId = apId;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEndDateStr() {
        return endDateStr;
    }

    public void setEndDateStr(String endDateStr) {
        this.endDateStr = endDateStr;
    }

    public String getOperationContent() {
        return operationContent;
    }

    public void setOperationContent(String operationContent) {
        this.operationContent = operationContent;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getResUrl() {
        return resUrl;
    }

    public void setResUrl(String resUrl) {
        this.resUrl = resUrl;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getStartData() {
        return startData;
    }

    public void setStartData(String startData) {
        this.startData = startData;
    }

    public String getStartDataStr() {
        return startDataStr;
    }

    public void setStartDataStr(String startDataStr) {
        this.startDataStr = startDataStr;
    }
}
