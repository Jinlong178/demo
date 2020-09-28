package com.example.demo.demo.service;

import com.example.demo.demo.model.User;
import org.springframework.stereotype.Service;

/**
 * @Author JinLong
 * @Date 2019/8/27 16:56
 * @Version 1.0
 */

public interface UserService {
    User get(String id);
}
