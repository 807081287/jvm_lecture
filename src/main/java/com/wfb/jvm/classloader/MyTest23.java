package com.wfb.jvm.classloader;

import sun.misc.Launcher;

/*
在运行期，一个Java类是由该类的完全限定名（binary name, 二进制名）
和用于加载该类的定义类加载器（defining loader）所共同决定的
在Oracle的HotSpot实现中，系统属性sun.boot.class.path如果修改错误，则会运行出错，提示如下出错信息：
Error occurred during initialization of VM
java/lang/NoClassDefFoundError: java/lang/Object
可以使用java -Dsun.boot.class.path=./ com.wfb.jvm.classloader.MyTest23命令来验证该结论。
 */
public class MyTest23 {
    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.boot.class.path"));  //BootStrap
        System.out.println(System.getProperty("java.ext.dirs"));    //ExtClassLoader
        System.out.println(System.getProperty("java.class.path"));  //AppClassLoader
        /*
        内建于JVM的启动类加载器会加载java.lang.ClassLoader以及其他的Java平台类，
        当JVM启动时，一块特殊的机器码会运行，它会加载扩展类加载器与系统类加载器，
        这块特殊的机器码叫做启动类加载器（BootStrap）。
        启动类加载器并不是Java类，而其他的加载器则是Java类。
        启动类加载器是特定于平台的机器指令，它负责开启整个加载过程。
        所以类加载器（除启动类加载器）都被实现为Java类。
        不过，总归要有一个组件来加载第一个Java类加载器，从而让整个加载过程能够顺利进行下去，
        加载第一个纯Java类加载器就是启动类加载器的职责。
        启动类加载器还会负责加载提供JRE正常运行所需要的基本组件，这包括java.util与java.lang包中的类等。
         */
        System.out.println(ClassLoader.class.getClassLoader()); //BootStrap加载。
        System.out.println(Launcher.class.getClassLoader());    //该类由BootStrap加载，
        //其匿名内部类也会由BootStrap加载，即ExtClassLoader和AppClassLoader也由BootStrap加载
        System.out.println("-----------------------");
        System.out.println(System.getProperty("java.system.class.loader"));
        System.out.println(MyTest23.class.getClassLoader());
        System.out.println(MyTest16.class.getClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        System.out.println(new MyTest16("loader1").getParent());
        /*
        执行命令：java -Djava.system.class.loader=com.wfb.jvm.classloader.MyTest16 com.wfb.jvm.classloader.MyTest23
        ClassLoader.getSystemClassLoader()变成了MyTest16,此时新创建的CustomClassLoader的父加载器也是MyTest16,
        而系统类加载器的父加载器为AppClassLoader。
         */
    }
}
