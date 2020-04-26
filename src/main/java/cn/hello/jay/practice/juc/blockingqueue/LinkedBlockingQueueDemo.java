package cn.hello.jay.practice.juc.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author 周健以
 * @Date 2019年12月12日
 */
public class LinkedBlockingQueueDemo {

    public static void mainReplace(String[] args) throws Exception {
        BlockingQueue<Task> delayQueue = new DelayQueue<>();
        long now = System.currentTimeMillis();
        delayQueue.put(new Task(now + 3000));
        delayQueue.put(new Task(now + 4000));
        delayQueue.put(new Task(now + 6000));
        delayQueue.put(new Task(now + 1000));
        System.out.println(delayQueue);

        for (int i = 0; i < 4; i++) {
            System.out.println(delayQueue.take());
        }

    }

    static class Task implements Delayed {
        long time = System.currentTimeMillis();

        public Task(long time) {
            this.time = time;
        }

        @Override
        public int compareTo(Delayed o) {
            if (this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS))
                return -1;
            else if (this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS))
                return 1;
            else
                return 0;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(time - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        public String toString() {
            return "" + time;
        }
    }
}
