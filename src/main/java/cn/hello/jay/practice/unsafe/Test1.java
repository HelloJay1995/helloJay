package cn.hello.jay.practice.unsafe;

/**
 * @author 周健以
 * @Date 2019年10月25日
 */
public class Test1 {
//
//    public static void mainReplace(String[] args) {
//        final Test1 test1 = new Test1();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                test1.test1();
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                test1.test1();
//            }
//        }).start();
//    }


    public synchronized void test1() {
        try {
            System.out.println("ok");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(1);
    }

    public synchronized void test2() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(2);
    }
}
