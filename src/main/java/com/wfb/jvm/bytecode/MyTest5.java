package com.wfb.jvm.bytecode;
/*
执行结果：
grandpa
grandpa
方法的静态分派：
Grandpa g1 = new Father(); //g1的静态类型是Grandpa，而实际类型（真正只想的类型）是Father。
而变量的静态类型是不会发生变化的，而实际类型可以发生变化，实际类型只有在运行期才能确定。
 */
public class MyTest5 {
    //方法重载，是一种静态行为，在编译期就可完全确定。
    public void test(Grandpa grandpa){
        System.out.println("grandpa");
    }
    public void test(Father father){
        System.out.println("father");
    }
    public void test(Son son){
        System.out.println("son");
    }

    public static void main(String[] args) {
        Grandpa g1 = new Father();
        Grandpa g2 = new Son();
        MyTest5 myTest5 = new MyTest5();
        myTest5.test(g1);
        myTest5.test(g2);
    }
}
class Grandpa{

}
class Father extends Grandpa{

}
class Son extends Father{

}
