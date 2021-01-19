package com.hcx.gc.practice;

/**
 * @ClassName testTenuringThreshold
 * @Description 长期存活的对象进入老年代
 * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * -XX:MaxTenuringThreshold=1
 *  -XX:+PrintTenuringDistribution -XX:+UseSerialGC
 *  MaxTenuringThreshold gc年龄次数阈值，达到后进行老年代
 * @Author 贺楚翔
 * @Date 2021-01-18 14:58
 * @Version 1.0
 **/
public class TestTenuringThreshold {
    private static final int _1MB = 1024 * 1024;
    public static void main(String[] args) {
        byte[] allocation1,allocation2,allocation3;
        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4*_1MB];

    }
}
/**
 为1时，gc直接将allocation1和allocation2进行老年代
 为15时，service 代将存放allocation1 256K
 [GC (Allocation Failure) [DefNew
 Desired survivor size 524288 bytes, new threshold 1 (max 1)
 - age   1:     937704 bytes,     937704 total
 : 6495K->915K(9216K), 0.0037171 secs] 6495K->5011K(19456K), 0.0037586 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 [GC (Allocation Failure) [DefNew
 Desired survivor size 524288 bytes, new threshold 1 (max 1)
 : 5011K->0K(9216K), 0.0010576 secs] 9107K->5004K(19456K), 0.0010843 secs] [Times: user=0.02 sys=0.00, real=0.00 secs]
 Heap
 def new generation   total 9216K, used 4178K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
 eden space 8192K,  51% used [0x00000000fec00000, 0x00000000ff014930, 0x00000000ff400000)
 from space 1024K,   0% used [0x00000000ff400000, 0x00000000ff400000, 0x00000000ff500000)
 to   space 1024K,   0% used [0x00000000ff500000, 0x00000000ff500000, 0x00000000ff600000)
 tenured generation   total 10240K, used 5004K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
 the space 10240K,  48% used [0x00000000ff600000, 0x00000000ffae3228, 0x00000000ffae3400, 0x0000000100000000)
 Metaspace       used 3234K, capacity 4496K, committed 4864K, reserved 1056768K
 class space    used 350K, capacity 388K, committed 512K, reserved 1048576K
**/
