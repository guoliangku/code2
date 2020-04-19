package com.example.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @program: code
 * @description: 封装获取连接池类
 * @author: ThinkGem
 * @create: 2020-04-19 12:29
 **/
@Configuration
public class RedisPoolFactory{

    private static Logger log = Logger.getLogger(RedisPoolFactory.class);

    @Autowired
    private RedisConfig rcf;

    @Bean
    public JedisPool getJedisPool(){
        JedisPoolConfig jplf = new JedisPoolConfig();
        String password = "123456";
       // Integer minIdle = Integer.parseInt(rcf.getPool().get("minIdle"));
        Integer minIdle =1;
        jplf.setMinIdle(minIdle);
        log.info("reids最大空闲数，数据库连接的最大空闲时间："+minIdle);

        //Integer maxIdle = Integer.parseInt(rcf.getPool().get("maxIdle"));
        Integer maxIdle =10;
        jplf.setMaxIdle(maxIdle);
        log.info("reids最大等待连接中的数量,："+maxIdle);

       // Integer maxWait = Integer.parseInt(rcf.getPool().get("maxWait"))* 1000; //注意单位是ms，要转换单位
        Integer maxWait =3;
        jplf.setMaxWaitMillis(maxWait);
        log.info("reids最大等待毫秒数, 单位为 m："+maxWait);

       // Integer maxActive = Integer.parseInt(rcf.getPool().get("maxActive"));
        Integer maxActive =8;
        jplf.setMaxTotal(maxActive);
        log.info("reids最大连接数："+maxActive);

        JedisPool jedisPool = new JedisPool(jplf,"127.0.0.1",6379,3*1000,"123456",0);

        return jedisPool;
    }


}
