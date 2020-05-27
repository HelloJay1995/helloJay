package cn.hello.jay.practice.algorithm.course13;

/**
 * @author 周健以
 * @Date 2020年05月24日
 */
public class CountSort {
    public static void main(String[] args) {
        int[] arr = {4, 5, 3, 2, 1, 6, 4, 2, 2, 3, 1, 5, 1};
        sort(arr);
    }

    public static void sort(int[] arr) {
        // 取数字最大范围
        int maxV = arr[0];
        for (int v : arr) {
            if (v > maxV) {
                maxV = v;
            }
        }
        // 0~maxV个数
        int[] nums = new int[maxV + 1];
        // 初始化
        for (int i = 0; i < maxV; i++) {
            nums[i] = 0;
        }
        // 对应值累加
        int arrLength = arr.length;
        for (int i = 0; i < arrLength; i++) {
            nums[arr[i]]++;
        }
        // 小于等于累计
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }
        // 将nums转移到arr
        int[] temp = new int[arrLength];
        for (int i = arrLength - 1; i >= 0; i--) {
            int index = --nums[arr[i]];
            temp[index] = arr[i];
        }
        for (int i = 0; i < temp.length; i++) {
            arr[i] = temp[i];
        }
    }
}
