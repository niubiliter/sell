package com.huangliusong.utils;

import java.util.Random;

/**
 * Created by huangliusong on 2017/8/13.
 */
public class KeyUtil {
    /**
     * 生成唯一的订单号
     * 格式：时间+随机数
     */
    public  static synchronized String genUniqueKey(){
        Random random=new Random();
        //当前毫秒数
        System.currentTimeMillis();
        //随机数 生成了六位的随机数
        Integer number=random.nextInt(900000)+100000;
        return System.currentTimeMillis()+String.valueOf(number);
    }
}
