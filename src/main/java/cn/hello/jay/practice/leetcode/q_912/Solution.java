package cn.hello.jay.practice.leetcode.q_912;

/**
 * @author 周健以
 * @Date 2020年05月24日
 */
public class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }


    public void quickSort(int[] arr, int p, int r) {
        if (p >= r) {
            return;
        }
        // 获取分区点，其实在这就是排序
        int q = partition(arr, p, r);

        quickSort(arr, p, q - 1);
        quickSort(arr, q + 1, r);
    }

    private static int partition(int[] arr, int p, int r) {
        // 默认取最后一个位置的值当中间点
        int point = arr[r];
        // 比中间点数值大的位置
        int i = p;
        for (int j = p; j <= r; j++) {
            int jv = arr[j];
            // 比中间点小，则与i位置的值交换；交换中间点位置
            if (jv < point || j == r) {
                arr[j] = arr[i];
                arr[i] = jv;

                if (j != r) {
                    i++;
                }
            }
        }
        return i;
    }
}
