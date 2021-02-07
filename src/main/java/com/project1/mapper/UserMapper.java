package com.project1.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.project1.entity.User;
import com.project1.vo.TotalBaseBarVO;
import com.project1.vo.UserVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    @Select("SELECT u.`id`,u.`username`,u.`realname`,u.`position`,u.`phone`,l.`level_name` cha,u.`level` FROM USER u,levellink l WHERE u.`level`=l.`level` ")
    public List<UserVO> findUser();

    @Select("UPDATE user SET level = '${level}' WHERE id = '${id}' ")
    public List<UserVO> level(@Param("level") int level,@Param("id") int id);
}
