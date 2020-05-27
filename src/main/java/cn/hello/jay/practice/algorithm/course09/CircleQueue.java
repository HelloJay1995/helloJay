package cn.hello.jay.practice.algorithm.course09;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * @author 周健以
 * @Date 2020年05月22日
 */
@Data
public class CircleQueue {

    public static void main(String[] args) {
        CircleQueue queue = new CircleQueue(8);
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.enqueue("5");
        queue.enqueue("6");
        queue.enqueue("7");
        queue.dequeue();
        queue.enqueue("8");
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.enqueue("9");
        queue.enqueue("10");
        queue.enqueue("11");
        queue.enqueue("12");

    }

    private String[] items;
    private int maxNum;
    private int head;
    private int tail;

    public CircleQueue(int maxNum) {
        this.maxNum = maxNum;
        items = new String[maxNum];
        head = tail = 0;
    }

    public boolean enqueue(String item) {
        // tail+1 % maxNum == head，说明队列已满
        int i = (tail + 1) % maxNum;
        if (i == head) {
            System.out.println(JSON.toJSONString(this));
            return false;
        }

        items[tail++] = item;
        if (tail == maxNum) {
            tail = 0;
        }
        System.out.println(JSON.toJSONString(this));
        return true;
    }

    public String dequeue() {
        if (head == tail) {
            System.out.println(JSON.toJSONString(this));
            return null;
        }
        String item = items[head];
        items[head++] = null;
        if (head == maxNum) {
            head = 0;
        }
        System.out.println(JSON.toJSONString(this));
        return item;
    }
}
