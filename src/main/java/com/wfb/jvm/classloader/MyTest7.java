package com.wfb.jvm.classloader;

public class MyTest7 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("java.lang.String");
        System.out.println(clazz.getClassLoader()); //getClassLoader返回该类的定义类加载器
        Class<?> clazz2 = Class.forName("com.wfb.jvm.classloader.c");
        System.out.println(clazz2.getClassLoader());
    }
}
class c{

}