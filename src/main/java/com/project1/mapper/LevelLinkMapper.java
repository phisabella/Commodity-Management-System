package com.project1.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.project1.entity.Levellink;
import com.project1.entity.Orderlink;
import com.project1.vo.OrderVO;
import com.project1.vo.TotalBaseBarVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface LevelLinkMapper extends BaseMapper<Levellink> {
    @Select(" UPDATE levellink SET level_name='${name}' WHERE LEVEL = '${level}' ")
    public void update(@Param("name") String name,@Param("level") String level);
}
