package com.example.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.PmAttachment;
import com.example.demo.entity.ResponseResult;
import com.example.demo.service.impl.PmAttachmentServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author JinLong
 * @since 2020-11-04
 */
@RestController
@RequestMapping("/pm-attachment")
public class PmAttachmentController {

    @Autowired
    private PmAttachmentServiceImpl pmAttachmentService;

    @PostMapping("/getAttachment")
    public ResponseResult getAttachment(@RequestBody String id){
        PmAttachment byId = pmAttachmentService.getById(id);
        return ResponseResult.success(byId);
    }

}

