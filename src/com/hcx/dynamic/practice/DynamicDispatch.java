package com.hcx.dynamic.practice;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;

/**
 * @ClassName DynamicDispatch
 * @Description 方法分派实战
 * 在Son类方法中调用Grandfather的方法输出，但是存在缺陷，子类只能访问直接父类的方法，1.7版本后修复了该问题
 * @Author 贺楚翔
 * @Date 2021-02-05 15:45
 * @Version 1.0
 **/
public class DynamicDispatch {
    static class GrandFather {
        void thinking() throws Throwable {
            System.out.println("I am grandfather");
        }
    }

    static class Father extends GrandFather {
        @Override
        void thinking() throws Throwable {
            System.out.println("I am father");
        }
    }

    static class Son extends Father {
        @Override
        void thinking() throws Throwable {
            final MethodType methodType = MethodType.methodType(void.class);
            //            Field implLookup = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
            //            implLookup.setAccessible(true);
            //            MethodHandle methodHandle = ((MethodHandles.Lookup)implLookup.get(null)).findSpecial(GrandFather.class, "thinking", methodType, getClass());
            final MethodHandle methodHandle = MethodHandles.lookup().findSpecial(GrandFather.class,
                "thinking", methodType, getClass());
            methodHandle.invoke(this);
        }
    }

    public static void main(String[] args) throws Throwable {
        final Son son = new Son();
        son.thinking();
    }
}
