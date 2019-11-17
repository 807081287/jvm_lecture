package com.wfb.jvm.classloader;

import java.util.Random;

public class MyTest5 {
    public static void main(String[] args) {
        /*
         * 接口中的属性默认为public static final。
         * 当一个接口在初始化时，并不要求其父类接口都完成了初始化。 
         * 只有在真正使用父接口的时候（如引用接口中所定义的常量时），才会初始化。
         * 因此当为接口时只会输出一个随机整数，表明Myparent5接口未被初始化。
         * 而将interface关键字改为class关键字后，还会输出MyParent5 invoke <clinit>()，表明Myparent5类也初始化了
         */
        System.out.println(MyChild5.b);
    }
}
interface MyParent5{
    public static final Thread thread = new Thread(){
        {
            System.out.println("MyParent5 invoke <clinit>()");
        }
    };
}
interface MyChild5 extends MyParent5{
    public static final int b = new Random().nextInt();
}
