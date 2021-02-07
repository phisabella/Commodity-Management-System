package com.project1.dao;

import com.project1.entity.Goods;
import com.project1.entity.Orders;

import java.util.List;

public interface GoodsDao {
    void add(Goods goods);

    List<Goods> findAll();

    void delete(String id);

    Goods find(String id);

    void update(Goods goods);

    void orderadd(Orders orders);
}
