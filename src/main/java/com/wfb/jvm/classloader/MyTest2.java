package com.wfb.jvm.classloader;

public class MyTest2 {
    public static void main(String[] args) {
        /*
         * 执行结果为：
         * hello world
         * 因为final标识常量，在编译阶段其值就会被存入调用该常量的方法所在的类的常量池中。
         * 本质上，调用该类并没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化。
         * 注意：这里指的是将常量存放到MyTest2的常量池中，之后MyTest2与Myparent2就没有任何关系了。
         * 甚至在编译后可以将MyParent2的class文件删除，不会影响到MyTest2的执行
         * javap -c com.wfb.jvm.classloader.MyTest2反编译class文件
         */
        System.out.println(MyParent2.str); //ldc
        System.out.println(MyParent2.m);    //iconst_1
        System.out.println(MyParent2.b);    //bipush
        System.out.println(MyParent2.s);    //sipush
        System.out.println(MyParent2.i);    //ldc
    }
}
class MyParent2{
    public final static String str = "hello world";
    public final static byte m = 1;
    public final static byte b = 127;
    public final static short s = 128;
    public final static int i = 32768;

    static {
        System.out.println("MyParent2 static block");
    }
}
