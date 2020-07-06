package cn.hello.jay.practice.leetcode.q_1115;

import java.util.concurrent.Semaphore;

/**
 * @author 周健以
 * @Date 2020年06月30日
 */
public class FooBar {
    private static final Semaphore fooSig = new Semaphore(1);
    private static final Semaphore barSig = new Semaphore(0);

    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            fooSig.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            barSig.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            barSig.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            fooSig.release();
        }
    }

    public static void main(String[] args) {
        FooBar fooBar = new FooBar(20);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.foo(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("foo");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.bar(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("bar");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        ;
    }
}