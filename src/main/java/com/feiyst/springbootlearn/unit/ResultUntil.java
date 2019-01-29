package com.feiyst.springbootlearn.unit;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author: feiyst
 * @modified by:
 * @description: 调用结果返回方法工具类
 * @create: 2018-12-18 16:03
 **/
public class ResultUntil {

    /**
     * 成功的回调
     * @param object
     * @return
     */
    public static Result success(Object object) {
        Result result = new Result();
        result.setCode("200");
        result.setMessage("success");
        result.setData(JSON.toJSONString(object));
        return result;
    }

    /**
     * 成功回调(无参)
     * @return
     */
    public static Result success() {
        return success(null);
    }

    /**
     * 自定义错误信息(自定义方式)
     * @param code
     * @param msg
     * @return
     */
    public static Result error(String code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMessage(msg);
        result.setData(null);
        return result;
    }

    /**
     * 返回异常信息，在已知的范围内(走枚举方式)
     * @param exceptionEnum
     * @return
     */
//    public static Result error(ExceptionEnum exceptionEnum){
//        Result result = new Result();
//        result.setCode(exceptionEnum.getCode());
//        result.setMessage(exceptionEnum.getMsg());
//        result.setData(null);
//        return result;
//    }
}
