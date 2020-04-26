package cn.hello.jay.practice.jdk.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 周健以
 * @Date 2019年09月02日
 */
public class LRU<K, V> extends LinkedHashMap<K, V> implements Map<K, V> {

    private static final long serialVersionUID = -3908194943875548001L;

    public LRU(int initialCapacity,
               float loadFactor,
               boolean accessOrder) {
        super(initialCapacity, loadFactor, accessOrder);
    }

    @Override
    protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
        if (size() > 6) {
            return true;
        }
        return false;
    }

    public static void mainReplace(String[] args) {

        LRU<Character, Integer> lru = new LRU<>(16, 0.75f, false);

        String s = "abcdefg";
        for (int i = 0; i < s.length(); i++) {
            lru.put(s.charAt(i), i);
            System.out.println("LRU ：" + lru);
            lru.get('a');
            lru.get('b');
            lru.get('c');
            lru.get('d');
            lru.get('e');
            lru.get('f');
        }
        System.out.println("LRU的大小 ：" + lru.size());
        System.out.println("LRU ：" + lru);
    }
}
