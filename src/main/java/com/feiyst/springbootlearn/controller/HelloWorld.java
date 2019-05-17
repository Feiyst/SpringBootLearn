package com.feiyst.springbootlearn.controller;

import com.feiyst.springbootlearn.annotation.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author: feiyst
 * @modified by:
 * @description:
 * @create: 2019-01-27 10:48
 **/
@RestController
@Description(desc = "This is feiyst annotation class", author = "feiyst", code = 200)
public class HelloWorld {

    protected static final Logger log = LoggerFactory.getLogger(HelloWorld.class);

    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }

    /**
     * 自定义注解测试方法
     * @return
     */
    @Description(desc = "This is feiyst annotation method", author = "descAnnotation", code = 300)
    public String descAnnotation() {
        return "annotation";
    }


    @RequestMapping(value = "/analysis")
    public void annotationAnalysis() throws ClassNotFoundException {
        Class c = Class.forName("com.feiyst.springbootlearn.controller.HelloWorld");
        Boolean result = c.isAnnotationPresent(Description.class);
        if (result) {
            Description description = (Description) c.getAnnotation(Description.class);
            log.info("开始解析Description注解");
            log.info(description.desc());
            log.info(description.author());
            log.info(String.valueOf(description.code()));
            log.info("解析Description注解结束");
        }

        Method[] methods = c.getMethods();
        for (Method m : methods) {
            Annotation[] as = m.getAnnotations();
            for (Annotation a : as) {
                if (a instanceof Description) {
                    Description d = (Description) a;
                    log.info("开始解析方法注解");
                    log.info(d.desc());
                    log.info(d.author());
                    log.info(String.valueOf(d.code()));
                    log.info("解析方法注解结束");
                }
            }
        }
    }
}
