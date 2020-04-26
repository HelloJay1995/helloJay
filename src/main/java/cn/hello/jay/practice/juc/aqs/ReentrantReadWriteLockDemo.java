package cn.hello.jay.practice.juc.aqs;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author 周健以
 * @Date 2019年12月10日
 */
public class ReentrantReadWriteLockDemo {
    private int num = 10;

    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private ReentrantReadWriteLock.ReadLock readLock = rwLock.readLock();
    private ReentrantReadWriteLock.WriteLock writeLock = rwLock.writeLock();

    public void read() {
        try {
            readLock.lock();
            System.out.println("当前线程:" + Thread.currentThread().getName() + "进入read...");
            System.out.println("当前线程:" + Thread.currentThread().getName() + "read:" + num);
            Thread.sleep(1000);
            System.out.println("当前线程:" + Thread.currentThread().getName() + "退出read...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }

    public void write() {
        try {
            writeLock.lock();
            System.out.println("当前线程:" + Thread.currentThread().getName() + "进入write...");
            System.out.println("当前线程:" + Thread.currentThread().getName() + "write:" + ++num);
            Thread.sleep(1000);
            System.out.println("当前线程:" + Thread.currentThread().getName() + "退出write...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    static final int SHARED_SHIFT = 16;
    // 1 0000 0000 0000 0000
    static final int SHARED_UNIT = (1 << SHARED_SHIFT);
    // 1111 1111 1111 1111
    static final int MAX_COUNT = (1 << SHARED_SHIFT) - 1;
    static final int EXCLUSIVE_MASK = (1 << SHARED_SHIFT) - 1;

    public static void mainReplace(String[] args) {
//        final ReentrantReadWriteLockDemo urrw = new ReentrantReadWriteLockDemo();
//        for (int i = 0; i < 10; i++) {
//            new Thread(urrw::write, "w" + i).start();
//            new Thread(urrw::read, "r" + i).start();
//        }
        System.out.println(Integer.toBinaryString(10));
        System.out.println(Integer.toBinaryString(10 - 1));
        System.out.println(Integer.toBinaryString((10 - 1) >>> 1));
    }
}
