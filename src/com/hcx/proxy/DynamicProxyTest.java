package com.hcx.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName DynamicProxyTest
 * @Description 关于字节码生成技术-----动态代理
 * super.h.invoke  super.h是指本例中的DynamicProxy类，调用invoke方法，重新定位到具体代理类的指定方法
 * @Author 贺楚翔
 * @Date 2021-02-19 10:14
 * @Version 1.0
 **/
public class DynamicProxyTest {
    interface IHello{
        void sayHello();
    }
    static class Hello implements IHello{

        @Override
        public void sayHello() {
            System.out.println("Hello world");
        }
    }
    static class DynamicProxy implements InvocationHandler{
        Object oriObj;

        public Object bind(Object oriObj){
            this.oriObj = oriObj;
            return Proxy.newProxyInstance(oriObj.getClass().getClassLoader(),oriObj.getClass().getInterfaces(),this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("welcome");
            return method.invoke(oriObj,args);
        }
    }

    public static void main(String[] args) {
        //将动态生成在内存中的字节码输出为文件，可反编译查看class文件中具体内容
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        IHello hello = (IHello) new DynamicProxy().bind(new Hello());
        hello.sayHello();
    }
}
