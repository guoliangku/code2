package com.example.service.impl;
import com.example.service.UserService;
import org.apache.log4j.Logger;
import com.example.entity.UserEntity;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
}
