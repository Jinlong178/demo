package com.example.demo.demo.service;

import com.example.demo.demo.model.Post;

import java.util.List;

/**
 * @Author JinLong
 * @Date 2019/8/27 17:04
 * @Version 1.0
 */
public interface PostService {
    List<Post> getPosts(String id);

}
