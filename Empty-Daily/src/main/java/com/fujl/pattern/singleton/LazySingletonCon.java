package com.fujl.pattern.singleton;

public class LazySingletonCon {

    private static LazySingletonCon instance;

    private LazySingletonCon(){}

    public synchronized static LazySingletonCon getInstance() {
        if (null == instance) {
            instance = new LazySingletonCon();
        }
        return instance;
    }
}
