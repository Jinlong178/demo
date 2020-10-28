package com.example.demo.controller;

import com.example.demo.entity.PmUser;
import com.example.demo.entity.ResponseResult;
import com.example.demo.service.IPmUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Something
 * @since 2020-10-28
 */
@RestController
@RequestMapping("/user")
public class PmUserController {

    @Autowired
    private IPmUserService iPmUserService;


    @PostMapping("/register")
    public ResponseResult register(@RequestBody PmUser pmUser){
        Map result = iPmUserService.register(pmUser);
        return ResponseResult.success(result);
    }

    @PostMapping("/login")
    public ResponseResult login(@RequestBody PmUser pmUser){
        Map login = iPmUserService.login(pmUser);
        return ResponseResult.success(login);
    }
}

