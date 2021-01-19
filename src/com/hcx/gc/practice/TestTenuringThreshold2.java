package com.hcx.gc.practice;

/**
 * @ClassName TestTenuringThreshold2
 * @Description 当service代中对象的大小大于等于survivor的一半，则直接进入老年代
 * @Author 贺楚翔
 * @Date 2021-01-18 15:45
 * @Version 1.0
 **/
public class TestTenuringThreshold2 {
    private static final int _1MB = 1024 * 1024;
    public static void main(String[] args) {
        byte[] allocation1,allocation2,allocation3,allocation4;
        allocation1 = new byte[_1MB / 4];
        allocation4 = new byte[_1MB / 4];
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4*_1MB];

    }
}
/**
 可以看到设置年龄为15时，allocation1和2在survivor空间为512K，在gc中直接到了老年代
 [GC (Allocation Failure) [DefNew
 Desired survivor size 524288 bytes, new threshold 1 (max 15)
 - age   1:    1048576 bytes,    1048576 total
 : 6751K->1024K(9216K), 0.0035118 secs] 6751K->5267K(19456K), 0.0035425 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 [GC (Allocation Failure) [DefNew
 Desired survivor size 524288 bytes, new threshold 15 (max 15)
 : 5120K->0K(9216K), 0.0009865 secs] 9363K->5267K(19456K), 0.0010064 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 Heap
 def new generation   total 9216K, used 4178K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
 eden space 8192K,  51% used [0x00000000fec00000, 0x00000000ff014930, 0x00000000ff400000)
 from space 1024K,   0% used [0x00000000ff400000, 0x00000000ff400000, 0x00000000ff500000)
 to   space 1024K,   0% used [0x00000000ff500000, 0x00000000ff500000, 0x00000000ff600000)
 tenured generation   total 10240K, used 5267K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
 the space 10240K,  51% used [0x00000000ff600000, 0x00000000ffb24ef0, 0x00000000ffb25000, 0x0000000100000000)
 Metaspace       used 3234K, capacity 4496K, committed 4864K, reserved 1056768K
 class space    used 350K, capacity 388K, committed 512K, reserved 1048576K
**/
