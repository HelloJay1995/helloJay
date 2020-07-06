package cn.hello.jay.practice.leetcode.q_198;

/**
 * @author 周健以
 * @Date 2020年06月22日
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(new Solution().rob(nums));
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }

        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            int temp = second;
            second = Math.max(nums[i] + first, second);
            first = temp;
        }

        return second;
    }
}
