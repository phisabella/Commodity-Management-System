package com.project1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Orders  {
    private int id;
    private int goodsId;
    private int count;
    private float total;
    private Date date;
    private String category;

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", goodsId=" + goodsId +
                ", count=" + count +
                ", total=" + total +
                ", date=" + date +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
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

    public Orders() {
    }

    public Orders(int id, int goodsId, int count, float total, Date date) {
        this.id = id;
        this.goodsId = goodsId;
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
