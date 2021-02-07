package com.project1.vo;

import lombok.Data;

import java.util.Date;


public class OrderVO {
    private Integer id;
    private String name;
    private Integer count;
    private float total;
    private String category;
    private Date date;

    @Override
    public String toString() {
        return "OrderVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", total=" + total +
                ", date=" + date +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public OrderVO() {
    }

    public OrderVO(Integer id, String name, Integer count, float total, Date date) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.total = total;
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
