package com.hcx.oom.runtimeconstantpool;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName PoolOOM
 * @Description 运行常量池的OOM
 * -XX:PermSize=6M -XX:MaxPermSize=6M 在 jdk6及之前有用
 * jdk7以后，运行时常量池被移到堆内存中，上面的参数就不管用了
 * jdk7之后可以通过调整-Xmx 调整最大堆内存来限制运行时常量池大小，达到溢出  -Xmx6M
 * @Author 贺楚翔
 * @Date 2020-12-30 17:09
 * @Version 1.0
 **/
public class PoolOOM {
    public static void main(String[] args) {
        Set<String> strings = new HashSet<>();
        long i = 0;
        while (true) {
            strings.add(String.valueOf(i++).intern());
            System.out.println(strings);
        }
    }
}
