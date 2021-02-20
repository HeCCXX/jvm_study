package com.hcx.compile;

/**
 * @ClassName BADLY_NAMED_CODE
 * @Description 名称检查测试类
 * 分别编译NameChecker和NameCheckProcessor后，javac 利用-processor指定附件的注解处理器
 * javac -encoding utf-8 com/hcx/compile/NameChecker.java
 * javac -encoding utf-8 com/hcx/compile/NameCheckProcessor.java
 * 当在同一级目录下编译时，使用source文件来加载依赖，命令可以如下
 * javac -encoding utf-8 @source.txt NameCheckProcessor.java
 *
 * 运行测试命令：javac -encoding utf-8 -processor com.hcx.compile.NameCheckProcessor com/hcx/compile/BADLY_NAMED_CODE.java
 * @Author 贺楚翔
 * @Date 2021-02-20 14:18
 * @Version 1.0
 **/
public class BADLY_NAMED_CODE {
    enum colors {
        red, blue, green;
    }
    static final int _FORTY_TWO = 42;
    public static int NOT_A_CONSTANT = _FORTY_TWO;
    protected void BADLY_NAMED_CODE() {
        return;
    }
    public void NOTcamelCASEmethodNAME() {
        return;
    }
}
/**   运行结果：
* com\hcx\compile\BADLY_NAMED_CODE.java:10: 警告: 名称BADLY_NAMED_CODE应当符合驼峰命名法
 * public class BADLY_NAMED_CODE {
 *        ^
 * 警告: 常量red应当全部以大写字母或者下划线命名，并且以字母开头
 * 警告: 常量blue应当全部以大写字母或者下划线命名，并且以字母开头
 * 警告: 常量green应当全部以大写字母或者下划线命名，并且以字母开头
 * 警告: 常量_FORTY_TWO应当全部以大写字母或者下划线命名，并且以字母开头
 * com\hcx\compile\BADLY_NAMED_CODE.java:15: 警告: 名称NOT_A_CONSTANT应当以小写字母开头
 *     public static int NOT_A_CONSTANT = _FORTY_TWO;
 *                       ^
 * 警告: 一个普通方法BADLY_NAMED_CODE不应与类名重复
 * com\hcx\compile\BADLY_NAMED_CODE.java:16: 警告: 名称BADLY_NAMED_CODE应当以小写字母开头
 *     protected void BADLY_NAMED_CODE() {
 *                    ^
 * com\hcx\compile\BADLY_NAMED_CODE.java:19: 警告: 名称NOTcamelCASEmethodNAME应当以小写字母开头
 *     public void NOTcamelCASEmethodNAME() {
 *                 ^
 * 9 个警告
**/
