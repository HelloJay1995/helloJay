package cn.hello.jay.practice.jdk.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 周健以
 * @Date 2020年04月17日
 */
public class ThreadPoolTest {

    public static void mainReplace(String[] args) {

        Thread.setDefaultUncaughtExceptionHandler(new ThreadGroup("theadExpHandler"));

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        try {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    throw new RuntimeException("异常测试");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
