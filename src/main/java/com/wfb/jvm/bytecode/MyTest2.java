package com.wfb.jvm.bytecode;
/*
使用java -verbose -p com.wfb.jvm.bytecode.MyTest2命令

 */
public class MyTest2 {
    String str = "welcome";
    private int x = 5;
    public static Integer in = 10;

    public MyTest2(){

    }

    public MyTest2(int x){
        this.x = x;
    }

    public static void main(String[] args) {
        MyTest2 myTest2 = new MyTest2();
        myTest2.setX(8);
        in = 20;
    }

    public synchronized void setX(int x) {
        this.x = x;
    }

    private void test(String str){
        synchronized (this){
            System.out.println("hello world");
        }
    }

    private synchronized static void test2(){}

    static {
        System.out.println("static block");
    }

    {
        System.out.println("init block");
    }
}
