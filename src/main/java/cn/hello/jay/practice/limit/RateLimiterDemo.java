package cn.hello.jay.practice.limit;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 周健以
 * @Date 2020年06月28日
 */
public class RateLimiterDemo {

    public static void main(String[] args) {
        final RateLimiter rateLimiter = RateLimiter.create(2);

        ExecutorService pool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
//            pool.execute(new Runnable() {
//                @Override
//                public void run() {
                    System.out.println(rateLimiter.tryAcquire());
//                }
//            });
        }
        pool.shutdown();
    }

}
