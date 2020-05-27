package cn.hello.jay.practice.leetcode.other;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author 周健以
 * @Date 2020年04月12日
 */
public class Main {

    // 123#222235/56
    // 123adjjm
    public static void mainReplace(String[] args) {
        String[] zero = {" "};
        String[] one = {",", "."};
        String[] two = {"a", "b", "c"};
        String[] three = {"d", "e", "f"};
        String[] four = {"g", "h", "i"};
        String[] five = {"j", "k", "l"};
        String[] six = {"m", "n", "o"};
        String[] seven = {"p", "q", "r", "s"};
        String[] eight = {"t", "u", "v"};
        String[] nine = {"w", "x", "y", "z"};

        String[][] numArr = {zero, one, two, three, four, five, six, seven, eight, nine};

        boolean numMode = true;
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();

        Scanner in = new Scanner(System.in);
        String inputStr = in.next();
        for (int i = 0; i < inputStr.length(); i++) {
            String charAt = String.valueOf(inputStr.charAt(i));

            if ("#".equals(charAt)) {
                if (map.size() > 0 && !numMode) {
                    for (Map.Entry<String, Integer> entry : map.entrySet()) {
                        // 只会遍历到一条
                        String[] num = numArr[Integer.parseInt(entry.getKey())];
                        sb.append(num[(entry.getValue() - 1) % num.length]);
                        break;
                    }
                    map.clear();
                }
                numMode = !numMode;
                continue;
            }

            if (numMode) {
                if (!"/".equals(charAt)) {
                    sb.append(charAt);
                }
            } else {
                Integer sameTimes = map.get(charAt);
                if (sameTimes == null || sameTimes == 0 || "/".equals(charAt)) {
                    // 新的charAt或者是强制刷新
                    for (Map.Entry<String, Integer> entry : map.entrySet()) {
                        // 只会遍历到一条
                        String[] num = numArr[Integer.parseInt(entry.getKey())];
                        sb.append(num[(entry.getValue() - 1) % num.length]);
                        break;
                    }
                    map.clear();
                    if (!"/".equals(charAt)) {
                        map.put(charAt, 1);
                    }
                } else {
                    if (!"/".equals(charAt)) {
                        map.put(charAt, ++sameTimes);
                    }
                }
            }

        }
        if (map.size() > 0 && !numMode) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                // 只会遍历到一条
                String[] num = numArr[Integer.parseInt(entry.getKey())];
                sb.append(num[(entry.getValue() - 1) % num.length]);
                break;
            }
            map.clear();
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(-4));
        System.out.println(Integer.toBinaryString(-4 >> 1));
        System.out.println(-4 >> 1);
        System.out.println(Integer.toBinaryString(-4 >>> 1));
        System.out.println(-4 >>> 1);
    }
}
