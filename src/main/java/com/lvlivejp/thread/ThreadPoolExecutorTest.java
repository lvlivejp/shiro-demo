package com.lvlivejp.thread;

import java.util.concurrent.*;

public class ThreadPoolExecutorTest {
    static ExecutorService ex = Executors.newCachedThreadPool();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Future<String> futureCallable = ex.submit(new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                TimeUnit.SECONDS.sleep(5);
//                return Thread.currentThread().getName();
//            }
//        });
//        Future futureRunnable = ex.submit(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    TimeUnit.SECONDS.sleep(5);
//                    int i = 1/0;
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
        Future futureRunnableResult = ex.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "111111");
//        System.out.println(futureCallable.get());
//        System.out.println(futureRunnalbe.get());
        System.out.println(futureRunnableResult.get());
    }
}
