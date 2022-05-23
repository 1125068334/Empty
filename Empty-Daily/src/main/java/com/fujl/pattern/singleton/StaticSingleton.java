package com.fujl.pattern.singleton;

public class StaticSingleton {

    private StaticSingleton(){}

    private static class SingleHolder{
        private static final StaticSingleton INSTANCE = new StaticSingleton();
    }

    public static final StaticSingleton getInstance() {
        return SingleHolder.INSTANCE;
    }
}
