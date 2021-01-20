package com.hcx.analysis;

import java.util.ArrayList;

/**
 * @ClassName JConsole_TestCase
 * @Description jConsole可视化工具使用，查看内存使用及监控
 * VM参数：-Xms100m -Xmx100m -XX:+UseSerialGC
 * @Author 贺楚翔
 * @Date 2021-01-20 9:54
 * @Version 1.0
 **/
public class JConsole_TestCase {
    private static final byte[] OBJ_SIZE = new byte[64 * 1024];

    public static void fillHeap() throws InterruptedException {
        ArrayList<JConsole_TestCase> jConsole_testCases = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Thread.sleep(50);
            jConsole_testCases.add(new JConsole_TestCase());
        }
        System.gc();
    }

    public static void main(String[] args) throws InterruptedException {
        fillHeap();
//        System.gc();
    }
}
