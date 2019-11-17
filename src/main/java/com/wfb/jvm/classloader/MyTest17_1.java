package com.wfb.jvm.classloader;
/*
验证：
1.在类中使用的未被加载的类会由该类的定义类加载器负责加载
2.每个类加载器都有自己的命名空间，命名空间由该加载器及所有父加载器所加载的类组成
实验步骤：
11.将out/production/classes/com/wfb/jvm/classloader中的MyCat和MySample同时剪切，程序正常运行，
    两个类均由MyTest16类加载器加载。
12.只剪切out/production/classes/com/wfb/jvm/classloader中的MyCat，程序抛出NoClassDefFoundError，
    发现MySample is loader by: sun.misc.Launcher$AppClassLoader@18b4aac2。说明了MyCat也被尝试
    用AppClassLoader加载，但是加载失败。
13.只剪切out/production/classes/com/wfb/jvm/classloader中的MySample，程序正常运行，MySample由MyTest16
    类加载器加载，而MyCat由AppClassLoader加载。
21.只在MyCat中加入System.out.println("from MyCat: " + MySample.class);执行13，出现NoClassDefFoundError，
22.只在MySample中加入System.out.println("form MySample: " + MyCat.class);执行13，正确执行。
这是因为	“每个类加载器都有自己的命名空间，命名空间由该加载器及所有父加载器所加载的类组成”，
所以父加载器加载的类命名空间中不会有子加载器加载的类，所以MyCat找不到MySample，而MySample可以找到MyCat。
注：剪切地址：E:\waster\com\wfb\jvm\classloader\
 */
public class MyTest17_1 {
    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("E:\\waster\\");
        Class<?> clazz = loader1.loadClass("com.wfb.jvm.classloader.MySample");
        System.out.println("clazz: " + clazz.hashCode());
        Object object = clazz.newInstance();
    }
}
