package com.wfb.jvm.classloader;

/*
执行结果：
MyTest9 static block
[Loaded com.wfb.jvm.classloader.Parent from file:/E:/IDEAFile/jvm_lecture/out/production/classes/]
[Loaded com.wfb.jvm.classloader.Child from file:/E:/IDEAFile/jvm_lecture/out/production/classes/]
Parent static block
Child static block
4
 */
public class MyTest9 {

    static {
        System.out.println("MyTest9 static block");
    }

    public static void main(String[] args) {
        System.out.println(Child.b);
    }
}
class Parent{
    static int a = 3;
    static {
        System.out.println("Parent static block");
    }
}
class Child extends Parent{
    static int b = 4;
    static {
        System.out.println("Child static block");
    }
}
