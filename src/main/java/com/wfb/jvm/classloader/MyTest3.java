package com.wfb.jvm.classloader;

import java.util.UUID;

public class MyTest3 {
    public static void main(String[] args) {
        /*
         * 执行结果为：
         * MyParent3 static block
         * 47515940-943b-4a32-bea9-6c1c8283486e
         * 当一个常量的值并非编译期间可以确定的，那么其值不会被放到调用类的常量池中，
         * 这时在程序运行时，会导致主动使用这个常量所在的类，从而导致这个类的初始化。
         */
        System.out.println(MyParent3.str);
    }
}
class MyParent3{
    public static final String str = UUID.randomUUID().toString();
    static {
        System.out.println("MyParent3 static block");
    }
}
