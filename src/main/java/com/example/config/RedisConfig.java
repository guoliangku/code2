package com.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import java.util.HashMap;

/**
 * @program: code
 * @description: Redis配置实体类
 * @author: ThinkGem
 * @create: 2020-04-19 12:20
 **/
@Component
@ConfigurationProperties(prefix = "spring.redis")
public class RedisConfig {

    /**
     * ip地址
     */
    private String host;

    /**
     * 端口
     */
    private int port;

    /**
     * 时间（秒）
     */
    private int timeout;

    /**
     * 密码
     */
    private String password;

    /**
     * pool
     */
    private HashMap<String,String> pool = new HashMap<>();

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HashMap<String, String> getPool() {
        return pool;
    }

    public void setPool(HashMap<String, String> pool) {
        this.pool = pool;
    }
}
