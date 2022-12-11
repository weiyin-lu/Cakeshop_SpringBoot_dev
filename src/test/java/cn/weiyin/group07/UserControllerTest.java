package cn.weiyin.group07;

import cn.weiyin.group07.mapper.UserMapper;
import cn.weiyin.group07.pojo.User;
import cn.weiyin.group07.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserControllerTest {
    @Autowired
    UserService userService;

    @Test
    public void registerTest() {
        User user = new User();
        user.setPassword("test");
        user.setEmail("test@test.com");
        user.setUsername("test");
        int register = userService.register(user);
        System.out.println(register);
    }
}
