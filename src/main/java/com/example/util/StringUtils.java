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

    /**
     * 判断字符是否空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        if(str==null || "".equals(str)){
            return true;
        }else {
            return false;
        }
    }
}
