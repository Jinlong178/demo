package com.example.demo.service.impl;

import cn.hutool.core.convert.Convert;
import com.example.demo.entity.PmUser;
import com.example.demo.mapper.PmUserMapper;
import com.example.demo.service.IPmUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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



    @Override
    public Map register(PmUser pmUser) {
        String phone = pmUser.getPhone();
        Map map = new HashMap();
        map.put("PHONE",phone);
        List<PmUser> list = listByMap(map);
        Map result = new HashMap();
        if(list.size()>0){
            result.put("msg","该手机号已注册");
            result.put("code",0);
            return result;
        }else{
            LocalDateTime creatTime = Convert.toLocalDateTime(new Date());
            pmUser.setCreatTime(creatTime);
            pmUser.setDel(0);
            boolean save = save(pmUser);
            if(save){
                result.put("msg","注册成功");
                result.put("code",1);
                return result;
            }else{
                result.put("msg","注册失败");
                result.put("code",0);
                return result;
            }

        }

    }
}
