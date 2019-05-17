package com.feiyst.springbootlearn.annotation;

import java.lang.annotation.*;

/**
 * @author: feiyst
 * @modified by:
 * @description: Description自定义注解
 * @create: 2019-02-21 09:52
 **/

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Description {
    String desc();
    String author();
    int code() default 100;
}
