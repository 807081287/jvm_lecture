package com.wfb.jvm.classloader;

import com.sun.crypto.provider.AESKeyGenerator;
/*
AESKeyGenerator类由ExtClassLoader加载器加载。
进入out/production/classes
执行命令：java -Djava.ext.dirs=./ com.wfb.jvm.classloader.MyTest19,
更改ExtClassLoader类加载器的加载目录，执行MyTest19,出现NoClassDefFoundError,
说明ExtClassLoader进当前目录加载了，结果没有AESKeyGenerator类，导致加载失败。
 */
public class MyTest19 {
    public static void main(String[] args) {
        AESKeyGenerator aesKeyGenerator = new AESKeyGenerator();
        System.out.println(aesKeyGenerator.getClass().getClassLoader());
        System.out.println(MyTest19.class.getClassLoader());
    }
}
