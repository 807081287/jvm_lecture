package com.wfb.jvm.classloader;

public class MyTest6 {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        /*
         * 执行结果：
         * counter1:1
         * counter2:0
         * 因为类的初始化是自上而下的。所以先进行了instance类变量的初始化，调用构造器，counter1=1,counter2=1。
         * 之后调用counter2类变量的初始化，counter2=0；最终counter1=1，而counter2=0。
         */
        System.out.println("counter1:" + s1.counter1);
        System.out.println("counter2:" + s1.counter2);
    }
}
class Singleton{
    public static int counter1;
    private static Singleton instance = new Singleton();
    public static int counter2 = 0;
    private Singleton(){
        counter1++;
        counter2++;
    }
    public static Singleton getInstance(){
        return instance;
    }
}