package com.fujl.pattern.singleton;

/**
 * double-checked locking
 */
public class DclSingleton {

    private DclSingleton(){}

    private volatile static DclSingleton instance;

    public static DclSingleton getInstance() {
        if (null == instance) {
            synchronized (DclSingleton.class) {
                if (null == instance) {
                    instance = new DclSingleton();
                }
            }
        }
        return instance;
    }
}
