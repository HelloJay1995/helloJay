package cn.hello.jay.practice.juc;

/**
 * @author 周健以
 * @Date 2020年03月19日
 */
public class DeadLockDemo {
    private static final String A = "A";
    private static final String B = "B";

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A) {
                    System.out.println("A1");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (B) {
                        System.out.println("B1");
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B) {
                    System.out.println("B2");
                    synchronized (A) {
                        System.out.println("A2");
                    }
                }
            }
        }).start();
    }
}
