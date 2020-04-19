package com.example.controller;

import com.example.entity.UserEntity;
import com.example.service.UserService;
import com.example.util.RedisUtils;
import com.example.util.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/web")
public class UserController {

    private static Logger log = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private RedisUtils redisUtils;

    private static final String rfg ="redis_config_oppp2222ppsss";

    @RequestMapping("/save")
    public void save(){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(StringUtils.getUUID());
        userEntity.setName("张三9932222");

        boolean flag = redisUtils.set(rfg,userEntity);

        /**
         * 判断缓存中是否存在
         */
        boolean hasKey = redisUtils.exists(rfg);
        if(hasKey){
            /**
             * 从缓存中读取数据
             */
            Object object = redisUtils.get(rfg);
            //转换
            UserEntity userEntitys = (UserEntity) object;
            log.info("从缓存中读取数据为："+userEntitys.getName()+"和"+userEntitys.getId());
        }
        if(flag){
            log.info("添加缓存成功");
            userService.save(userEntity);
        }

    }


}
