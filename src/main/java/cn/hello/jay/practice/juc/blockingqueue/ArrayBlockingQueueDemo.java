package cn.hello.jay.practice.juc.blockingqueue;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.concurrent.TimeUnit.*;

/**
 * @author 周健以
 * @Date 2019年12月12日
 */
public class ArrayBlockingQueueDemo {

    static class Producer implements Runnable {
        private final String name;
        private final BlockingQueue<String> blockingQueue;
        private static Random rand = new Random(47);
        private static AtomicInteger productID = new AtomicInteger(0);

        public Producer(String name, BlockingQueue<String> blockingQueue) {
            this.name = name;
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 3; i++) {
                    SECONDS.sleep(rand.nextInt(5));
                    String str = "productID" + productID.getAndIncrement();
                    blockingQueue.put(str);
                    // 注意，这里的size()有可能是错误的
                    System.out.println(name + " product " + str + ", queue size = " + blockingQueue.size());
                }
                System.out.println(name + " is over");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Consumer implements Runnable {
        private final String name;
        private final BlockingQueue<String> blockingQueue;
        private static Random rand = new Random(47);

        public Consumer(String name, BlockingQueue<String> blockingQueue) {
            this.name = name;
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 3; i++) {
                    SECONDS.sleep(rand.nextInt(5));
                    String str = blockingQueue.take();
                    // 注意，这里的size()有可能是错误的
                    System.out.println(name + " consume " + str + ", queue size = " + blockingQueue.size());
                }
                System.out.println(name + " is over");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void mainReplace(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 3; i++) {
            service.submit(new Producer("Producer" + i, blockingQueue));
        }
        for (int i = 0; i < 3; i++) {
            service.submit(new Consumer("Consumer" + i, blockingQueue));
        }
        service.shutdown();
    }
}
