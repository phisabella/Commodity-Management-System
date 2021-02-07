package com.project1.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.project1.entity.Orders;
import com.project1.vo.CountPieVO;
import com.project1.vo.OrderVO;
import com.project1.vo.TotalBaseBarVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper extends BaseMapper<Orders> {
    @Select("SELECT g.`name`,SUM(total) total FROM orders o,goods g WHERE o.`goods_id`=g.`id` GROUP BY goods_id; ")
    public List<TotalBaseBarVO> findAllTotalVO();

    @Select("SELECT g.`name`,SUM(COUNT) value FROM orders o,goods g WHERE o.`goods_id`=g.`id` GROUP BY goods_id")
    public List<CountPieVO> findAllCountVO();

    @Select("SELECT o.`id` ,g.`name`,o.`count`,o.`total`,o.`date`,o.`category` FROM orders o,orderlink g" +
            " WHERE  o.`goods_id`=g.`id` && (g.`name` LIKE '%${name}%') ")
     public List<OrderVO> orderlike(@Param("name") String name);
//    public List<OrderVO> orderlike(@Param("name") String name,@Param("page") Integer page,@Param("limit") Integer limit);


//    @Select("SELECT * FROM user where name = #{name}")
//  List<User> selectByName(@Param("name") String name);Integer page, Integer limit
}
