package com.project1.vo;

public class TotalBaseBarVO {
    private String name;
    private Float total;
    @Override
    public String toString() {
        return "TotalBaseBarVO{" +
                "name='" + name + '\'' +
                ", total=" + total +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public TotalBaseBarVO() {
    }

    public TotalBaseBarVO(String name, Float total) {
        this.name = name;
        this.total = total;
    }


}
