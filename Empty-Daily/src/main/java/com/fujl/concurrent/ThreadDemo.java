package com.fujl.concurrent;

import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;

public class ThreadDemo {

    public static void main(String[] args) throws InterruptedException {

//        for (int i = 0; i < 10; i++) {
//            int finalI = i;
//            Thread thread = new Thread(()->{
//                System.out.println("hhah" + finalI);
//            });
//            if (i % 2 == 0) {
//                Thread.sleep(5000);
//            }
//            thread.start();
//        }

//        Runnable run = ThreadDemo::run;
//
//        executorService.submit(run);
//        test1();
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

    private static ExecutorService executorService = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

    private static int run() {
        System.out.println("hhh");
        int i = 1;
        return i;
    }


    @Test
    public void test() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            System.out.println("str1");
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("str2");
        });
        Thread thread3 = new Thread(() -> {
            System.out.println("str3");
        });

        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        thread3.start();
        thread3.join();


    }

    /**
     * 多线程状态下 start,run的区别
     * 多线程原理：相当于玩游戏机，只有一个游戏机（cpu），可是有很多人要玩，于是，start是排队！等CPU选中你就是轮到你，你就run（），当CPU的运行的时间片执行完，这个线程就继续排队，等待下一次的run（）。
     * 调用start（）后，线程会被放到等待队列，等待CPU调度，并不一定要马上开始执行，只是将这个线程置于可动行状态。然后通过JVM，线程Thread会调用run（）方法，执行本线程的线程体。先调用start后调用run，这么麻烦，为了不直接调用run？就是为了实现多线程的优点，没这个start不行。
     * 1.start（）方法来启动线程，真正实现了多线程运行。这时无需等待run方法体代码执行完毕，可以直接继续执行下面的代码；通过调用Thread类的start()方法来启动一个线程， 这时此线程是处于就绪状态， 并没有运行。 然后通过此Thread类调用方法run()来完成其运行操作的， 这里方法run()称为线程体，它包含了要执行的这个线程的内容， Run方法运行结束， 此线程终止。然后CPU再调度其它线程。
     * 2.run（）方法当作普通方法的方式调用。程序还是要顺序执行，要等待run方法体执行完毕后，才可继续执行下面的代码； 程序中只有主线程——这一个线程， 其程序执行路径还是只有一条， 这样就没有达到写线程的目的。
     * 记住：多线程就是分时利用CPU，宏观上让所有线程一起执行 ，也叫并发
     */
    @Test
    public  void test1() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("thread1-----------" + i);
                }
            }
        });
        Thread thread2= new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("thread2-----------" + i);
                }
            }
        });

//        thread1.run();
//        thread2.run();

//        thread1.start();
//        thread1.join();
//        thread2.start();
//        thread2.join();
        thread1.start();
        thread2.start();
    }

    @Test
    public void test2(){
        int i = 0;
        for(;;){
            System.out.println(i++);
            if (i == 5) {
                break;
            }
        }
    }
}
