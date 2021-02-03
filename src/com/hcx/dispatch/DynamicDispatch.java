package com.hcx.dispatch;

/**
 * @ClassName DynamicDispatch
 * @Description 动态分派  -- 重写
 * 在运行期间根据实际类型确定方法执行版本的分派过程
 * invokevirtual 获取到实际类型，然后根据实际类型查找方法版本
 * @Author 贺楚翔
 * @Date 2021-02-02 14:18
 * @Version 1.0
 **/
public class DynamicDispatch {
    static abstract class Human{
        protected void sayHello() {
        }
    }
    static class Man extends Human{
        @Override
        protected void sayHello() {
            System.out.println("hello man");
        }
    }
    static class Woman extends Human{
        @Override
        protected void sayHello() {
            System.out.println("hello woman");
        }
    }
    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        man.sayHello();
        woman.sayHello();
        man  = new Woman();
        man.sayHello();
    }
}
