package org.bob.learn.rabbitmq.common.util;

import java.util.UUID;

public class CommonUtils {

    public static String uuid(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
