package com.example.demo.controller;


import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.crypto.digest.MD5;
import com.example.demo.entity.PmUser;
import com.example.demo.entity.ResponseResult;
import com.example.demo.service.IPmUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
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
}

