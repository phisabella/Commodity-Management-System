package com.project1.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.project1.entity.Permission;
import com.project1.vo.OrderVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionMapper extends BaseMapper<Permission> {
    @Select(" UPDATE permission SET gai=1 WHERE LEVEL >= '${level}' ")
    public List<OrderVO> gaiadd(@Param("level") int level);

    @Select(" UPDATE permission SET gai=0 WHERE LEVEL < '${level}' ")
    public List<OrderVO> gaidel(@Param("level") int level);

    @Select(" UPDATE permission SET shan=1 WHERE LEVEL >= '${level}' ")
    public List<OrderVO> shanadd(@Param("level") int level);

    @Select(" UPDATE permission SET shan=0 WHERE LEVEL < '${level}' ")
    public List<OrderVO> shandel(@Param("level") int level);
}
