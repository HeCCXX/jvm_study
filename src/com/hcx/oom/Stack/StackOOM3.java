package com.hcx.oom.Stack;

/**
 * @ClassName StackOOM3
 * @Description 通过创建线程来占用空间，操作系统层面，每个进程最大可获取2G内存
 * -Xss2M
 * @Author 贺楚翔
 * @Date 2020-12-30 15:52
 * @Version 1.0
 **/
public class StackOOM3 {

    public void stackLeakByThread(){
        while (true){
            final Thread thread = new Thread(() -> {
                while (true) {

                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        final StackOOM3 stackOOM3 = new StackOOM3();
        try {
            stackOOM3.stackLeakByThread();
        }catch (Throwable e){
            throw e;
        }
    }
}
