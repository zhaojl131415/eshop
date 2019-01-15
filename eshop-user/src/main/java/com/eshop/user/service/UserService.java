package com.eshop.user.service;

import com.eshop.user.entity.User;
import com.eshop.user.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public List<User> findAllUsers(){
        return userMapper.findAllUsers();
    }
}
