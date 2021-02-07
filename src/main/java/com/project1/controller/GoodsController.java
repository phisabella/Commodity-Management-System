package com.project1.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.project1.entity.Goods;
import com.project1.mapper.GoodsMapper;
import com.project1.service.GoodsService;
import com.project1.utils.Respone;
import com.project1.vo.CountPieVO;
import com.project1.vo.DataVO;
import com.project1.vo.TotalBarVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GoodsMapper goodsMapper;
    //添加一个商品
    @ResponseBody
    @PostMapping("/add")
    public Object add(@RequestBody Goods goods){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("name",goods.getName());
        Goods one = goodsMapper.selectOne(wrapper);
        if(one==null){
            goodsService.add(goods);
            return new Respone(0, "添加成功");
        }else{
            return new Respone(999, "添加失败");
        }
//        return "redirect:/index1";
    }

//查找所有商品
//    @GetMapping("/findAll")
//    public String findAll(Model model){
//        List<Goods> goods = goodsService.findAll();
//        model.addAttribute("goods", goods);
//        return "index";
//    }

    @ResponseBody
    @GetMapping("findAll")
    public  DataVO datavo(Integer page,Integer limit,String name){
        TotalBarVO totalBarVO = goodsService.getTotalBarVO();
        return  goodsService.findData(page, limit,name);
    }


    //删除某个商品
    @GetMapping("delete")
    public String delete(String id){
        goodsService.delete(id);
        return "index";
    }

    //修改某个商品
    //先查
    @GetMapping("find")
    public String find(String id,Model model){
        Goods goods = goodsService.find(id);
        model.addAttribute("one", goods);
        return "index2";
    }
    //再改
    @ResponseBody
    @PostMapping("update")
    public Object update(@RequestBody Goods goods){
        goodsService.update(goods);
        return new Respone(0, "用户更新成功");
    }

//查询订单
    @ResponseBody
    @GetMapping("findOrder")
    public DataVO findOrder(Integer page,Integer limit,String name){
        return  goodsService.findOrder(page, limit,name);
    }

    //添加订单
    //先查
    @GetMapping("orderfind")
    public String orderfind(String id,Model model){
        Goods goods = goodsService.find(id);
        model.addAttribute("one", goods);
        return "addorder";
    }
    //再加
    @ResponseBody
    @GetMapping("orderadd")
    public Object orderadd(int id, int amount){
        goodsService.orderadd(id, amount);
        return new Respone(0, "用户更新成功");
//        return "addorder";
    }

    @ResponseBody
    @GetMapping("bartotal")
    public TotalBarVO bartotal(){
        return goodsService.getTotalBarVO();
    }

    @ResponseBody
    @GetMapping("piecount")
    public List<CountPieVO> piecount(){
        return goodsService.getCountBarVO();
    }

    //删除某个订单
    @GetMapping("deleteorder")
    public String deleteorder(int id){
        goodsService.deleteorder(id);
        return "redirect:/index4";
    }
}
