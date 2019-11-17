package com.wfb.jvm.bytecode;
/*
方法的动态分配：

invokevirtual字节码指令的多态查找流程：
1. 找到操作数栈顶的第一个元素所指向的实际类型。
2. 查找该类是否正确的被调用的函数，找到就执行它
3. 未找到就在其父类重复3
4. 都未找到，则报错

方法重载是静态的，是编译期行为；方法重写是动态的，是运行期行为。
 */
public class MyTest6 {
    public static void main(String[] args) {
        Fruit apple = new Apple();
        Fruit orange = new Orange();
        apple.test();
        orange.test();
        apple = new Orange();
        apple.test();
    }
}
class Fruit{
    public void test(){
        System.out.println("Fruit");
    }
}
class Apple extends Fruit{
    @Override
    public void test(){
        System.out.println("Apple");
    }
}
class Orange extends Fruit{
    @Override
    public void test(){
        System.out.println("Orange");
    }
}
