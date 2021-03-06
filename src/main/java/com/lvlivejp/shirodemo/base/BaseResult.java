package com.lvlivejp.shirodemo.base;

import com.fasterxml.jackson.annotation.JsonInclude;

public class BaseResult<T> {

    /**
     * 代码
     **/
    public String code;

    /**
     * 错误信息
     **/
    public String message;

    @JsonInclude(value= JsonInclude.Include.NON_NULL)
    public T t;

    @Override
    public String toString() {
        return "BaseResult{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", t=" + t +
                '}';
    }

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

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
