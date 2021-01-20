package com.hcx.analysis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName JConsole_TestJstack
 * @Description jconsole可视化工具对于jstack的测试，堆栈跟踪工具
 * 查看线程页，跟踪线程
 * @Author 贺楚翔
 * @Date 2021-01-20 10:48
 * @Version 1.0
 **/
public class JConsole_TestJstack {
    public static void createBusyThread(){
        final Thread busyThread = new Thread(() -> {
            while (true) {

            }
        }, "busyThread");
        busyThread.start();
    }

    public static void createLockThread(Object obj){
        final Thread lockThread = new Thread(() -> {
            synchronized (obj) {
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "lockThread");
        lockThread.start();
    }

    public static void main(String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        createBusyThread();
        reader.readLine();
        final Object o = new Object();
        createLockThread(o);
    }
}
