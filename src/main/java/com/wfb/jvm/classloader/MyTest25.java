package com.wfb.jvm.classloader;

/*
线程上下文类加载器的一般使用模式（获取 - 使用 - 还原）：
ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
try {
	Thread.currentThread().setContextClassLoader(targetTccl);
	myMethod();
} finally {
	Thread.currentThread().setContextClassLoader(classLoader);
}
myMethod方法里面调用了Thread.currentThread().getContextClassLoader(),
获取当前线程的上下文类加载器来做某些事情。
当高层提供了统一的接口让低层去实现，同时又要在高层加载（或实例化）低层的类时，
就必须要通过线程上下文类加载器来帮助高层的ClassLoader找到并加载该类。
 */
public class MyTest25 implements Runnable {
    private Thread thread;

    public MyTest25() {
        this.thread = new Thread(this);
        this.thread.start();
    }

    @Override
    public void run() {
        ClassLoader classLoader = this.thread.getContextClassLoader();
        System.out.println("Class: " + classLoader.getClass());
        System.out.println("Parent: " + classLoader.getParent().getClass());
    }

    public static void main(String[] args) {
        new MyTest25();
    }
}
