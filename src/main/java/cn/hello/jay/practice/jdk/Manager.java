package cn.hello.jay.practice.jdk;

/**
 * @author 周健以
 * @Date 2020年04月25日
 */
public class Manager<T> implements Comparable<T> {
    @Override
    public int compareTo(T o) {
        return -1;
    }
}
