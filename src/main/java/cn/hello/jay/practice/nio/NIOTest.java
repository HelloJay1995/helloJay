package cn.hello.jay.practice.nio;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author 周健以
 * @Date 2020年03月23日
 */
public class NIOTest {
    public static void mainReplace(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        List<String> times = new ArrayList<>();

        while (sc.hasNext()) {
            String line = sc.nextLine();
            times.add(line);
            System.out.println(JSON.toJSONString(times));

            if ("exit".equalsIgnoreCase(line)) {
                break;
            }
        }
        sc.close();
    }
}
