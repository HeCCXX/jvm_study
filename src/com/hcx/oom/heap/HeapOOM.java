package com.hcx.oom.heap;

import java.util.ArrayList;

/**
 * @ClassName com.hcx.oom.Heap.HeapOOM
 * @Description  VM Args：-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * @Author 贺楚翔
 * @Date 2020-12-30 11:08
 * @Version 1.0
 **/
public class HeapOOM {
    static class OOMObject {

    }
    /** java 堆内存溢出异常测试
     * 运行结果：
     *java.lang.OutOfMemoryError: Java heap space
     * Dumping heap to java_pid17232.hprof ...
     * Heap dump file created [28290979 bytes in 0.126 secs]
    **/
    public static void main(String[] args) {
        final ArrayList<OOMObject> list = new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
