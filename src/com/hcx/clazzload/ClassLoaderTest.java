package com.hcx.clazzload;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName ClassLoaderTest
 * @Description 类加载器与instanceof关键字的演示
 * java 虚拟机中存在着两个ClassLoaderTest对象，一个是由应用程序类加载器所加载，另一个是由用户自定义的加载器所加载
 * 所以instanceof关键字判断为false
 * @Author 贺楚翔
 * @Date 2021-02-01 15:22
 * @Version 1.0
 **/
public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        final ClassLoader myClassLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    final String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    final InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    final byte[] bytes = new byte[is.available()];
                    is.read(bytes);
                    return defineClass(name, bytes, 0, bytes.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };
        final Object newInstance = myClassLoader.loadClass("com.hcx.clazzload.ClassLoaderTest").newInstance();
        System.out.println(newInstance.getClass());
        System.out.println(newInstance instanceof com.hcx.clazzload.ClassLoaderTest);
        System.out.println(newInstance.getClass().getClassLoader());
        System.out.println(ClassLoaderTest.class.getClassLoader());
        System.out.println(Object.class.getClassLoader());
    }
}
/**
* 输出结果:
 class com.hcx.clazzload.ClassLoaderTest
 false
**/
