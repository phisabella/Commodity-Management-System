package com.project1.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project1.dao.GoodsDao;
import com.project1.entity.Goods;
import com.project1.entity.Orderlink;
import com.project1.entity.Orders;
import com.project1.mapper.GoodsMapper;
import com.project1.mapper.OrderMapper;
import com.project1.mapper.OrderlinkMapper;
import com.project1.vo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderlinkMapper orderlinkMapper;

//添加goods
    @Override
    public void add(Goods goods) {
//        goodsDao.add(goods);
         goodsMapper.insert(goods);
        //同时添加到orderlink表中
        Orderlink orderlink = new Orderlink();
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("name", goods.getName());
        Goods goods1 = goodsMapper.selectOne(wrapper);
        orderlink.setName(goods1.getName());
        orderlink.setId(goods1.getId());
        orderlinkMapper.insert(orderlink);
    }

    //查找所有goods
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Goods> findAll() {
        return goodsDao.findAll();
    }
    @Override
    public DataVO<Goods> findData(Integer page,Integer limit ,String name) {
//        List<Goods> all = goodsDao.findAll();
//        int size = all.size();

        DataVO dataVO = new DataVO();
        dataVO.setCode(0);
        dataVO.setMessage("");
//        dataVO.setCount(size);

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.like("name",name);

        IPage<Goods> goodsIPage = new Page<>(page,limit);
        IPage<Goods> pageresult;
        if (name!=null){
             pageresult = goodsMapper.selectPage(goodsIPage, wrapper);
        }else{
            pageresult = goodsMapper.selectPage(goodsIPage, null);
        }
        dataVO.setCount((int) pageresult.getTotal());
        List<Goods> goods = pageresult.getRecords();
//        List<GoodsVO> goodsVOList = new ArrayList<>();
//        for (Goods goods : all) {
////            GoodsVO goodsVO = new GoodsVO();
////            BeanUtils.copyProperties(goods, goodsVO);
//            dataVOList.add(goods);
//        }
        dataVO.setData(goods);
        return dataVO;
    }

    //删除goods
    @Override
    public void delete(String id) {
        goodsDao.delete(id);
    }

    //更新goods的数据
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Goods find(String id) {
        return goodsDao.find(id);
    }

    @Override
    public void update(Goods goods) {
        goodsMapper.updateById(goods);

        //同时添加到orderlink表中
        Orderlink orderlink = new Orderlink();
        Goods goods1 = goodsMapper.selectById(goods.getId());
        orderlink.setName(goods1.getName());
        orderlink.setId(goods1.getId());
        orderlinkMapper.updateById(orderlink);
    }

    //查询所有订单
    //"SELECT o.`id` ,g.`name`,o.`count`,o.`total`,o.`date`,o.`category` FROM orders o,orderlink g" +
    //            " WHERE  o.`goods_id`=g.`id` && (g.`name` LIKE '%${name}%') "

    @Override
    public DataVO<OrderVO> findOrder(Integer page, Integer limit ,String name) {
        DataVO dataVO = new DataVO();
        dataVO.setCode(0);
        dataVO.setMessage("");
        List<OrderVO> list;
        System.out.println("name                               :"+name);
        if(name!=null && !name.equals("")){
             list = orderMapper.orderlike(name);
             dataVO.setCount(list.size());
            dataVO.setData(list);
        }else{
            IPage<Orders> orderVOIPage = new Page<>(page,limit);
            IPage<Orders> pageresult = orderMapper.selectPage(orderVOIPage, null);

            dataVO.setCount((int) pageresult.getTotal());
            List<Orders> orderList = pageresult.getRecords();
            List<OrderVO> orderVOList = new ArrayList<>();
            for (Orders order : orderList) {
                OrderVO orderVO = new OrderVO();
                BeanUtils.copyProperties(order, orderVO);

                QueryWrapper queryWrapper = new QueryWrapper();
                queryWrapper.eq("id", order.getGoodsId());
                orderVO.setName(orderlinkMapper.selectOne(queryWrapper).getName());

                orderVOList.add(orderVO);
            }
            dataVO.setData(orderVOList);
        }

        return dataVO;
    }

    //添加订单
    //先查,直接调用find
    //再加
    @Override
    public void orderadd(int id,int amount) {
        Orders orders = new Orders();
        orders.setDate(new Date());
        Goods goods = goodsMapper.selectById(id);
        orders.setTotal(goods.getPrice() * amount);
        orders.setCount(amount);
        orders.setGoodsId(id);
        orders.setCategory(goods.getCategory());
        orderMapper.insert(orders);
        goods.setNumber(goods.getNumber()-amount);
        goodsMapper.updateById(goods);
    }

    @Override
    public TotalBarVO getTotalBarVO() {
        List<TotalBaseBarVO> list = orderMapper.findAllTotalVO();
        List<String> names = new ArrayList<>();
        List<Float> totals = new ArrayList<>();
        for (TotalBaseBarVO vo : list) {
            names.add(vo.getName());
            totals.add(vo.getTotal());
        }
        TotalBarVO totalBarVO = new TotalBarVO();
        totalBarVO.setNames(names);
        totalBarVO.setTotals(totals);
        return totalBarVO;
    }

    @Override
    public List<CountPieVO> getCountBarVO() {
        List<CountPieVO> list = orderMapper.findAllCountVO();
        return list;
    }

    @Override
    public void deleteorder(int id) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id", id);
        orderMapper.delete(wrapper);
    }
}
