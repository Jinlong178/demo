package com.example.demo.controller;


import com.example.demo.service.IPmSecMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.sql.Wrapper;

/**
 * <p>
 * 菜单表 前端控制器
 * </p>
 *
 * @author Something
 * @since 2020-10-14
 */
@RestController
@RequestMapping("/api/menu")
public class PmSecMenuController {
    @Autowired
    private IPmSecMenuService iPmSecMenuService;


    public void testSql(){

    }

}

