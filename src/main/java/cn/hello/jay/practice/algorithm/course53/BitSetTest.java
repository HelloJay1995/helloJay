package cn.hello.jay.practice.algorithm.course53;

import com.alibaba.fastjson.JSON;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 周健以
 * @Date 2020年06月03日
 */
public class BitSetTest {

    public static void main(String[] args) throws InterruptedException {
        RejectedExecutionHandler handler = null;
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                1,
                2,
                0,
                TimeUnit.SECONDS,
                new SynchronousQueue<>());

        System.out.println(JSON.toJSONString(pool));

        for (int i = 0; i < 2; i++) {
//            Thread.sleep(1000);
            final int num = i;
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().toString() + " ok" + num);
                }
            });
        }

        Thread.sleep(10000);
    }


    static class MyThreadPoolExecutor extends ThreadPoolExecutor {

        public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        }

        public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
        }

        public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
        }

        public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
        }

        @Override
        protected void afterExecute(Runnable r, Throwable t) {
            super.afterExecute(r, t);
        }
    }

    static class DefaultThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;
        private final MyExceptionHandler exceptionHandler;

        DefaultThreadFactory(MyExceptionHandler exceptionHandler) {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() :
                            Thread.currentThread().getThreadGroup();
            namePrefix = "pool-" +
                                 poolNumber.getAndIncrement() +
                                 "-thread-";
            this.exceptionHandler = exceptionHandler;
        }

        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r,
                    namePrefix + threadNumber.getAndIncrement(),
                    0);
            if (t.isDaemon())
                t.setDaemon(false);
            if (t.getPriority() != Thread.NORM_PRIORITY)
                t.setPriority(Thread.NORM_PRIORITY);
            if (exceptionHandler != null) {
                t.setUncaughtExceptionHandler(exceptionHandler);
            }
            return t;
        }
    }

    static class MyExceptionHandler implements Thread.UncaughtExceptionHandler {

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            e.printStackTrace();
        }
    }
}
