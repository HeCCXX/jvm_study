package com.hcx.load;

import java.sql.SQLOutput;

/**
 * @ClassName ClazzLoad
 * @Description 不触发类初始化的例子
 * #1 被动引用，不会导致子类初始化加载 -XX:+TraceClassLoading 可以通过该参数导致类初始化加载
 * #2 定义对象数组来引用，不会初始化此类
 * #3 常量定义时直接进入调用类的常量池中，引用常量时不初始化对象
 * @Author 贺楚翔
 * @Date 2021-01-28 16:22
 * @Version 1.0
 **/
class SuperClass {
    static {
        System.out.println("SuperInit");
    }
    public static int value = 123;
    public static final String str = "hcx";
}

class SubClass extends SuperClass {
    static {
        System.out.println("SubInit");
    }
}

public class ClazzLoad {
    public static void main(String[] args) {
        //#1 子类引用父类的静态字段，不初始化
//        System.out.println(SubClass.value);
        //#2 定义对象数组，不初始化
//        SuperClass[] arr = new SuperClass[10];
        //#3 常量定义时直接进入调用类的常量池中，引用常量时不初始化对象
        System.out.println(SubClass.str);
    }

}
