package com.hcx.compile;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * @ClassName NameCheckProcessor
 * @Description 插入式注解器---> 检查java文件是否规范，文件名驼峰，类名驼峰
 * @Author 贺楚翔
 * @Date 2021-02-20 11:20
 * @Version 1.0
 **/
//用*支持所有注解
@SupportedAnnotationTypes("*")
//支持版本，支持1.8版本的java代码
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class NameCheckProcessor extends AbstractProcessor {
    private NameChecker nameChecker;

    /**
    * 初始化名称检查插件
    * @param processingEnv
    * @return void
    * @exception
    **/
    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        nameChecker = new NameChecker(processingEnv);
    }

    /**
    * 对输入的语法树的各个节点进行名称检查
    * @param annotations
    * @param roundEnv
    * @return boolean
    * @exception
    **/
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if (!roundEnv.processingOver()){
            for (Element element : roundEnv.getRootElements()) {
                nameChecker.checkName(element);
            }
        }
        return false;
    }
}
