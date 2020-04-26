package cn.hello.jay.practice.algorithm;

import com.alibaba.fastjson.JSON;

/**
 * @author 周健以
 * @Date 2020年04月11日
 */
public class SelectionSort {

    public static void mainReplace(String[] args) {
        int count = 0;
        int[] arr = {4, 5, 6, 1, 3, 2};

        System.out.println("排序开始:" + JSON.toJSONString(arr));
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int index = i;
            for (int j = i; j < arr.length; j++) {
                count++;

                if (arr[j] < min) {
                    min = arr[j];
                    index = j;
                }
            }
            arr[index] = arr[i];
            arr[i] = min;

            System.out.println(JSON.toJSONString(arr));
        }
        System.out.println("排序结束:" + JSON.toJSONString(arr));
        System.out.println("count=" + count);

    }
}
