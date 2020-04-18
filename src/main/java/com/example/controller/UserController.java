package com.example.controller;

import com.example.entity.UserEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserController {

    public static void main(String[] arg0){
        System.out.print("1111");

        ApplicationContext ctx = new AnnotationConfigApplicationContext(UserEntity.class);


    }
}
