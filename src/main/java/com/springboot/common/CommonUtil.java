package com.springboot.common;

import java.util.UUID;

public class CommonUtil {

    /**
     * 获取随机字符串
     * @return 去掉“-”符号
     */
    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        return str.replace("-", "");
    }

    /**
     * 获取指定位数的字符串
     * @param num 个数
     * @return String
     */
    public static String getUUID(int num)
    {
        String uuid= UUID.randomUUID().toString();
        char[] cs=new char[num * 2];
        char c=0;
        for(int i=uuid.length()/2,j=1;i-->0;){
            if((c=uuid.charAt(i))!='-'){
                cs[j++]=c;
            }
        }
        return String.valueOf(cs).trim();
    }
}
