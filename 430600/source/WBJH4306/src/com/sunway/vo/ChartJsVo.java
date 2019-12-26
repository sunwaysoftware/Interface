package com.sunway.vo;

import java.io.Serializable;

public class ChartJsVo implements Serializable {

    private String label;
    private long data;

    public ChartJsVo(int label, long data) {
        this.label = String.valueOf(label);
        this.data = data;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public long getData() {
        return data;
    }

    public void setData(long data) {
        this.data = data;
    }
}
