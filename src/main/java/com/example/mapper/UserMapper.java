package com.example.mapper;

import com.example.entity.UserEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

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
    @Select("SELECT * FROM user ")
    List<UserEntity> findByUser();

    /**
     * 删除信息
     * @param id
     * @return
     */
    @Delete("delete from user where id =#{id}")
    boolean delete(@Param("id") String id);

    /**
     * 更新数据信息
     * @param userEntity
     * @return
     */
    @Delete("update user set name=#{name} where id =#{id}")
    boolean update(UserEntity userEntity);

    /**
     * 通过用户名称查询
     * @param name
     * @return
     */
    @Select("SELECT * FROM user where name=#{name}")
    List<UserEntity> findMapUser(@Param("name")String name);
}
