package com.feiyst.springbootlearn.controller;

import com.feiyst.springbootlearn.dao.mapping.UserMapper;
import com.feiyst.springbootlearn.dao.model.User;
import com.feiyst.springbootlearn.dao.model.UserExample;
import com.feiyst.springbootlearn.unit.Result;
import com.feiyst.springbootlearn.unit.ResultUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: feiyst
 * @modified by:
 * @description:
 * @create: 2019-01-27 15:25
 **/
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping(value = "/getAllUser")
    @Cacheable(value = "userController", keyGenerator="keyGenerator")
    public Result getAllUser() {
        UserExample example = new UserExample();
        example.createCriteria().andIdIsNotNull();
        List<User> list = userMapper.selectByExample(example);
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return ResultUntil.success(list);
    }

    @DeleteMapping(value = "/del")
//    @CacheEvict(value = "userController", keyGenerator = "keyGenerator")
    public Result getAllUser1() {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

//        redisTemplate.opsForList().leftPush("myList", 1,2,3,4);
        redisTemplate.opsForList().leftPushAll("helloworld", 1, 2,3,4,5);
        System.out.println(redisTemplate.opsForList().range("helloworld", 0, -1));
        return ResultUntil.success("消息队列!");
    }
}
