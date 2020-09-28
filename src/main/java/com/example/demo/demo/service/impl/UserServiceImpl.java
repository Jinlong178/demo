package com.example.demo.demo.service.impl;

import com.example.demo.demo.model.User;
import com.example.demo.demo.service.UserService;
import io.github.lvyahui8.spring.annotation.DataProvider;
import io.github.lvyahui8.spring.annotation.InvokeParameter;
import org.springframework.stereotype.Service;

/**
 * @Author JinLong
 * @Date 2019/8/27 16:57
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @DataProvider("users")
    @Override
    public User get(@InvokeParameter("id") String id) {
        try {
            Thread.sleep(1000L);
        } catch(InterruptedException ignored) {
        }
        User user=new User();
        user.setId(id);
        user.setName("二狗");
        user.setEmail("xxx@xx.xx");
        return user;
    }
}
