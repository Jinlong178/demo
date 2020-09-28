package com.example.demo.demo.model;

import lombok.Data;

import java.util.List;

/**
 * @Author JinLong
 * @Date 2019/8/27 16:39
 * @Version 1.0
 */
@Data
public class User {
    private String id;

    private String name;

    private String email;

    private List<Post> posts;
}
