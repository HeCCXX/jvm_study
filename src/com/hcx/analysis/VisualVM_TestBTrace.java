package com.hcx.analysis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName VisualVM_TestBTrace
 * @Description Visualvm 测试btrace,动态日志跟踪，查询运行中程序的参数、返回值等
 * @Author 贺楚翔
 * @Date 2021-01-20 14:14
 * @Version 1.0
 **/
public class VisualVM_TestBTrace {
    public int add(int a, int b) {
        return a + b;
    }
    public static void main(String[] args) throws IOException {
        VisualVM_TestBTrace test = new VisualVM_TestBTrace();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            reader.readLine();
            int a = (int) Math.round(Math.random() * 1000);
            int b = (int) Math.round(Math.random() * 1000);
            System.out.println(test.add(a, b));
        }
    }
}

/**
btrace程序
import com.sun.btrace.annotatons.*;
import static com.sun.btrace.BTraceUtils.*;

@BTrace
public class TracingScript {
    @OnMethod(
            clazz="com.hcx.analysis.VisualVM_TestBTree",
            method="add",
            location=@Location(Kind.RETURN)
    )

    public static void fund(@Self com.hcx.analysis.VisualVM_TestBTree instance,int a,int b,@Return int result){
        println("调用堆栈:");
        jstack();
        println(strcat("方法参数A:",str(a)));
        println(strcat("方法参数B:",str(b)));
        println(strcat("方法结果:",str(result)));
    }
}

调用堆栈:
com.hcx.analysis.VisualVM_TestBTree.add(VisualVM_TestBTree.java:16)
com.hcx.analysis.VisualVM_TestBTree.main(VisualVM_TestBTree.java:25)
方法参数A:691
方法参数B:11
方法结果:702
**/
