package com.hcx.oom.DirectMemory;


import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @ClassName DirectMemoryOOM
 * @Description 直接内存溢出，通过unsafe类进行内存分配，本机内存不足，则导致OOM
 * -Xmx20M -XX:MaxDirectMemorySize=10M
 * @Author 贺楚翔
 * @Date 2020-12-31 11:21
 * @Version 1.0
 **/
public class DirectMemoryOOM {
    private static int _1Mb = 1024*1024;
    public static void main(String[] args) throws Exception {
        Field declaredField = Unsafe.class.getDeclaredFields()[0];
        declaredField.setAccessible(true);
        Unsafe unSafe = (Unsafe) declaredField.get(null);
        while (true){
            unSafe.allocateMemory(_1Mb);
        }
    }
}
