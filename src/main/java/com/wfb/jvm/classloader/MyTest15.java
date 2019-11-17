package com.wfb.jvm.classloader;
/*
数组类型是由虚拟机自动创建的，它的getClassLoader方法会返回其元素的getClassLoader值，
原始类型无classLoader，所以返回null。BootStrap加载器的返回值也是null。
 */
public class MyTest15 {
    public static void main(String[] args) {
        String[] strings = new String[2];
        System.out.println(strings.getClass().getClassLoader()); //null
        System.out.println("--------------------");
        MyTest15[] myTest15s = new MyTest15[2];
        System.out.println(myTest15s.getClass().getClassLoader());  //sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println("--------------------");
        int [] ints = new int[2];
        System.out.println(ints.getClass().getClassLoader());   //null
    }
}
