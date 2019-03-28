package com.lvlivejp.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairTest {
    private Object obj = new Object();
    private Lock lock = new ReentrantLock(true);
    public CountDownLatch cd = new CountDownLatch(1);

    public void blockTest(long time) {
        try {
            cd.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (obj) {
//        lock.lock();
            System.out.println(Thread.currentThread().getName() + "持有锁" + System.currentTimeMillis());
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//        System.out.println(Thread.currentThread().getName()+"释放锁"+ System.currentTimeMillis());
//        lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FairTest fairTest = new FairTest();
        for (int i = 0; i < 50; i++) {
            int finalI = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "开始执行" + System.currentTimeMillis());
                fairTest.blockTest(0);
            }, "thread" + i).start();
        }
        Thread.sleep(1000);
        fairTest.cd.countDown();
    }

}
