package com.hcx.oom.RuntimeConstantPool;

/**
 * @ClassName RuntimePool2
 * @Description 运行时常量池中关于String.intern()相等
 * @Author 贺楚翔
 * @Date 2020-12-31 9:05
 * @Version 1.0
 **/
public class RuntimePool2 {
    public static void main(String[] args) {
        String str1 = new StringBuilder("hcx").append("hgg").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuffer("hhh").toString();
        System.out.println(str2);
        System.out.println(str2.intern() == str2);
    }
}
