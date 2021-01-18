package com.hcx.gc.practice;

/**
 * @ClassName MinorGCTest
 * @Description 对象在eden分配
 * VM 参数  -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * @Author 贺楚翔
 * @Date 2021-01-15 16:39
 * @Version 1.0
 **/
public class MinorGCTest {
    private static final int _1MB = 1024 * 1024;
    public static void main(String[] args) {
        byte[] allocation1,allocation2,allocation3,allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];
    }
}
/**
 [GC (Allocation Failure) [DefNew: 6235K->659K(9216K), 0.0041216 secs] 6235K->4755K(19456K), 0.0046239 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
 Heap
 def new generation   total 9216K, used 7041K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
 eden space 8192K,  77% used [0x00000000fec00000, 0x00000000ff23b5d8, 0x00000000ff400000)
 from space 1024K,  64% used [0x00000000ff500000, 0x00000000ff5a4e90, 0x00000000ff600000)
 to   space 1024K,   0% used [0x00000000ff400000, 0x00000000ff400000, 0x00000000ff500000)
 tenured generation   total 10240K, used 4096K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
 the space 10240K,  40% used [0x00000000ff600000, 0x00000000ffa00020, 0x00000000ffa00200, 0x0000000100000000)
 Metaspace       used 3233K, capacity 4496K, committed 4864K, reserved 1056768K
 class space    used 350K, capacity 388K, committed 512K, reserved 1048576K

**/