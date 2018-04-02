package com.ustcck.utils;

import java.util.Random;

/**
 * Created by CaoKai on 2018/3/29 20:04.
 * Email:caokai@yijiahe.com
 */
public class KeyUtils {

    public static synchronized String genUniqueKey() {

        Random random = new Random();

        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
