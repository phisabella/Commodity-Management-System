package com.project1.service;

import com.project1.entity.Goods;
import com.project1.vo.CountPieVO;
import com.project1.vo.DataVO;
import com.project1.vo.OrderVO;
import com.project1.vo.TotalBarVO;

import java.util.List;

public interface GoodsService {
    //添加商品
    void add(Goods goods);

    //查找所有商品
    List<Goods> findAll();
    DataVO<Goods> findData(Integer page, Integer limit ,String name);
    //删除某个商品
    void delete(String id);

    //更改某个商品信息
    //先查
    Goods find(String id);
    //再改
    void update(Goods goods);

    DataVO<OrderVO> findOrder(Integer page, Integer limit ,String name);
    //添加订单
    //先查,直接调find
    //再加
    void orderadd(int id,int amount);

    //totalbarvo
    TotalBarVO getTotalBarVO();
    //countbarvo
    List<CountPieVO> getCountBarVO();

    void deleteorder(int id);
}
