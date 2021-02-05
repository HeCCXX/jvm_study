package com.hcx.dynamic;

import java.lang.invoke.*;

/**
 * @ClassName InvokeDynamicTest
 * @Description invokeDynamic，需要使用indy工具javap来编译，可以查看到invokeDynamic动态指令
 * @Author 贺楚翔
 * @Date 2021-02-05 13:59
 * @Version 1.0
 **/
public class InvokeDynamicTest {
    public static void main(String[] args) throws Throwable {
        INDY_BootstrapMethod().invokeExact("hcx");
    }

    public static void testMethod(String s) {
        System.out.println("hello :" + s);
    }

    public static CallSite BootstrapMethod(MethodHandles.Lookup lookup, String name,
                                           MethodType mt) throws NoSuchMethodException,
                                                          IllegalAccessException {
        return new ConstantCallSite(lookup.findStatic(InvokeDynamicTest.class, name, mt));
    }

    private static MethodType MT_BootstrapMethod(){
        return MethodType.fromMethodDescriptorString("(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;", null);
    }

    private static MethodHandle MH_BootstrapMethod() throws NoSuchMethodException, IllegalAccessException {
        return MethodHandles.lookup().findStatic(InvokeDynamicTest.class,"BootstrapMethod",MT_BootstrapMethod());
    }

    private static MethodHandle INDY_BootstrapMethod() throws Throwable {
        CallSite cs = (CallSite) MH_BootstrapMethod().invokeWithArguments(MethodHandles.lookup(), "testMethod",
                MethodType.fromMethodDescriptorString("(Ljava/lang/String;)V", null));
        return cs.dynamicInvoker();
    }
}
