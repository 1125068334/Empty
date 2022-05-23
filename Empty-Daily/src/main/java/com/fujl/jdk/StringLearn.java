package com.fujl.jdk;

public class StringLearn {

    public static void main(String[] args) {
        String first = new String("abc");
        String second = new String("abc");
        System.err.println(first.equals(second));
        System.err.println(first.hashCode());
        System.err.println(second.hashCode());
        String intern = first.intern();
        System.out.println(intern);

    }
}
