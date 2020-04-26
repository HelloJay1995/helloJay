package cn.hello.jay.practice.leetcode;

import com.alibaba.fastjson.JSON;

/**
 * @author 周健以
 * @Date 2020年04月11日
 */
public class TwoSum {
    public static void mainReplace(String[] args) {
        int[] nums = {-1, -2, -3, -4, 10};
        System.out.println(JSON.toJSONString(twoSum(nums, 7)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int firstNum = 0, secondNum = 0;
        ok:
        for (int i = 0; i < nums.length - 1; i++) {
//            if (target < nums[i]) {
//                continue;
//            }
            firstNum = i;
            int leftValue = target - nums[i];
            for (int j = i; j < nums.length - 1; j++) {
                if (leftValue == nums[j + 1]) {
                    secondNum = j + 1;
                    break ok;
                }
            }
        }
        return new int[]{firstNum, secondNum};
    }


}
