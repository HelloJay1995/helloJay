package cn.hello.jay.practice.juc;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author 周健以
 * @Date 2020年03月19日
 */
public class DeadLockDemo {
    private static final String A = "A";
    private static final String B = "B";

    public static void mainReplace(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A) {
                    for (int i = 0; i < 10000; i++) {
                        try {
                            FileReader fileReader = new FileReader("Users/hellojay/Desktop/QA.txt");
                            fileReader.read();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("A1");
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
