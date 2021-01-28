package com.hcx.clazz;

/**
 * @ClassName ClassAnalysis
 * @Description javap 命令使用实例，查看操作指令等
 * @Author 贺楚翔
 * @Date 2021-01-25 14:14
 * @Version 1.0
 **/
public class ClassAnalysis {
    //查看字节码及异常、操作指令
//    private int m;
//    public int inc(){
//        try {
//            m = 1;
//            return m;
//        }catch (Exception e){
//            m=2;
//            return m;
//        }finally {
//            m=3;
//        }
//    }

    //javap -verbose ClassAnalysis.class，查看monitorenter字节码
    class Foo {

    }

    public void sync(Foo f){
        synchronized (f){
            doSomething();
        }
    }

    private void doSomething() {

    }
}
