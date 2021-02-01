package com.hcx.load;

/**
 * @ClassName FieldResolution
 * @Description 字段解析，当子类出现多个接口和父类时，解析字段时，会从继承关系从下往上解析相同
 * 符号引用，直接返回直接应用。
 * 下面例子，注释Sub类中的静态变量后，在编译时会出错，因为父接口和父类同时出现相同符号引用，无法找到唯一引用
 * @Author 贺楚翔
 * @Date 2021-01-29 16:31
 * @Version 1.0
 **/
public class FieldResolution {
    interface Interface0 {
        int A = 0;
    }
    interface Interface1 extends Interface0 {
        int A = 1;
    }
    interface Interface2 {
        int A = 2;
    }
    static class Parent implements Interface1 {
        public static int A = 3;
    }
    static class Sub extends Parent implements Interface2 {
        //注释后解析出错
        public static int A = 4;
    }
    public static void main(String[] args) {
        System.out.println(Sub.A);
    }
}
