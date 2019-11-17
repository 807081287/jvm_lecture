package com.wfb.jvm.classloader;

import java.lang.reflect.Method;
/*
同一个命名空间的类是相互可见的，但不一定可以访问（由访问修饰符决定），
不同命名空间的类是相互不可见的。
该实例抛出异常：
Caused by: java.lang.ClassCastException: com.wfb.jvm.classloader.MyPerson
cannot be cast to com.wfb.jvm.classloader.MyPerson
at com.wfb.jvm.classloader.MyPerson.setMyPerson(MyPerson.java:6)
 */
public class MyTest21 {
    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("E:\\waster\\");
        MyTest16 loader2 = new MyTest16("loader2");
        loader2.setPath("E:\\waster\\");
        Class<?> aClass1 = loader1.loadClass("com.wfb.jvm.classloader.MyPerson");
        Class<?> aClass2 = loader2.loadClass("com.wfb.jvm.classloader.MyPerson");
        System.out.println(aClass1 == aClass2);
        Object object1 = aClass1.newInstance();
        Object object2 = aClass2.newInstance();
        Method method = aClass1.getMethod("setMyPerson", Object.class);
        method.invoke(object1, object2);
    }
}
