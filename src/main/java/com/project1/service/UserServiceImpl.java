package com.project1.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project1.dao.UserDao;
import com.project1.entity.Goods;
import com.project1.entity.User;
import com.project1.mapper.PermissionMapper;
import com.project1.mapper.UserMapper;
import com.project1.vo.DataVO;
import com.project1.vo.OrderVO;
import com.project1.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserMapper userMapper;



    @Override
    public User login(String username, String password) {
        return userDao.login(username,password);
    }

    @Override
    public DataVO<User> findUser(Integer page, Integer limit) {
        DataVO dataVO = new DataVO();
        dataVO.setCode(0);
        dataVO.setMessage("");
        List<UserVO> user = userMapper.findUser();

        IPage<User> userIPageI = new Page<>(page,limit);
        IPage<User> pageresult;
        pageresult = userMapper.selectPage(userIPageI, null);

        dataVO.setCount((int) pageresult.getTotal());
        List<User> users = pageresult.getRecords();
        dataVO.setData(user);
        return dataVO;
    }

    @Override
    public void delete(String id) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id",id);
        userMapper.delete(wrapper);
    }


}
