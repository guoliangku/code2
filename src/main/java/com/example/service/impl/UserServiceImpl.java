package com.example.service.impl;
import com.example.service.UserService;
import com.example.util.Constant;
import org.apache.log4j.Logger;
import com.example.entity.UserEntity;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static Logger log = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public void save(UserEntity userEntity) {
        if (userEntity!=null){
            log.info("开始插入数据");
            userMapper.save(userEntity);
        }
    }

    @Override
    public List<UserEntity> findByUser() {
        return userMapper.findByUser();
    }

    @Override
    public int delete(String id) {
        boolean flag = userMapper.delete(id);
        if(flag==false){
            return 0;
        }else{
            return -1;
        }
    }

    @Override
    public int update(UserEntity userEntity) {
        boolean flag = userMapper.update(userEntity);
        if(flag==false){
            return 0;
        }else{
            return -1;
        }
    }
}
