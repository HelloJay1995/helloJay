package cn.hello.jay.practice.leetcode.other;

/**
 * @author 周健以
 * @Date 2020年06月19日
 */
public class Example {
    int x = 0;
    volatile boolean v = false;

    public synchronized void writer() {
        System.out.println(1);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        x = 42;
        v = true;
    }

    public void reader() {
        System.out.println(2);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (v) {
            System.out.println(x);
        }
    }

    public static void main(String[] args) {
        Example e = new Example();

        new Thread(new Runnable() {
            @Override
            public void run() {
                e.writer();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                e.reader();
            }
        }).start();
    }

}
