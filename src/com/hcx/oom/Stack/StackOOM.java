package com.hcx.oom.Stack;

/**
 * @ClassName StackOOM
 * @Description 栈内存溢出
 * @Author 贺楚翔
 * @Date 2020-12-30 15:21
 * @Version 1.0
 **/
public class StackOOM {
    private int stackLength = 0;
    public void stackLeak(){
        stackLength++;
        stackLeak();
    }
    public static void main(String[] args) throws Throwable {
        final StackOOM stackOOM = new StackOOM();
        try {
            stackOOM.stackLeak();
        } catch (Throwable e) {
            System.out.println("Stack length:"+ stackOOM.stackLength);
            throw e;
        }
    }
}
