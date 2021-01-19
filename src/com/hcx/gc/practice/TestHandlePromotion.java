package com.hcx.gc.practice;

/**
 * @ClassName testHandlePromotion
 * @Description 空间分配担保参数
 * VM参数：-Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails
 * -XX:SurvivorRatio=8 -XX:HandlePromotionFailure=true
 * 1.8该参数已不在
 * @Author 贺楚翔
 * @Date 2021-01-18 16:00
 * @Version 1.0
 **/
public class TestHandlePromotion {
    private static final int _1MB = 1024*1024;
    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3, allocation4, allocation5, allocation6, allocation7;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation1 = null;
        allocation4 = new byte[2 * _1MB];
        allocation5 = new byte[2 * _1MB];
        allocation6 = new byte[2 * _1MB];
        allocation4 = null;
        allocation5 = null;
        allocation6 = null;
        allocation7 = new byte[2 * _1MB];
    }
}
