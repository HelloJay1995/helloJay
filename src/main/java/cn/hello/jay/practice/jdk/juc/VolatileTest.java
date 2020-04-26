package cn.hello.jay.practice.jdk.juc;

/**
 * @author 周健以
 * @Date 2019年09月03日
 */
public class VolatileTest {

    public static void mainReplace(String[] args) {
        VolatileTest volatileTest = new VolatileTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                volatileTest.a();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                volatileTest.b();
            }
        }).start();
    }

    public synchronized void a(){
        System.out.println("a");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void b() {
        System.out.println("b");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
