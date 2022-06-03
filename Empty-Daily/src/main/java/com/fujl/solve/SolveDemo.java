package com.fujl.solve;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * 此类是 财信中遇到的一个问题：程序中引入sqlserver的数据库依赖，本地启动正常，安装盘启动报错；当时波哥修改启动类中的代码，输出日志
 * 重点是：解决bug的思路
 */
public class SolveDemo {

    public static void main(String[] args) throws FileNotFoundException {
        PrintStream out = new PrintStream("D:/log.txt");
        System.setOut(out);
        try {
            System.out.println("normal");
            int i = 1/0;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

}
