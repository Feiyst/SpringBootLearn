package com.feiyst.springbootlearn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: feiyst
 * @modified by:
 * @description:
 * @create: 2019-01-27 10:48
 **/
@RestController
public class HelloWorld {

    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }
}
