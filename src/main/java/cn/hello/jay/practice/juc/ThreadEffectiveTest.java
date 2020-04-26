package cn.hello.jay.practice.juc;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

/**
 * 线程安全的+1操作实现种类
 *
 * @author 周健以
 * @Date 2019年11月07日
 */
public class ThreadEffectiveTest extends Thread {
    // 整体表现最好，短时间的低并发下比AtomicInteger性能差一点，高并发下性能最高
    private static LongAdder longAdder = new LongAdder();
    // 短时间低并发下，效率比synchronized高，甚至比LongAdder还高出一点，但是高并发下，性能还不如synchronized；
    // 不同情况下性能表现很不稳定；可见atomic只适合锁争用不激烈的场景
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    // 单线程情况性能最好，随着线程数增加，性能越来越差，但是比cas高
    private static int $synchronized = 0;
    //高并发下，cas性能最差
    private static volatile int cas;
    private static long casOffset;

    public static Unsafe unsafe;

    static {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe = (Unsafe) theUnsafe.get(null);
            casOffset = unsafe.staticFieldOffset(ThreadEffectiveTest.class.getDeclaredField("cas"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // 乐观锁 调用unsafe类实现cas
    public void cas() {
        boolean bl = false;
        int tmp;
        while (!bl) {
            tmp = cas;
            bl = unsafe.compareAndSwapInt(ThreadEffectiveTest.class, casOffset, tmp, tmp + 1);
        }
    }

    // 模拟AtomicInteger的实现
    public void atomicInteger() {
        unsafe.getAndAddInt(this, casOffset, 1);
    }

    // 对a执行+1操作，执行10000次
    public void run() {
        for (int i = 0; i < 10000; i++) {
            // 测试AtomicInteger 22
//            atomicInteger.incrementAndGet();

            // atomicInteger实现 29
//            atomicInteger();

            // 测试LongAdder 24
//            longAdder.increment();

            // 测试volatile和cas 乐观锁 37
//            cas();

            // 测试锁 34
//            synchronized (this) {
//                ++$synchronized;
//            }
        }
    }

//    public static void mainReplace(String[] args) {
//        long start = System.currentTimeMillis();
//
//        for (int i = 0; i < 60; i++) {
//            new ThreadEffectiveTest().start();
//        }
//
//        while (ThreadEffectiveTest.activeCount() > 1) {
//            ThreadEffectiveTest.yield();
//        }
//
//        System.out.println(System.currentTimeMillis() - start);
//        System.out.println($synchronized);
//        System.out.println(atomicInteger);
//        System.out.println(longAdder);
//        System.out.println(cas);
//    }
}
