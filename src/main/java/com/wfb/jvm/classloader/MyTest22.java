package com.wfb.jvm.classloader;
/*
执行java -Djava.ext.dirs=./ com.wfb.jvm.classloader.MyTest22命令：
执行结果：
MyTest22 static block
sun.misc.Launcher$AppClassLoader@73d16e93
sun.misc.Launcher$AppClassLoader@73d16e93
结果说明MyTest1类由AppClassLoader加载器加载的，说明ExtClassLoader无法加载MyTest1。
这是因为ExtClassLoader只能从jar包中加载类。
执行命令：jar cvf test.jar com/wfb/jvm/classloader/*.class将
com/wfb/jvm/classloader路径下的class文件压缩到jar包，
之后执行结果为：
MyTest22 static block
sun.misc.Launcher$ExtClassLoader@70dea4e
sun.misc.Launcher$ExtClassLoader@70dea4e
说明MyTest1和MyTest22由ExtClassLoader加载。
 */
public class MyTest22 {
    static {
        System.out.println("MyTest22 static block");
    }

    public static void main(String[] args) {
        System.out.println(MyTest22.class.getClassLoader());
        System.out.println(MyTest1.class.getClassLoader());
    }
}
