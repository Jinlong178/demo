package com.example.demo.demo.controller;

import com.example.demo.demo.model.Post;
import com.example.demo.demo.model.User;
import io.github.lvyahui8.spring.annotation.DataConsumer;
import io.github.lvyahui8.spring.annotation.DataProvider;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author JinLong
 * @Date 2019/8/27 17:11
 * @Version 1.0
 */
@RestController
public class Query {
    @DataProvider("userFullData")
    public User getUserFullData(@DataConsumer("users") User user, @DataConsumer("posts") List<Post> posts){
        user.setPosts(posts);
        System.out.println(user);
        return user;
    }
}
