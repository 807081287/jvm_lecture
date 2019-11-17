package com.wfb.jvm.bytecode;

import java.util.Date;
/*
针对于方法调用的动态分配的过程，JVM会在类的方法区建立一个虚方法表的数据结构（vtable）
针对于invokeinterface指令来说，JVM会建立一个叫做接口方法表的数据结构（itable）
 */
public class MyTest7 {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal dog = new Dog();
        animal.test("hello");
        dog.test(new Date());
    }
}
class Animal{
    public void test(String str){
        System.out.println("animal str");
    }
    public void test(Date date){
        System.out.println("animal data");
    }
}
class Dog extends Animal{
    @Override
    public void test(String str){
        System.out.println("dog str");
    }

    @Override
    public void test(Date date) {
        System.out.println("dog data");
    }
}
