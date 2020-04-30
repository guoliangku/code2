package com.example.base;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletResponse;

/**
 * @program: code
 * @description: 封装Controller通过方法
 * @author: ThinkGem
 * @create: 2020-04-26 00:06
 **/
public class BaseController {

    /**
     * 响应页面数据
     * @param response
     * @param data
     */
    public void rendData(HttpServletResponse response, int code, int msg, Object data){
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        JSONObject obj = new  JSONObject();
        obj.put("code",code);
        obj.put("msg",msg);
        obj.put("count",5);
        obj.put("data",data);
        try {
            response.getWriter().print(obj.toJSONString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
