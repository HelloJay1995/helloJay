package cn.hello.jay.practice.leetcode.q_17;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author 周健以
 * @Date 2020年06月19日
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> list = solution.letterCombinations("");
        System.out.println(JSON.toJSONString(list));
    }

    private static final Map<Character, List<String>> KEY_MAP = new HashMap<>();

    static {
        KEY_MAP.put('2', Arrays.asList("a", "b", "c"));
        KEY_MAP.put('3', Arrays.asList("d", "e", "f"));
        KEY_MAP.put('4', Arrays.asList("g", "h", "i"));
        KEY_MAP.put('5', Arrays.asList("j", "k", "l"));
        KEY_MAP.put('6', Arrays.asList("m", "n", "o"));
        KEY_MAP.put('7', Arrays.asList("p", "q", "r", "s"));
        KEY_MAP.put('8', Arrays.asList("t", "u", "v"));
        KEY_MAP.put('9', Arrays.asList("w", "x", "y", "z"));
    }

    private static List<String> res = null;

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if (digits == null || digits.equals("")) {
            return res;
        }
        return letterCombinations(digits, 0, "");
    }

    private List<String> letterCombinations(String digits, int index, String str) {
        if (index == digits.length()) {
            res.add(str);
            return res;
        }

        char key = digits.charAt(index);
        if (KEY_MAP.containsKey(key)) {
            List<String> list = KEY_MAP.get(key);
            for (String s : list) {
                letterCombinations(digits, index + 1, str + s);
            }
        } else {
            letterCombinations(digits, index + 1, str);
        }

        return res;
    }
}
