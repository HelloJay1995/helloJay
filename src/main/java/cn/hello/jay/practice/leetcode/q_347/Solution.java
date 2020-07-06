package cn.hello.jay.practice.leetcode.q_347;

import com.alibaba.fastjson.JSON;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 周健以
 * @Date 2020年05月29日
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 6, 4, 5, 2, 3};
        int k = 3;
        int[] topK = new Solution().topKFrequent(nums, k);
        System.out.println(JSON.toJSONString(topK));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int n = 0;
        for (int num : nums) {
            if (num <= k && set.add(num)) {
                n++;
            }
        }
        int[] res = new int[n];
        int i = 0;
        for (Integer num : set) {
            res[i++] = num;
        }
        return res;
    }
}
