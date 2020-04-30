package com.example.util;

/**
 * @program: code
 * @description: 响应数据基类
 * @author: ThinkGem
 * @create: 2020-04-23 21:35
 **/
public class BaseResponse {

    /**响应编码*/
    private int code;

    /**响应消息*/
    private String msg;

    public BaseResponse() {
        super();
    }

    public BaseResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
