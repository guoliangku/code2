package com.example.service;

import com.example.entity.UserEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

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
    int delete(@Param("id") String id);

    /**
     * 更新数据信息
     * @param userEntity
     * @return
     */
    int update(UserEntity userEntity);

    /**
     * 通过用户名称查询
     * @param name
     * @return
     */
    List<UserEntity> findMapUser(@Param("name") String name);

}
