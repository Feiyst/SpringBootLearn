package com.feiyst.springbootlearn.unit;

import java.io.Serializable;

/**
 * @author: feiyst
 * @modified by:
 * @description: 异常数据实体类
 * @create: 2018-12-18 14:32
 **/
public class Result<T> implements Serializable{

    private static final long serialVersionUID = 7156526077883281625L;

    private String code;
    private String message;
    private String url;
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
