package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.base.BaseController;
import com.example.entity.UserEntity;
import com.example.service.UserService;
import com.example.util.RedisUtils;
import com.example.util.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;


@RestController
@RequestMapping("/web")
public class UserController extends BaseController {

    private static Logger log = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private RedisUtils redisUtils;

    private static final String rfg ="redis_users3333";

    @RequestMapping("/save")
    public String save(UserEntity userEntity){
        userEntity.setId(StringUtils.getUUID());

        JSONObject obj = new JSONObject();
        try {
            userService.save(userEntity);
            obj.put("code",0);
        }catch (Exception e){
            obj.put("code",1);
        }
        return obj.toJSONString();

    }


    /**\
     * 列表加载数据
     * @param request
     * @param
     */
    @RequestMapping(value = "/loadData")
    public void loadData(HttpServletRequest request, HttpServletResponse response){
        List<UserEntity> list = userService.findByUser();
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        Map<String,Object> map = new HashMap<>();
        boolean hasKey = redisUtils.exists(rfg);
        if(hasKey){
            Set<Object> set =  redisUtils.setMembers(rfg);
            //迭代
            map.put("map",set);

            log.info("从缓存中读取数据为："+map+"和"+map);
            rendData(response,0,1,set);
            }


        if(!list.isEmpty()){
            try {
                rendData(response,0,1,list);
            }catch (Exception e){
                e.printStackTrace();
            }

        }

    }

    /**
     * 删除数据
     * @param id
     * @param response
     */
    @RequestMapping(value = "/delete")
    public String delete(String id,HttpServletResponse response){

        JSONObject obj = new  JSONObject();
        obj.put("msg","删除成功");
        try {
            userService.delete(id);
            obj.put("code",0);
        }catch (Exception  e){
            e.printStackTrace();
        }

        return obj.toJSONString();

    }




    /**
     * 登录
     * @param name
     * @param password
     * @return
     */
    @RequestMapping(value = "/login")
    public String login(String name, String password, ModelMap model){

      /*  //1.获取Subject
        Subject subject = SecurityUtils.getSubject();

        //2.封装数据信息
        UsernamePasswordToken token = new UsernamePasswordToken(name,password);

        //执行登录方法
        try {
            subject.login(token);
        }catch (UnknownAccountException e){
            //用户名信息错误
            model.addAttribute("msg","用户名信息错误");
            return "/login";
        }catch (IncorrectCredentialsException e){
            //密码信息错误
            model.addAttribute("msg","密码信息错误");
            return "/login";
        }*/
        JSONObject obj = new JSONObject();

        List<UserEntity> list = userService.findMapUser(name);
        if(!list.isEmpty()){
            obj.put("code",0);
        }else{
            obj.put("code",1);
        }

        return obj.toJSONString();
    }
}
