package com.example.service;

import com.example.entity.UserEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {

    /**
     * 保存信息
     * @param userEntity
     * @return
     */
    void save(UserEntity userEntity);

    /**
     * 获取所有用户列表信息
     * @return
     */
    List<UserEntity> findByUser();

    /**
     * 删除信息
     * @param id
     * @return
     */
    @Delete("delete from user where id =#{id}")
    int delete(@Param("id") String id);

    /**
     * 更新数据信息
     * @param userEntity
     * @return
     */
    @Delete("update user set name=#{name} where id =#{id}")
    int update(UserEntity userEntity);

}
