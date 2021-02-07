package com.project1.dao;

import com.project1.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    User login(@Param("username") String username, @Param("password")String password);
}
