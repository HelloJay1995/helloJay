package cn.hello.jay.practice.juc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.Date;

/**
 * @author 周健以
 * @Date 2019年11月20日
 */
public class TestJoin extends Thread {

    public static void mainReplace(String[] args) {
        Thread t = new TestJoin();
        Thread t1 = new SubThread(t);
        t1.start();//这个子线程会先持有线程t的锁
        t.start();
        try {
            //main线程只等待1000ms,无论子线程是否结束，均不在等待，但是其等待的前提条件时要持有线程t的锁
            t.join(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(JSON.toJSONString(new Date(), SerializerFeature.WriteDateUseDateFormat) + ":main end");
    }

    @Override
    public void run() {
        super.run();
        System.out.println(JSON.toJSONString(new Date(), SerializerFeature.WriteDateUseDateFormat) + ":sub  Thread begin");
        try {
            System.out.println(JSON.toJSONString(new Date(), SerializerFeature.WriteDateUseDateFormat) + ":sub  Thread sleep begin");
            Thread.sleep(800);//休眠800毫秒
            System.out.println(JSON.toJSONString(new Date(), SerializerFeature.WriteDateUseDateFormat) + ":sub  Thread sleep end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(JSON.toJSONString(new Date(), SerializerFeature.WriteDateUseDateFormat) + ":subThread end");
    }
}

class SubThread extends Thread {

    Thread thread;

    public SubThread(Thread t) {
        this.thread = t;
    }

    @Override
    public void run() {
        super.run();
        holdThreadLock(thread);
    }

    private void holdThreadLock(Thread thread2) {
        synchronized (thread2) {
            System.out.println(JSON.toJSONString(new Date(), SerializerFeature.WriteDateUseDateFormat) + ":hold Thread lock");
            try {
                Thread.sleep(3000);//休眠3000毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(JSON.toJSONString(new Date(), SerializerFeature.WriteDateUseDateFormat) + ":release Thread lock");
        }
    }
}
