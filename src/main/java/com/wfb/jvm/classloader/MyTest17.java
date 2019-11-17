package com.wfb.jvm.classloader;

/*
执行结果：
clazz: 1956725890
MySample is loader by: sun.misc.Launcher$AppClassLoader@18b4aac2
MyCat is loader by: sun.misc.Launcher$AppClassLoader@18b4aac2
 */
public class MyTest17 {
    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        Class<?> clazz = loader1.loadClass("com.wfb.jvm.classloader.MySample");
        System.out.println("clazz: " + clazz.hashCode());
        Object object = clazz.newInstance();
    }
}
