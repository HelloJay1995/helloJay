package cn.hello.jay.practice.algorithm;

import com.alibaba.fastjson.JSON;

/**
 * @author 周健以
 * @Date 2020年04月11日
 */
public class BubbleSort {

    public static void mainReplace(String[] args) {
        int count = 0;
        int[] arr = {4, 5, 6, 1, 3, 2};

        System.out.println("排序开始:" + JSON.toJSONString(arr));
        for (int i = 0; i < arr.length - 1; i++) {
            boolean isChanged = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                count++;
                if (arr[j] > arr[j + 1]) {
                    isChanged = true;
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.println(JSON.toJSONString(arr));
            if (!isChanged) {
                break;
            }
        }

        System.out.println("排序结束:" + JSON.toJSONString(arr));
        System.out.println("count=" + count);
    }
}
