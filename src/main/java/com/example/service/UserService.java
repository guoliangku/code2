package com.example.service;

import com.example.entity.UserEntity;

public interface UserService {

    /**
     * 保存信息
     * @param userEntity
     * @return
     */
    void save(UserEntity userEntity);
}
