package cn.hello.jay.practice.leetcode.q_33;

/**
 * @author 周健以
 * @Date 2020年05月25日
 */
public class Solution {
    public static void main(String[] args) {
//        int[] nums = {4, 5, 6, 7, 9, 0, 1, 2};
        int[] nums = {9, 0, 1, 2, 4, 5, 6, 7};
        for (int num : nums) {
            int index = new Solution().search(nums, num);
            System.out.println(index);
        }
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[low] <= nums[mid]) {
                // mid左边段有序
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                // mid右边段有序
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }

            }
        }

        return -1;
    }
}
