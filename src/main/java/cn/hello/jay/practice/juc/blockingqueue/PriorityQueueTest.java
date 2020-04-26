package cn.hello.jay.practice.juc.blockingqueue;

import java.util.PriorityQueue;

/**
 * @author 周健以
 * @Date 2020年04月21日
 */
public class PriorityQueueTest {
    public static void mainReplace(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(1);
        queue.offer(5);
        queue.offer(4);
        queue.offer(2);
        queue.offer(6);
        queue.offer(3);

        queue.poll();

    }
}
