package cn.hello.jay.practice.leetcode.q_1114;

/**
 * @author 周健以
 * @Date 2020年06月30日
 */
public class Foo3 {
    private static volatile int num = 1;

    public Foo3() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        while (num != 1) {

        }
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        num = 2;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (num != 2) {

        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        num = 3;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (num != 3) {

        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
