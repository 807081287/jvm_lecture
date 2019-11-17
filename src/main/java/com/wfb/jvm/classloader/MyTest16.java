package com.wfb.jvm.classloader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
/*
请先删掉out/production/classes/com/wfb/jvm/classloader/MyTest1
类的卸载实例也在该test中，请将注释打开，并将其下方代码注释掉。
执行结果：
invoke findClass
com.wfb.jvm.classloader.MyTest1@1540e19d
class: 1735600054
classLoaderName: loader1

com.wfb.jvm.classloader.MyTest1@14ae5a5
class: 1735600054
classLoaderName: loader1

invoke findClass
com.wfb.jvm.classloader.MyTest1@135fbaa4
class: 1173230247
classLoaderName: loader3
原因：
由loader1加载MyTest1，输出以上四行。
由loader2加载MyTest1，loader2的父加载器为loader1，它会先委托loader1加载，
    loader1已经加载过，直接返回，所以hashCode一致。
由loader3加载MyTest1，loader3的父加载器为App,其祖辈们无法加载该类，只能交由loader3尝试加载，
    loader3重新加载了一个MyTest1类，所以跟上面的两个HashCode码不同。
这说明了类的命名空间规则和父委托机制。
 */
public class MyTest16 extends ClassLoader {
    private String classLoaderName;
    private final String fileExtension = ".class";
    private String path;

    public void setPath(String path){
        this.path = path;
    }

    public MyTest16(String classLoaderName) {
        this.classLoaderName = classLoaderName;
    }

    public MyTest16(ClassLoader classLoader){super(classLoader); this.classLoaderName="MyTest16";}

    public MyTest16(ClassLoader parent, String classLoaderName) {
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    @Override
    public String toString() {
       return "classLoaderName: " + this.classLoaderName;
    }

    private byte[] loadClassData(String className){
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;
        className = className.replace(".", "/");
        try {
            is = new FileInputStream(this.path + className + fileExtension);
            baos = new ByteArrayOutputStream();
            int ch = 0;
            while ((ch=is.read()) != -1){
                baos.write(ch);
            }
            data = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                baos.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("invoke findClass");
        byte[] data = loadClassData(name);
        return this.defineClass(name, data, 0, data.length);
    }

    public static void test(ClassLoader classLoader) throws Exception {
        Class<?> clazz = classLoader.loadClass("com.wfb.jvm.classloader.MyTest1");
        Object object = clazz.newInstance();
        System.out.println(object);
        System.out.println("class: " + clazz.hashCode());
        System.out.println(clazz.getClassLoader());
        System.out.println();

    }

    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("E:\\waster\\");
        test(loader1);
//        loader1 = null;
//        System.gc();
//        Thread.sleep(1_000_000);
//        loader1 = new MyTest16("loader1");
//        loader1.setPath("E:\\waster\\");
//        test(loader1);
        MyTest16 loader2 = new MyTest16(loader1, "loader2");
        loader2.setPath("E:\\waster\\");
        test(loader2);
        MyTest16 loader3 = new MyTest16("loader3");
        loader3.setPath("E:\\waster\\");
        test(loader3);
    }
}
