package com.example.demo.service.impl;

import com.example.demo.entity.PmUser;
import com.example.demo.mapper.PmUserMapper;
import com.example.demo.service.IPmUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Something
 * @since 2020-10-28
 */
@Service
public class PmUserServiceImpl extends ServiceImpl<PmUserMapper, PmUser> implements IPmUserService {

}
