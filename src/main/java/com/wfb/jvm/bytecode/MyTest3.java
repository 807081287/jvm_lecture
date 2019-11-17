package com.wfb.jvm.bytecode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
/*
Java字节码对于异常的处理方式：
1. 统一采用异常表的方式来对异常进行处理。
2. 在JDK1.4.2之前，并不是采用异常表，而是采用特定指令。
3. 当异常处理存在finally语句块时，现在JVM采用将finally语句的字节码拼接到每一个语句块的后面的处理方式。
换句话说，程序中存在多少个catch块，就会重复多少次finally语句块。

 */
public class MyTest3 {
    //max_loacls=4.因为可能会有FileNotFoundException或IOException或Exception或只有三个局部变量。
    public void test() throws IOException, Exception{
        try {
            InputStream is = new FileInputStream("test.txt");
            ServerSocket serverSocket = new ServerSocket(9999);
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        } catch (Exception ex) {

        } finally {
            System.out.println("finally");
        }
    }
}
