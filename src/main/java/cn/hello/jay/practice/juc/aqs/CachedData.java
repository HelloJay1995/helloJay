package cn.hello.jay.practice.juc.aqs;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author 周健以
 * @Date 2020年01月14日
 */
public class CachedData {
    // 读写锁实例
    static final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public static void mainReplace(String[] args) {
        ReentrantReadWriteLock.ReadLock readLock = rwl.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = rwl.writeLock();

        System.out.println("writeLock.lock()");
        writeLock.lock();

        System.out.println("readLock.lock()");
        readLock.lock();

        System.out.println("readLock.unlock()");
        readLock.unlock();
        System.out.println("writeLock.unlock()");
        writeLock.unlock();
    }
}
