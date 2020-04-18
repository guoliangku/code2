package com.example.mapper;

import com.example.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    /**
     * 保存信息
     * @param userEntity
     * @return
     */
    void save(UserEntity userEntity);
}
