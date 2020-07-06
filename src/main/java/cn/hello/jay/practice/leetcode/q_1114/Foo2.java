package cn.hello.jay.practice.leetcode.q_1114;

import java.util.concurrent.Semaphore;

/**
 * @author 周健以
 * @Date 2020年06月30日
 */
public class Foo2 {
    private static final Semaphore first = new Semaphore(1);
    private static final Semaphore two = new Semaphore(0);
    private static final Semaphore three = new Semaphore(0);

    public Foo2() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        first.acquire();
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        two.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        two.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        three.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        three.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
