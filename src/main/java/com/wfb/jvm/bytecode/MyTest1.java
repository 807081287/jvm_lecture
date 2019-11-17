package com.wfb.jvm.bytecode;

/*
执行命令：javap -verbose com.wfb.jvm.bytecode.MyTest1
使用javap -verbose命令分析一个字节码文件时，
将会分析该字节码文件的魔数、版本号、常量池、类信息、类的构造方法、类中的方法信息、类变量与成员变量等信息。
魔数：所有的.class文件的前4个字节都是魔数，魔数值为固定值：0xCAFEBABE。(cafe baby:咖啡宝贝😂)
使用java -verbose -p命令会打印出私有方法信息，否则只会打印非私有方法。
Java中的每一个实例方法，都会被Javac编译器编译进一个this参数，
所以其参数数量总比编写的参数的数量+1，局部变量总数也如此。
 */
public class MyTest1 {
    private int a = 1;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}
