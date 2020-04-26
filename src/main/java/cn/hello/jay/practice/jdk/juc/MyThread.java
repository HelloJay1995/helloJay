package cn.hello.jay.practice.jdk.juc;

/**
 * @author 周健以
 * @Date 2019年09月03日
 */
public class MyThread extends Thread{
    // 既然使用 synchronized关键字 ，就没必要使用 volatile关键字了
    public static int count;

    //注意必须添加 static 关键字，这样synchronized 与 static 锁的就是 Mythread.class 对象了，
    //也就达到同步效果了
    private synchronized static void addCount() {
        for (int i = 0; i < 100; i++) {
            count++;
        }
        System.out.println("count=" + count);
    }

    @Override
    public void run() {
        addCount();
    }
}
