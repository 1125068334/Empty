package com.fujl.concurrent;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.*;

public class ThreadPoolExecutorEmpty {

    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,10, 10,TimeUnit.SECONDS,new SynchronousQueue<Runnable>(), Executors.defaultThreadFactory(),new ThreadPoolExecutor.CallerRunsPolicy());


    public static void main(String[] args) {
        Callable<Integer> run = ()->{
            System.out.println("hah");
            Integer a = Integer.valueOf(333);
            return a;
        };
        Future<Integer> submit = threadPoolExecutor.submit(run);
        Integer integer = null;
        try {
            integer = submit.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            threadPoolExecutor.shutdown();
        }
        System.out.println(integer);
    }
}
