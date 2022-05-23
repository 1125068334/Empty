package com.fujl.javabase;

public class DataType {


    public static void main(String[] args) {

        System.out.println(2 << 3);

        System.out.println(Math.round(11.5));
        System.out.println(Math.round(-11.5));
        float f = 3.4f;

        short s1 = 1;
        s1 = (short) (s1 + 1);
        short s2 = 1;
        s2 += 1;

        System.out.println(s1 + ":" + s2);
    }
}
