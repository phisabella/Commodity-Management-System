package com.project1.service;

import com.project1.entity.User;
import com.project1.vo.DataVO;
import com.project1.vo.OrderVO;

public interface UserService {
    User login(String username,String password);

    DataVO<User> findUser(Integer page, Integer limit );

    void delete(String id);
}
