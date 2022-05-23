package com.fujl.pattern.singleton;

public class Singleton {

    private static final Singleton instance = new Singleton();

    private Singleton(){}

    public static Singleton getInstance(){
        return instance;
    }

    public String getMessage(){
        return "Single";
    }

    public static void main(String[] args) {
        System.out.println(getInstance().getMessage());
    }
}
