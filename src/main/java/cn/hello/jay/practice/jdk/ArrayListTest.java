/**
 *
 */
package cn.hello.jay.practice.jdk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 周健以
 * @Date 2019年01月29日
 */
public class ArrayListTest {
    private static final ExecutorService executorService = Executors.newFixedThreadPool(10000);

    public static void main(String[] args) {
        final List<String> list = new ArrayList<>();
//        final List<String> list = Collections.synchronizedList(new ArrayList<String>());

        // 创建一个List数组
        List<String> strs = new ArrayList<String>();

        // 添加元素
        strs.add("t");
        strs.add("h");
        strs.add("a");
        strs.add("n");
        strs.add("k");
        strs.add("s");

        System.out.println(strs);
        Collections.rotate(strs,5);
        System.out.println(strs);
    }
}
