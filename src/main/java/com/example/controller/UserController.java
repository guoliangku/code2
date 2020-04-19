package com.example.controller;

import com.example.entity.UserEntity;
import com.example.service.UserService;
import com.example.util.RedisUtils;
import com.example.util.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/web")
public class UserController {

    private static Logger log = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private RedisUtils redisUtils;

    private static final String rfg ="redis_config";

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

    /**'
     * 列表查询
     * @return
     */
    @RequestMapping(value = "/findMap",method = RequestMethod.GET)
    public Map<String,Object> findMap(){
        Map<String,Object> map = new HashMap<>();
        boolean hasKey = redisUtils.exists(rfg);
        if(hasKey){
            log.info("缓存信息存在");
            Object object = redisUtils.get(rfg);
            UserEntity userEntity = (UserEntity) object;
            map.put("map",userEntity);
        }else{
            log.info("缓存信息不存在");
            List<UserEntity> list = userService.findByUser();
            map.put("map",list);
        }
        return map;
    }

    /**
     * 根据id删除用户信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete/{id}")
    public Map<String,Object> delete(@PathVariable(value = "id") String id){
        Map<String,Object> map = new HashMap<>();
        int it =0;
        if(StringUtils.isEmpty(id)==false){
            //不为空，先清除redis缓存中的数据
       //     redisUtils.remove(id);
            it = userService.delete(id);
        }
        //删除失败
        if(it==-1){
            map.put("error","删除失败");
        }else if(it==0){
            map.put("success","删除成功");
        }else{
            map.put("error","服务异常");
        }
        return map;
    }


}
