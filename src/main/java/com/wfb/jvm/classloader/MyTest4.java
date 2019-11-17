package com.wfb.jvm.classloader;

public class MyTest4 {
    public static void main(String[] args) {
        /*
         * 执行结果：
         * MyParent4 static block
         */
//        MyParent4 myParent4 = new MyParent4();

        /*
         * 执行结果：
         * class [Lcom.wfb.jvm.classloader.MyParent4;
         * class java.lang.Object
         * 这是对MyParent4类的被动使用，不会导致该类的初始化。
         * new关键字说明创建了某个类，该类为[Lcom.wfb.jvm.classloader.MyParent4，
         * 它是JVM在运行期创建出来的,其父类为Object。
         */
        MyParent4[] myParent4s = new MyParent4[1];
        System.out.println(myParent4s.getClass());
        System.out.println(myParent4s.getClass().getSuperclass());

        /*
         * 执行结果：
         * class [[Lcom.wfb.jvm.classloader.MyParent4;
         * class java.lang.Object
         * 数组每增加一个维度，JVM创建的该类为会多加一个[。
         * 对于数组来说，JavaDoc经常将构成数组的元素称为Component，实际上就是将数组降低一个维度后的类型。
         */
        MyParent4[][] myParent4s1 = new MyParent4[1][1];
        System.out.println(myParent4s1.getClass());
        System.out.println(myParent4s1.getClass().getSuperclass());

        /*
         * 执行结果：
         * class [I
         * class java.lang.Object
         */
        int[] ints = new int[1];
        System.out.println(ints.getClass());
        System.out.println(ints.getClass().getSuperclass());

        long[] longs = new long[1]; //class [J
        System.out.println(longs.getClass());
        short[] shorts = new short[1];  //class [S
        System.out.println(shorts.getClass());
        byte[] bytes = new byte[1]; //class [B
        System.out.println(bytes.getClass());
        char[] chars = new char[1]; //class [C
        System.out.println(chars.getClass());
        boolean[] booleans = new boolean[1];    //class [Z
        System.out.println(booleans.getClass());
        float[] floats = new float[1];  //class [F
        System.out.println(floats.getClass());
        double[] doubles = new double[1];   //class [D
        System.out.println(doubles.getClass());
    }
}
class MyParent4{
    static {
        System.out.println("MyParent4 static block");
    }
}
