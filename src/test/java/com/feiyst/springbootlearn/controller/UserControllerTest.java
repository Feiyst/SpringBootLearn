package com.feiyst.springbootlearn.controller;

import com.alibaba.fastjson.JSON;
import com.feiyst.springbootlearn.unit.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Autowired
    UserController userController;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    public void testGetAllUser(){
        Result result = userController.getAllUser();
//        User result = userController.getAllUser();
        assertEquals("200", result.getCode().toString());
        assertEquals("success", result.getMessage());
        assertEquals("", JSON.toJSONString(result));

//        User user = new User();
//        user.setId("666666");
//        user.setPassword("123456");
//        user.setSlat("11111");
//        user.setUserName("feiyst");
//        ValueOperations<String, User> operations = redisTemplate.opsForValue();
//        operations.set("com.neox", user);
//        operations.set("com.neof", user, 1, TimeUnit.SECONDS);
//        Thread.sleep(1000);
//
//        boolean exits = redisTemplate.hasKey("com.neof");
//        if (exits) {
//            System.out.println("exits is true");
//        } else {}
//        System.out.println("exits is false");
    }
}