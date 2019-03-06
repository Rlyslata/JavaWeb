package com.demo.service;

import com.demo.dao.User_InfoMapper;
import com.demo.entity.User_Info;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService{

    @Resource
    private  User_InfoMapper userMapper;
    @Override
    public int insertUser(User_Info record) {
       return userMapper.insert(record);
    }
}
