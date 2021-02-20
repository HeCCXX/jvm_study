package com.hcx.compile;

import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.*;
import javax.lang.model.util.ElementScanner8;
import javax.tools.Diagnostic;
import java.util.EnumSet;

/**
 * @ClassName NameChecker
 * @Description 编译过程--->插入式注解处理器---> 检查文件
 * 程序名称规范的编译器插件：<br>
 * * 如果程序命名不合规范，将会输出一个编译器的WARNING信息
 * @Author 贺楚翔
 * @Date 2021-02-20 11:24
 * @Version 1.0
 **/
public class NameChecker {
    private final Messager messager;

    NameCheckerScanner nameCheckerScanner = new NameCheckerScanner();

    public NameChecker(ProcessingEnvironment processingEnv) {
        this.messager = processingEnv.getMessager();
    }
    public void checkName(Element element){
        nameCheckerScanner.scan(element);
    }

    /**
    * 名称检查实现类，将会以Visitor模式访问抽象语法树中元素
    **/
    private class NameCheckerScanner extends ElementScanner8<Void,Void>{
        /**
        * 此方法用于检查java方法
        * @param e
        * @param aVoid
        * @return java.lang.Void
        * @exception
        **/
        @Override
        public Void visitType(TypeElement e, Void aVoid) {
            scan(e.getTypeParameters(),aVoid);
            checkCamelCase(e,true);
            super.visitType(e,aVoid);
            return null;
        }



        /**
        * 检查方法命名是否合法
        * @param e
        * @param aVoid
        * @return java.lang.Void
        * @exception
        **/
        @Override
        public Void visitExecutable(ExecutableElement e, Void aVoid) {
            if (e.getKind() == ElementKind.METHOD){
                final Name name = e.getSimpleName();
                if (name.contentEquals(e.getEnclosingElement().getSimpleName())){
                    messager.printMessage(Diagnostic.Kind.WARNING,"一个普通方法"+name+"不应与类名重复");
                }
                checkCamelCase(e,false);
            }
            return null;
        }

        /**
        * 检查变量命名是否合法
        * @param e
        * @param aVoid
        * @return java.lang.Void
        * @exception
        **/
        @Override
        public Void visitVariable(VariableElement e, Void aVoid) {
            //如果这个variable是枚举或者常量，则按照全部大写命名检查，否则按照驼峰式命名规则检查
            if (e.getKind() == ElementKind.ENUM_CONSTANT || e.getConstantValue() != null
            || heuristicallyConstant(e)){
                checkAllCaps(e);
            }
            else {
                checkCamelCase(e,false);
            }
            return null;
        }

        /**
        * 检查一个变量是否为常量
        * @param e
        * @return boolean
        * @exception
        **/
        private boolean heuristicallyConstant(VariableElement e) {
            if (e.getEnclosingElement().getKind() == ElementKind.INTERFACE){
                return true;
            }else if (e.getKind() == ElementKind.FIELD && e.getModifiers().containsAll(EnumSet.of(Modifier.PUBLIC,Modifier.STATIC,Modifier.FINAL))){
                return true;
            }else {
                return false;
            }
        }

        /**
        * 检查驼峰命名
        * @param e
        * @param b
        * @return void
        * @exception
        **/
        private void checkCamelCase(Element e, boolean b) {
            String name = e.getSimpleName().toString();
            boolean previousUpper = false;
            boolean conventional = true;
            final int firstCodePoint = name.codePointAt(0);
            if (Character.isUpperCase(firstCodePoint)){
                previousUpper = true;
                if (!b){
                    messager.printMessage(Diagnostic.Kind.WARNING,"名称"+name+"应当以小写字母开头",e);
                    return;
                }else if (Character.isLowerCase(firstCodePoint)){
                    if (b){
                        messager.printMessage(Diagnostic.Kind.WARNING,"名称"+name+"应当以大写字母开头",e);
                        return;
                    }
                }else {
                    conventional = false;
                }
                if (conventional){
                    int cp = firstCodePoint;
                    for (int i = Character.charCount(cp);i<name.length();i+=Character.charCount(cp)){
                        cp = name.codePointAt(i);
                        if (Character.isUpperCase(cp)){
                            if (previousUpper){
                                conventional = false;
                                break;
                            }
                            previousUpper = true;
                        }else {
                            previousUpper = false;
                        }
                    }
                }
            }
            if (!conventional){
                messager.printMessage(Diagnostic.Kind.WARNING,"名称"+name+"应当符合驼峰命名法",e);
            }
        }

        /**
        * 大写命名检查，要求第一个字母必须是大写的英文字母，其余部分可以是下划线或大写字母
        * @param e
        * @return void
        * @exception
        **/
        private void checkAllCaps(VariableElement e) {
            final String name = e.getSimpleName().toString();
            boolean conventional = true;
            final int firstCodePoint = name.codePointAt(0);
            if (!Character.isUpperCase(firstCodePoint)){
                conventional = false;
            }else {
                boolean previousUnderscore =false;
                int cp = firstCodePoint;
                for (int i = Character.charCount(cp);i<name.length();i+=Character.charCount(cp)){
                    cp = name.codePointAt(i);
                    if (cp == (int) '_'){
                        if (previousUnderscore){
                            conventional = false;
                            break;
                        }
                        previousUnderscore = true;
                    }else {
                        previousUnderscore = false;
                        if (!Character.isUpperCase(i) && !Character.isDigit(i)){
                            conventional = false;
                            break;
                        }
                    }
                }
            }
            if (!conventional){
                messager.printMessage(Diagnostic.Kind.WARNING,"常量"+name+"应当全部以大写字母或者下划线命名，并且以字母开头");
            }
        }
    }
}
