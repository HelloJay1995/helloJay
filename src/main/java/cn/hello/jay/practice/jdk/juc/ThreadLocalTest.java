package cn.hello.jay.practice.jdk.juc;

/**
 * @author 周健以
 * @Date 2020年04月22日
 */
public class ThreadLocalTest {

    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void mainReplace(String[] args) {
        threadLocal.set(10);
        System.out.println(threadLocal.get());
        threadLocal.set(20);
        System.out.println(threadLocal.get());
    }
}
