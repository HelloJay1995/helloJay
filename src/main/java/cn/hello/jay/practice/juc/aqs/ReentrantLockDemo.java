package cn.hello.jay.practice.juc.aqs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 周健以
 * @Date 2019年11月28日
 */
public class ReentrantLockDemo {
    private static final Lock lock = new ReentrantLock();

    public static void mainReplace(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    lock.lock();
                    try {
                        Thread.sleep(100000000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            });
        }
    }
}
