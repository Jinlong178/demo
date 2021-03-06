package com.example.demo.service.impl;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.controller.RsaController;
import com.example.demo.entity.PmAttachment;
import com.example.demo.entity.PmUser;
import com.example.demo.mapper.PmUserMapper;
import com.example.demo.service.IPmUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
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

    @Autowired
    private PmAttachmentServiceImpl pmAttachmentService;

    @Override
    public Map register(PmUser pmUser) {
        String phone = pmUser.getPhone();
        Map map = new HashMap();
        map.put("PHONE",phone);
        List<PmUser> list = listByMap(map);
        Map result = new HashMap();
        QueryWrapper<PmUser> qw = new QueryWrapper<>();
        qw.eq("name",pmUser.getName());
        Map<String, Object> byName = getMap(qw);
        if (byName!=null){
            result.put("msg","该用户名已存在");
            result.put("code",0);
            return result;
        }
        if(list.size()>0){
            result.put("msg","该手机号已注册");
            result.put("code",0);
            return result;
        }else{
            LocalDateTime creatTime = LocalDateTime.now();
            pmUser.setCreatTime(creatTime);
            pmUser.setDel(0);
            //分配初始头像
            pmUser.setImg("01c9fc5c1267fc4a0ee87f7e6601861c");
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
                PmUser pmUser1 = list.get(0);
                result.put("msg","登录成功");
                result.put("code",1);
                result.put("user",pmUser1);
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
