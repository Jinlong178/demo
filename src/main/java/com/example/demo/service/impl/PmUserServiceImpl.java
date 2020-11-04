package com.example.demo.service.impl;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import com.example.demo.controller.RsaController;
import com.example.demo.entity.PmUser;
import com.example.demo.mapper.PmUserMapper;
import com.example.demo.service.IPmUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private RsaController rsaController;

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
            LocalDateTime creatTime = LocalDateTime.now();
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

    @Override
    public Map login(PmUser pmUser) {
        Map result = new HashMap();
        Map param = new HashMap();
        String name = pmUser.getName();
        String passWord = pmUser.getPassWord();
        RSA rsa = rsaController.getRsa();
        byte[] decrypt = rsa.decrypt(passWord, KeyType.PrivateKey);
        passWord = StrUtil.str(decrypt, CharsetUtil.CHARSET_UTF_8);
        param.put("NAME",name);
        List<PmUser> list = listByMap(param);
        if(list.size()>0){
            String pw = list.get(0).getPassWord();
            if(pw.equals(passWord)){
                result.put("msg","登录成功");
                result.put("code",1);
            }else{
                result.put("msg","密码错误");
                result.put("code",0);
            }

        }else{
            result.put("msg","用户名不存在");
            result.put("code",0);
        }
        return result;
    }


    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
    }
}
