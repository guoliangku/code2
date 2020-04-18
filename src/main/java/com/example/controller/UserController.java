package com.example.controller;

import com.example.entity.UserEntity;
import com.example.service.UserService;
import com.example.util.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/web")
public class UserController {

    private static Logger log = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/save")
    public void save(){

        UserEntity userEntity = new UserEntity();
        userEntity.setId(StringUtils.getUUID());
        userEntity.setName("李四");
        userService.save(userEntity);
    }


}
