package com.hcx.gc.referenceCountGC;

/**
 * @ClassName FinalizeEscapeGC
 * @Description finalize逃逸gc
 * 自救的机会只有一次，因为finalize方法只能被系统执行一次
 * @Author 贺楚翔
 * @Date 2020-12-31 15:00
 * @Version 1.0
 **/
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method execute");
        SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();

        SAVE_HOOK = null;
        System.gc();

        Thread.sleep(500);
        if (SAVE_HOOK != null){
            System.out.println("yes it is alive");
        }else {
            System.out.println("no it is dead");
        }

        SAVE_HOOK = null;
        System.gc();

        Thread.sleep(500);
        if (SAVE_HOOK != null){
            System.out.println("yes it is alive");
        }else {
            System.out.println("no it is dead");
        }
    }
}
