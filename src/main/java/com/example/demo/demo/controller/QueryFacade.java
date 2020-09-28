package com.example.demo.demo.controller;

import com.example.demo.demo.model.User;
import io.github.lvyahui8.spring.aggregate.facade.DataBeanAggregateQueryFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * @Author JinLong
 * @Date 2019/8/27 17:18
 * @Version 1.0
 */
@RestController
public class QueryFacade {
    @Autowired
    private DataBeanAggregateQueryFacade dataBeanAggregateQueryFacade;

    public User getUserFinal(String id) throws InterruptedException, IllegalAccessException, InvocationTargetException {
        return dataBeanAggregateQueryFacade.get("userFullData", Collections.singletonMap("id",id),User.class);
    }

}
