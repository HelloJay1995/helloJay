package cn.hello.jay.practice.jdk.juc;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 周健以
 * @Date 2019年09月11日
 */
public class ConcurrentHashMapTest {

//    public static void mainReplace(String[] args) {
//        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
//        map.put(1, 1);
//    }
//
//    private static int hash(Object k) {
//        int h = 0;
//
//        h ^= k.hashCode();
//
//        // Spread bits to regularize both segment and index locations,
//        // using variant of single-word Wang/Jenkins hash.
//        h += (h << 15) ^ 0xffffcd7d;
//        h ^= (h >>> 10);
//        h += (h << 3);
//        h ^= (h >>> 6);
//        h += (h << 2) + (h << 14);
//        return h ^ (h >>> 16);
//    }

    public static void mainReplace(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        for (Integer i : list) {
            list.set(i, 1);
            System.out.println(JSON.toJSONString(list));
        }
//        Iterator<Integer> it = list.iterator();
//        while (it.hasNext()) {
//            Integer next = it.next();
//            list.set(4, 100);
//            System.out.println(next);
//        }
    }
}
