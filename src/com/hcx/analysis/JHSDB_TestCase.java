package com.hcx.analysis;

/**
 * @ClassName JHSDB_TestCase
 * @Description 可视化工具分析 HSDB  JDK 9 支持命令
 * jdk 8 需要使用sa-jdi 包
 * java -classpath "C:\Program Files\Java\jdk1.8.0_231\lib\sa-jdi.jar" sun.jvm.hotspot.HSDB
 * vm 参数 ：-Xmx10m -XX:+UseSerialGC -XX:-UseCompressedOops
 * @Author 贺楚翔
 * @Date 2021-01-19 16:18
 * @Version 1.0
 **/
public class JHSDB_TestCase {

    static class Test {
        static ObjectHolder staticObject = new ObjectHolder();
        ObjectHolder        instanceObj  = new ObjectHolder();

        void foo() {
            ObjectHolder localObj = new ObjectHolder();
            System.out.println("done");
        }
    }

    public static class ObjectHolder {
    }

    public static void main(String[] args) {
        final Test test = new Test();
        test.foo();
    }
}
