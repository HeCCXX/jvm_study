package com.hcx.dispatch;

/**
 * @ClassName Dispatch
 * @Description 单分派、多分派
 * 静态分派属于多分派类型，在编译期间，静态类型和方法参数决定具体的符号引用
 * 动态分派属于单分派类型，在运行期间，实际类型决定具体的调用
 * @Author 贺楚翔
 * @Date 2021-02-03 11:28
 * @Version 1.0
 **/
public class Dispatch {
    static class QQ{}
    static class _360{}
    public static class Father{
        public void hardChoice(QQ choose){
            System.out.println("father choose qq");
        }
        public void hardChoice(_360 choose){
            System.out.println("father choose 360");
        }
    }

    public static class Son extends Father{
        @Override
        public void hardChoice(QQ choose){
            System.out.println("Son choose qq");
        }
        @Override
        public void hardChoice(_360 choose){
            System.out.println("Son choose 360");
        }
    }

    public static void main(String[] args) {
        final Father father = new Father();
        father.hardChoice(new _360());
        Father son = new Son();
        son.hardChoice(new QQ());
    }
}
/** 运行结果：
 father choose 360
 Son choose qq
**/
