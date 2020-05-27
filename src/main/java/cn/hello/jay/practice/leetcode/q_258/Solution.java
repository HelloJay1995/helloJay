package cn.hello.jay.practice.leetcode.q_258;

/**
 * @author 周健以
 * @Date 2020年05月22日
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().addDigits(38));
    }

    public int addDigits(int num) {
        int x = num / 10;
        int y = num % 10;
        int res = x + y;
        if (res > 9) {
            res = addDigits(res);
        }
        return res;
    }
}
