package cn.weiyin.group07.controller;

import cn.weiyin.group07.pojo.User;
import cn.weiyin.group07.result.Result;
import cn.weiyin.group07.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;
//    注册
    @PostMapping("/register")
    public Result<String> register(@RequestBody User inputUser) {
        int register = userService.register(inputUser);
        if(register == 1) {
            return Result.success("注册成功");
        }
        else
            return Result.failed("注册失败");
    }
//    登录
    @PostMapping("/login")
    public Result<User> login(@RequestBody User inputUser) {
//        参数里应该只有email和password
        User user = userService.login(inputUser.getEmail(), inputUser.getPassword());
        if(user != null) {
            return Result.success(user,"登录成功");
        }
        else {
            return Result.failed("登录失败");
        }
    }
}
