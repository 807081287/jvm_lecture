package com.wfb.jvm.classloader;
/*
将com/wfb/jvm/classloader/MyTest1.class复制到D:\java\jre\classes路径下，
执行发现类加载器为null，说明其由BootStrap加载器加载了。
注：为了防止冲突，记得测试完，把D:\java\jre\classes路径下的文件删掉哟。
 */
public class MyTest18_1 {
    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("E:\\waster\\");
        Class<?> aClass = loader1.loadClass("com.wfb.jvm.classloader.MyTest1");
        System.out.println(aClass.getClassLoader());
    }
}
