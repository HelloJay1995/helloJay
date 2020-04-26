package cn.hello.jay.practice.jdk.map;

import com.alibaba.fastjson.JSON;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 周健以
 * @Date 2020年04月18日
 */
public class MapTest {

    public static void mainReplace(String[] args) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        map.put(1, 1);
        map.put(3, 3);
        map.put(6, 6);
        map.put(5, 5);
        map.put(4, 4);
        map.put(2, 2);
        System.out.println(JSON.toJSONString(map));
    }
}
