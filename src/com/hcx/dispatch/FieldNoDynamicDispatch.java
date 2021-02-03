package com.hcx.dispatch;

/**
 * @ClassName FieldNoDynamicDispatch
 * @Description 字段不存在多态
 * 首先初始化new Son，隐式调用父类构造器，父类的构造器中方法将实际执行子类的showMeTheMoney方法，
 * 子类此时为0，所以输出 0。然后调用子类的构造器，此时子类的money初始化为4，所以输出4，最后调用main
 * 中的变量，将输出父类中的变量
 * @Author 贺楚翔
 * @Date 2021-02-03 10:37
 * @Version 1.0
 **/
public class FieldNoDynamicDispatch {
    static class Father{
        public int money = 1;

        public Father() {
            money = 2;
            showMeTheMoney();
        }

        public void showMeTheMoney(){
            System.out.println("I am father have " + money);
        }
    }

    static class Son extends Father{
        public int money = 3;

        public Son() {
            money = 4;
            showMeTheMoney();
        }
        @Override
        public void showMeTheMoney(){
            System.out.println("I am Son have " + money);
        }
    }

    public static void main(String[] args) {
        Father gay = new Son();
        System.out.println("this guy have " + gay.money);
    }
}
/** 运行结果：
 I am Son have 0
 I am Son have 4
 this guy have 2
**/
