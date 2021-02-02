package com.hcx.slot;

/**
 * @ClassName SlotGCTest
 * @Description 局部变量槽对垃圾回收的影响  虚拟机参数：-verbose:gc
 * 下面第一块代码： 代码虽然已经离开bytes的作用域，但此后局部变量表中没有任何读写，导致bytes的变量槽没有被复用修改
 * 第二块代码： 同上
 * 第三块代码：因为int a = 0 复用了局部变量表中的变量槽，所以垃圾回收时会进行回收
 * @Author 贺楚翔
 * @Date 2021-02-02 10:32
 * @Version 1.0
 **/
public class SlotGCTest {
    public static void main(String[] args) {
//        final byte[] bytes = new byte[64 * 1024 * 1024];
//        System.gc();

//        {
//            final byte[] bytes1 = new byte[64 * 1024 * 1024];
//        }
//        System.gc();

        {
            final byte[] bytes1 = new byte[64 * 1024 * 1024];
        }
        int a = 0;
        System.gc();
    }
}
/** 运行结果：
 [GC (System.gc())  70742K->66384K(249344K), 0.0012874 secs]
 [Full GC (System.gc())  66384K->658K(249344K), 0.0052616 secs]
**/
