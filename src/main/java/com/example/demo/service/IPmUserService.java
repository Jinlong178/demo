package com.example.demo.service;

import com.example.demo.entity.PmUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Something
 * @since 2020-10-28
 */
public interface IPmUserService extends IService<PmUser> {

    Map register(PmUser pmUser);

    Map login(PmUser pmUser);

}
