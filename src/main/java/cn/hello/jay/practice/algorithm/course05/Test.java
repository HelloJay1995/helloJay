package cn.hello.jay.practice.algorithm.course05;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 周健以
 * @Date 2020年05月19日
 */
public class Test {

    public static void main(String[] args) {
        String str = "上海自来水来自海上";
        List<Character> list = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char at = str.charAt(i);
            if (list.contains(at)) {

            }else {
                list.add(at);
            }
            list.get(0);
        }
    }
}
