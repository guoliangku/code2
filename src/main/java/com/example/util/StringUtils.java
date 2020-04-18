package com.example.util;

import java.util.UUID;

public class StringUtils {

    /**
     * 生成主键序列号
     * @return
     */
    public static String  getUUID(){
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        return str;
    }
}
