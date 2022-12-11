package cn.weiyin.group07.service;

import cn.weiyin.group07.mapper.UserMapper;
import cn.weiyin.group07.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public int register(User user) {
        return userMapper.insertUser(user);
    }

    public User login(String inputEmail,String inputPwd) {
        User user = userMapper.selectUserByEmailAndPassword(inputEmail, inputPwd);
        return user;
    }
}
