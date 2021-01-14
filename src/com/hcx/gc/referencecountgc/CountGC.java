package com.hcx.gc.referencecountgc;

/**
 * @ClassName CountGC
 * @Description 引用计数器，通过它来计算对象的引用数是否为0，为0就垃圾回收
 * 但在java中，不会只使用引用计数器法，因为存在循环引用的情况
 * @Author 贺楚翔
 * @Date 2020-12-31 13:52
 * @Version 1.0
 **/
public class CountGC {
    public Object instance = null;
    static void testGC(){
        CountGC countGC1 = new CountGC();
        CountGC countGC2 = new CountGC();
        countGC1.instance = countGC2;
        countGC2.instance = countGC1;

        countGC1 = null;
        countGC2 = null;

        System.gc();
    }

    public static void main(String[] args) {
        testGC();
    }
}
