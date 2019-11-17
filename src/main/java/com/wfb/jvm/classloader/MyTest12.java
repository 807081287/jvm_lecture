package com.wfb.jvm.classloader;
/*
执行结果：
class com.wfb.jvm.classloader.CL
---------------------
Class CL static block
class com.wfb.jvm.classloader.CL
 */
public class MyTest12 {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        Class<?> clazz = loader.loadClass("com.wfb.jvm.classloader.CL");
        //调用ClassLoader类的loadClass方法加载一个类，并不是类的主动使用，不会导致类的初始化。
        System.out.println(clazz);
        System.out.println("---------------------");
        clazz = Class.forName("com.wfb.jvm.classloader.CL");//类的反射是类的主动使用，会初始化类。
        System.out.println(clazz);
    }
}
class CL{
    static {
        System.out.println("Class CL static block");
    }
}