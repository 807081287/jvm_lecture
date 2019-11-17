package com.wfb.jvm.classloader;


public class MyTest1 {
    /*
    * -XX:+TraceClassLoading，用于追踪类的加载信息并打印出来。
    */
    public static void main(String[] args) {
        /*
        执行结果为：
        MyParent1 static block
        hello world
        因为只主动使用了MyParent1(getstatic)，未主动使用MyChild1
        但是不能删除MyChild1，删除后会导致java.lang.NoClassDefFoundError
         */
        System.out.println(MyChild1.str);
        /*
        执行结果为：
        MyParent1 static block
        MyChild1 static block
        welcome
        主动使用了MyChild1(getstatic)，MyParent1（初始化该类的子类）
         */
//        System.out.println(MyChild1.str2);
    }
}
class MyParent1{
    public static String str = "hello world";

    static { //初始化阶段执行
        System.out.println("MyParent1 static block");
    }
}
class MyChild1 extends MyParent1{
    public static String str2 = "welcome";
    static {
        System.out.println("MyChild1 static block");
    }
}