package com.wfb.jvm.classloader;

import java.lang.reflect.Method;
/*
执行结果：
true
因为MyPerson都是由AppClassLoader加载的。
 */
public class MyTest20 {
    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        MyTest16 loader2 = new MyTest16("loader2");
        Class<?> aClass1 = loader1.loadClass("com.wfb.jvm.classloader.MyPerson");
        Class<?> aClass2 = loader2.loadClass("com.wfb.jvm.classloader.MyPerson");
        System.out.println(aClass1 == aClass2);
        Object object1 = aClass1.newInstance();
        Object object2 = aClass2.newInstance();
        Method method = aClass1.getMethod("setMyPerson", Object.class);
        method.invoke(object1, object2);
    }
}
