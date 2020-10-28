package com.example.demo.controller;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.RSA;
import com.example.demo.entity.ResponseResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

@RestController
@RequestMapping("/rsa")
public class RsaController {

    public static RSA rsa = null;
    public static PrivateKey aPrivate = null;
    public static PublicKey aPublic = null;

    static {
        KeyPair rsaPair = SecureUtil.generateKeyPair("RSA");
        aPrivate = rsaPair.getPrivate();
        aPublic = rsaPair.getPublic();
        rsa = SecureUtil.rsa(aPrivate.getEncoded(), aPublic.getEncoded());
    }

    public RSA getRsa(){
        return rsa;
    }

    @PostMapping("/getPublicKey")
    public ResponseResult getPublicKey(){
        return ResponseResult.success(aPublic.getEncoded());
    }
}
