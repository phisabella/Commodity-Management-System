package com.project1.mapper;

import com.project1.vo.TotalBaseBarVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderMapperTest {

    @Autowired
    private OrderMapper orderMapper;


    @Test
    void findAllTotalVO() {
        List<TotalBaseBarVO> list = orderMapper.findAllTotalVO();
        int i=0;
    }
}