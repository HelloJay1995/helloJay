package cn.hello.jay.practice.juc.pool;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 周健以
 * @Date 2019年11月21日
 */
public class PoolTest {
//    public static void mainReplace(String[] args) {
//        System.out.println(Integer.toBinaryString(COUNT_BITS));
//        System.out.println(Integer.toBinaryString(-COUNT_BITS));
//    }

    private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));

    // 这里 COUNT_BITS 设置为 29(32-3)，意味着前三位用于存放线程状态，后29位用于存放线程数
// 很多初学者很喜欢在自己的代码中写很多 29 这种数字，或者某个特殊的字符串，然后分布在各个地方，这是非常糟糕的
    private static final int COUNT_BITS = Integer.SIZE - 3;

    // 000 11111111111111111111111111111
// 这里得到的是 29 个 1，也就是说线程池的最大线程数是 2^29-1=536870911
// 以我们现在计算机的实际情况，这个数量还是够用的
    private static final int CAPACITY = (1 << COUNT_BITS) - 1;

    // 我们说了，线程池的状态存放在高 3 位中
// 运算结果为 111跟29个0：111 00000000000000000000000000000
    private static final int RUNNING = -1 << COUNT_BITS;
    // 000 00000000000000000000000000000
    private static final int SHUTDOWN = 0 << COUNT_BITS;
    // 001 00000000000000000000000000000
    private static final int STOP = 1 << COUNT_BITS;
    // 010 00000000000000000000000000000
    private static final int TIDYING = 2 << COUNT_BITS;
    // 011 00000000000000000000000000000
    private static final int TERMINATED = 3 << COUNT_BITS;

    // 将整数 c 的低 29 位修改为 0，就得到了线程池的状态
    private static int runStateOf(int c) {
        return c & ~CAPACITY;
    }

    // 将整数 c 的高 3 为修改为 0，就得到了线程池中的线程数
    private static int workerCountOf(int c) {
        return c & CAPACITY;
    }

    private static int ctlOf(int rs, int wc) {
        return rs | wc;
    }

    /*
     * Bit field accessors that don't require unpacking ctl.
     * These depend on the bit layout and on workerCount being never negative.
     */

    private static boolean runStateLessThan(int c, int s) {
        return c < s;
    }

    private static boolean runStateAtLeast(int c, int s) {
        return c >= s;
    }

    private static boolean isRunning(int c) {
        return c < SHUTDOWN;
    }

}
