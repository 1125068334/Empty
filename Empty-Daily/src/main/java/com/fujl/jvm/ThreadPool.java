package com.fujl.jvm;

import java.util.concurrent.*;

public class ThreadPool {

    private static final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>(10), Executors.defaultThreadFactory());


    public static void main(String[] args) {
        int n = 12;
        ThreadLocal<Integer> integerThreadLocal = new ThreadLocal<>();
        integerThreadLocal.set(1);
        for (int i = 1; i <= 3; i++) {
            int finalI = i;
            integerThreadLocal.set(i);
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("thread" + finalI + "threadLocal" + integerThreadLocal.get());
                }
            });
            threadPoolExecutor.submit(thread);
        }
        BlockingQueue<Runnable> queue = threadPoolExecutor.getQueue();
        threadPoolExecutor.shutdown();
    }



}
