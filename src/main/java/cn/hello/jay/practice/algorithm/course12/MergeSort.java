package cn.hello.jay.practice.algorithm.course12;

import com.alibaba.fastjson.JSON;

/**
 * @author 周健以
 * @Date 2020年05月24日
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {4, 5, 3, 2, 1, 6};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(JSON.toJSONString(arr));
    }

    public static void mergeSort(int[] arr, int p, int r) {
        if (p >= r) {
            return;
        }

        int q = p + (r - p) / 2;
        mergeSort(arr, p, q);
        mergeSort(arr, q + 1, r);

        merge(arr, p, q, r);
    }

    public static void merge(int[] arr, int p, int q, int r) {
        int[] temp = new int[r - p + 1];
        int left = p, right = q + 1, target = 0;
        // 合并排序
        while (left <= q && right <= r) {
            temp[target++] = arr[left] < arr[right] ? arr[left++] : arr[right++];
        }
        // 添加末位剩余数据
        int start = left;
        int end = q;
        if (right <= r) {
            start = right;
            end = r;
        }
        while (start <= end) {
            temp[target++] = arr[start++];
        }
        // temp->arr
        for (int i = 0; i < temp.length; i++) {
            arr[p++] = temp[i];
        }
    }


}
