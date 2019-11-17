package com.wfb.jvm.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
/*
当一个类或者一个资源文件存在多个jar中，就会存在jar hell问题。
（例如：项目依赖很多jar包，而不同的jar包使用了同一个类的不同的版本）
可以通过以下代码来诊断问题
当出现多个urls时，说明出现了jar hell问题。
 */
public class MyTest14 {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String resourceName = "com/wfb/jvm/classloader/MyTest13.class";
        Enumeration<URL> urls = classLoader.getResources(resourceName);
        while (urls.hasMoreElements()){
            URL url = urls.nextElement();
            System.out.println(url);
        }
    }
}