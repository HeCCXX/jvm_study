package com.hcx.oom.methodarea;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName MethodAreaOOM
 * @Description TODO
 * @Author 贺楚翔
 * @Date 2020-12-31 9:38
 * @Version 1.0
 **/
public class MethodAreaOOM {
    public static void main(String[] args) {
        while (true) {
            final Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(ClassA.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invoke(o,objects);
                }
            });
            enhancer.create();
        }
    }
    static class ClassA{

    }
}
