package com.wfb.jvm.classloader;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class MyTest27 {
    public static void main(String[] args) throws Exception {
//        Class.forName("com.mysql.jdbc.Driver");   //自JDK6开始不在需要显示调用该方法，因为J6增加了ServiceLoader类
        DriverManager.setLogWriter(new PrintWriter(System.out));
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytestdb", "root", "");
    }
}
