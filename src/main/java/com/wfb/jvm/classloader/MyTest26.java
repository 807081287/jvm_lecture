package com.wfb.jvm.classloader;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;


public class MyTest26 {
    public static void main(String[] args) {
        Thread.currentThread().setContextClassLoader(MyTest26.class.getClassLoader().getParent());
        ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator = loader.iterator();
        while(iterator.hasNext()){
            Driver driver = iterator.next();
            System.out.println("Driver: " + driver.getClass() + ", loader: " + driver.getClass().getClassLoader());
        }
        System.out.println("current context classLoader" + Thread.currentThread().getContextClassLoader());
        System.out.println("ServiceLoader's classLoader: " + ServiceLoader.class.getClassLoader());
    }
}
