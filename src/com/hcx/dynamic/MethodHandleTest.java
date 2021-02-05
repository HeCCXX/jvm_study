package com.hcx.dynamic;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @ClassName MethodHandleTest
 * @Description 动态类型
 * Reflection 和 MethodHandle机制本质上都是对方法的调用
 * Reflection：针对代码层面上的调用，包含方法的签名、描述符、方法属性表等运行期信息，重量级
 * MethodHandle：模拟字节码层面的调用，仅包含执行方法的信息，轻量级
 * @Author 贺楚翔
 * @Date 2021-02-05 10:07
 * @Version 1.0
 **/
public class MethodHandleTest {
    static class ClassA{
        public void println(String s){
            System.out.println(s);
        }
    }

    public static void main(String[] args) throws Throwable {
        Object obj = System.currentTimeMillis() % 2 ==0 ? System.out : new ClassA();
        getPrintlnMH(obj).invokeExact("hcx");
    }

    private static MethodHandle getPrintlnMH(Object obj) throws NoSuchMethodException, IllegalAccessException {
        // MethodType：代表“方法类型”，包含了方法的返回值（methodType()的第一个参数）和具体参数（methodType()第二个及以后的参数）。
        final MethodType methodType = MethodType.methodType(void.class, String.class);
        //lookup 是methodhandles静态方法，这句的作用是在指定类中查找符合给定的方法名称、方法类型，并且符合调用权限的方法句柄。
        // findVirtual模拟了invokevirtual指令
        return MethodHandles.lookup().findVirtual(obj.getClass(),"println",methodType).bindTo(obj);
    }
}
