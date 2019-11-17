package com.wfb.jvm.classloader;
/*
当前类加载器（Current ClassLoader）
每个类都会使用自己的类加载器（即该类的定义类加载器）来去加载其他类（指其所依赖的类），
如果ClassX引用了CLassY，那么ClassY会由ClassX的定义类加载器加载（前提是ClassY尚未被加载）

线程上下文类加载器（Context CLassLoader）
线程上下文类加载器是从JDK1.2开始引入的，类Thread中的getContextClassLoader()与setContextClassLoader(ClassLoader cl)分别用来获取和设置上下文类加载器。
如果没有通过setContextClassLoader(ClassLoader cl)进行设置的话，线程将继承父线程的上下文类加载器。
Java应用运行时的初始线程的上下文类加载器是系统类加载器。

线程上下文类加载器的重要性：

SPI（Server Provider Interface）

父classLoader可以使用当前线程Thread.currentThread().getContextCLassLoader()所指定的classLoader加载的类，
这就改变了父classLoader不能使用子classLoader或是其他没有直接父子关系的classLoader加载类的情况，
即改变了双亲委托模型。

线程上下文类加载器就是当前线程的当前类加载器（Current ClassLoader）

在双亲委托模型下，类加载是由下至上的，即下层的类加载器会委托上层进行加载，
但是对于SPI来说，有些接口是Java核心库所提供的，而Java核心库是由启动类加载器加载的，
而这些接口实现却来自于不同的jar包（厂商提供），Java的启动类加载器不会加载其他来源的Jar包，
这样传统的双亲委托模型无法满足SPI的要求，而通过给当前线程设置上下文类加载器，
就可以由设置的上下文类加载器来实现对于接口实现类的加载。
 */
public class MyTest24 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader()); //sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(Thread.class.getClassLoader());  //null
    }
}