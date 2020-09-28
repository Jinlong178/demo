package com.example.demo.demo.service.impl;

import com.example.demo.demo.model.Post;
import com.example.demo.demo.service.PostService;
import io.github.lvyahui8.spring.annotation.DataProvider;
import io.github.lvyahui8.spring.annotation.InvokeParameter;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @Author JinLong
 * @Date 2019/8/27 17:05
 * @Version 1.0
 */
@Service
public class PostServiceImpl implements PostService {

    @DataProvider("posts")
    @Override
    public List<Post> getPosts(@InvokeParameter("id") String id) {
        try {
            Thread.sleep(1000L);
        } catch(InterruptedException ignored) {
        }
        Post post=new Post();
        post.setTitle("啊啊啊啊啊");
        post.setContent("哈哈哈哈哈哈哈哈哈");
        return Collections.singletonList(post);
    }
}
