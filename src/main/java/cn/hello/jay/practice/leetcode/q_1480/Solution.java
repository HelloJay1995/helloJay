package cn.hello.jay.practice.leetcode.q_1480;

import com.alibaba.fastjson.JSON;

/**
 * @author 周健以
 * @Date 2020年06月29日
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(JSON.toJSONString(new Solution().runningSum(nums)));
    }

    public int[] runningSum(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }
        return nums;
    }
}
