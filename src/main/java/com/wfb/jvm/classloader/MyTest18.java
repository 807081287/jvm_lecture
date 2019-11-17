package com.wfb.jvm.classloader;
/*
从AppClassLoader的加载路径可以看出，E:\IDEAFile\jvm_lecture\out\production\classes被IDEA加入了
AppClassLoader的加载路径，因此我们编写的代码编译后会被AppClassLoader加载。
 */
public class MyTest18 {
    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.boot.class.path"));  //BootStrap
        System.out.println(System.getProperty("java.ext.dirs"));    //ExtClassLoader
        System.out.println(System.getProperty("java.class.path"));  //AppClassLoader
    }
}
