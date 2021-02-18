package com.hcx.interpreter;

/**
 * @ClassName StackInterpreter
 * @Description 基于栈的解释器---执行过程
 * @Author 贺楚翔
 * @Date 2021-02-18 15:30
 * @Version 1.0
 **/
public class StackInterpreter {
    public int calc(){
        int a = 100;
        int b = 200;
        int c = 300;
        return (a+b)*c;
    }
    public static void main(String[] args) {

    }
}
/**  javap -verbose StackInterpreter.class 输出：
 Code:
 stack=2, locals=4, args_size=1  深度为2的操作数栈和4个变量槽
 0: bipush        100
 2: istore_1
 3: sipush        200
 6: istore_2
 7: sipush        300
 10: istore_3
 11: iload_1
 12: iload_2
 13: iadd
 14: iload_3
 15: imul
 16: ireturn
**/
