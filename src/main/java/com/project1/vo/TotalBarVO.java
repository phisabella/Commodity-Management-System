package com.project1.vo;

import java.util.List;

public class TotalBarVO {
    private List<String> names;
    private List<Float> totals;

    @Override
    public String toString() {
        return "TotalBarVO{" +
                "names=" + names +
                ", totals=" + totals +
                '}';
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public List<Float> getTotals() {
        return totals;
    }

    public void setTotals(List<Float> totals) {
        this.totals = totals;
    }

    public TotalBarVO() {
    }

    public TotalBarVO(List<String> names, List<Float> totals) {
        this.names = names;
        this.totals = totals;
    }
}
