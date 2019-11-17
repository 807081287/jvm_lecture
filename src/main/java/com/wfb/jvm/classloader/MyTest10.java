package com.wfb.jvm.classloader;
/*
执行结果：
MyTest10 static block
---------------------
Parent2 static block
---------------------
3
---------------------
Child2 static block
4
 */
public class MyTest10 {
    static {
        System.out.println("MyTest10 static block");
    }
    public static void main(String[] args) {
        Parent2 parent2; //Parent2类的被动使用，不会进行类的初始化,甚至该类未被加载。
        System.out.println("---------------------");
        Parent2 parent21 = new Parent2();
        System.out.println("---------------------");
        System.out.println(parent21.a);
        System.out.println("---------------------");
        System.out.println(Child2.b);
    }
}
class Parent2{
    static int a = 3;
    static {
        System.out.println("Parent2 static block");
    }
}
class Child2 extends Parent2{
    static int b = 4;
    static {
        System.out.println("Child2 static block");
    }
}
