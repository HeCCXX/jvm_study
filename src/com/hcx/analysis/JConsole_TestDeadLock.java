
package com.hcx.analysis;

/**
 * @ClassName JConsole_TestDeadLock
 * @Description jconsole工具查看死锁
 * @Author 贺楚翔
 * @Date 2021-01-20 13:32
 * @Version 1.0
 **/
public class JConsole_TestDeadLock {
    static class SyncObject implements Runnable{
        int a,b;

        public SyncObject(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            synchronized (Integer.valueOf(a)){
                synchronized (Integer.valueOf(b)){
                    System.out.println(a+b);
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new SyncObject(1, 2)).start();
            new Thread(new SyncObject(2,1)).start();
        }
    }
}
