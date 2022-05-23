package com.fujl.solve;

import java.io.FileNotFoundException;
import java.io.PrintStream;

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
