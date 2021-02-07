package com.project1.vo;

public class CountPieVO {
    private int value;
    private String name;

    @Override
    public String toString() {
        return "CountPieVO{" +
                "value=" + value +
                ", name='" + name + '\'' +
                '}';
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CountPieVO() {
    }

    public CountPieVO(int value, String name) {
        this.value = value;
        this.name = name;
    }
}
