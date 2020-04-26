package cn.hello.jay.practice.jdk;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 周健以
 * @Date 2020年04月25日
 */
@Data
@AllArgsConstructor
public class Student<T> extends Manager<T> implements Comparable<T> {
    private T obj;

    @Override
    public int compareTo(T o) {
        return 20;
    }

    public static void mainReplace(String[] args) {
        Student<Integer> s1 = new Student<>(10);
        System.out.println(s1.compareTo(20));
    }
}
