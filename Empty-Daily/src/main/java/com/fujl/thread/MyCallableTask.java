package com.fujl.thread;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class MyCallableTask implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("callable do something");
        Thread.sleep(5000);
        return new Random().nextInt(100);
    }


    public static void main(String[] args) throws Exception{
        test1();
    }

    private static void test1(){
        final HashMap<String, String> map = new HashMap<String, String>(2);
        for (int i = 0; i < 10000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    map.put(UUID.randomUUID().toString(), "");
                }
            }).start();
        }
    }

    private static void test2() throws Exception{
        Callable<Integer> callable = new MyCallableTask();
        FutureTask<Integer> future = new FutureTask<>(callable);
        Thread thread = new Thread(future);
        thread.start();
        Thread.sleep(100);
        // 尝试取消此任务的执行
        future.cancel(true);
        // 判断是否在任务正常完成前取消
        System.out.println("future is cancel:" + future.isCancelled());
        if (!future.isCancelled()) {
            System.out.println("future is cancelled");
        }
        // 判断任务是否已完成
        System.out.println("future is done:" + future.isDone());
        if (!future.isDone()) {
            System.out.println("future get=" + future.get());
        } else {
            // 任务已完成
            System.out.println("task is done");
        }
    }
}
