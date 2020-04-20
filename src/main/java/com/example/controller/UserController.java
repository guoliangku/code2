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
import java.util.Set;


@RestController
@RequestMapping("/web")
public class UserController {

    private static Logger log = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private RedisUtils redisUtils;

    private static final String rfg ="redis_config_lk";

    @RequestMapping("/save")
    public void save(){
        UserEntity userEntity = new UserEntity();
        userEntity.setId("2615f3ff-245a-433a-a021-22bd91db9a06");
        userEntity.setName("王五444");

        //boolean flag = redisUtils.set(rfg,userEntity);
        redisUtils.add(rfg,userEntity);
        /**
         * 判断缓存中是否存在
         */
        boolean hasKey = redisUtils.exists(rfg);
        if(hasKey){
            /**
             * 从缓存中读取数据
             */
            Set<Object> set =  redisUtils.setMembers(rfg);
            //转换
            log.info("从缓存中读取数据为："+set+"和"+set);
        }
        /*if(flag){
            log.info("添加缓存成功");
            userService.save(userEntity);
        }*/

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
            Set<Object> setMembers = redisUtils.setMembers(rfg);
            map.put("map",setMembers);
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
        redisUtils.remove(rfg);
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
