package cn.hello.jay.practice.juc;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author 周健以
 * @Date 2020年01月10日
 */
@Slf4j
public class Singleton {
    private static Singleton instance = null;

    private int v;

    private Singleton() {
        this.v = 3;
    }

//    public static Singleton getInstance() {
//        if (instance == null) { //
//            Singleton temp;
//            synchronized (Singleton.class) { //
//                temp = instance;
//                if (temp == null) { //
//                    synchronized (Singleton.class) { // 内嵌一个 synchronized 块
//                        temp = new Singleton();
//                    }
//                    instance = temp; //
//                }
//            }
//        }
//        return instance;
//    }

    public static Singleton getInstance() {
        if (instance == null) { // 1. 第一次检查
            synchronized (Singleton.class) { // 2
                if (instance == null) { // 3. 第二次检查
                    instance = new Singleton(); // 4
                }
            }
        }
        return instance;
    }

    private static final AtomicBoolean flag = new AtomicBoolean(false);

//    static final Semaphore sp = new Semaphore(1);
//    public static void mainReplace(String[] args) throws InterruptedException {
//        for (int i = 0; i < 100; i++) {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        while (!flag.compareAndSet(false, true)) {
//
//                        }
//                        try {
//                            Thread.sleep(10000);
//                            Semp             } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        log.info(Thread.currentThread().getName() + "开始flag=" + flag);
//                    } finally {
//                        flag.set(false);
//                        log.info(Thread.currentThread().getName() + "结束flag=" + flag);
//                    }
//                }
//            }).start();
//
//        }
//        while (true) {
//
//        }
//    }

    public static void mainReplace(String[] args) throws ParseException {
//        Date updateDate = new DateTime(2020, 4, 22, 10, 32, 20).toDate();
//        Date now = new Date();
//        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        System.out.println(JSON.toJSONString(sdf.parse(sdf.format(updateDate)), SerializerFeature.WriteDateUseDateFormat));
//        System.out.println(JSON.toJSONString(sdf.parse(sdf.format(now)), SerializerFeature.WriteDateUseDateFormat));
//        System.out.println(sdf.parse(sdf.format(now)).compareTo(sdf.parse(sdf.format(updateDate))) > 0);
        System.out.println(0x61c88647);
    }
}
