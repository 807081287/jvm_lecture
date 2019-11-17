package com.wfb.jvm.classloader;

import java.util.Random;
/*
反编译后的区别：
public static void main(java.lang.String[]);
    Code:
       0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
       3: iconst_3
       4: invokevirtual #4                  // Method java/io/PrintStream.println:(I)V
       7: return

public static void main(java.lang.String[]);
    Code:
       0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
       3: getstatic     #3                  // Field com/wfb/jvm/classloader/FinalTest.x:I
       6: invokevirtual #4                  // Method java/io/PrintStream.println:(I)V
       9: return
 */
public class MyTest8 {
    public static void main(String[] args) {
        System.out.println(FinalTest.x);
    }
}
class FinalTest{
    public static final int x = new Random().nextInt(5);
//    public static final int x = 5;
    static {
        System.out.println("FinalTest static block");
    }
}
