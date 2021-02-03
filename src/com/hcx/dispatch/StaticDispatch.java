
package com.hcx.dispatch;

import java.util.Random;

/**
 * @ClassName StaticDispatch
 * @Description 方法静态分配，Human称为变量的静态类型  Man和Woman称为实际类型
 * 在编译期间得到的是静态类型，运行时才能确定实际类型
 * 如下#2处代码，运行时强行转换类型，才确定了实际类型，而强制转换在编译时就可以明确转型的是Man还是Woman
 * @Author 贺楚翔
 * @Date 2021-02-02 13:49
 * @Version 1.0
 **/
public class StaticDispatch {
    static abstract class Human {
    }

    static class Man extends Human {
    }

    static class Woman extends Human {
    }

    public void sayHello(Human man) {
        System.out.println("hello,guy");
    }

    public void sayHello(Man man) {
        System.out.println("hello,man");
    }

    public void sayHello(Woman man) {
        System.out.println("hello,Woman");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();

        //#2
        Human human = new Random().nextBoolean() ? new Man() : new Woman();
        final StaticDispatch staticDispatch = new StaticDispatch();
        staticDispatch.sayHello(man);
        staticDispatch.sayHello(woman);
        //#2
        staticDispatch.sayHello((Man) human);
        staticDispatch.sayHello((Woman) human);
    }
}

/** 运行结果：
     hello,guy
     hello,guy
**/