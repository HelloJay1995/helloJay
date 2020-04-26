package cn.hello.jay.practice.algorithm;

import com.alibaba.fastjson.JSON;

/**
 * @author 周健以
 * @Date 2020年04月11日
 */
public class InsertSort {

    public static void mainReplace(String[] args) {
        int count = 0;
        int[] arr = {4, 5, 6, 1, 3, 2};

        System.out.println("排序开始:" + JSON.toJSONString(arr));
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                count++;
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j]; // 移动位置
                } else {
                    break;
                }
            }
            arr[j + 1] = temp; // 插入数据
            System.out.println(JSON.toJSONString(arr));
        }
        System.out.println("排序结束:" + JSON.toJSONString(arr));
        System.out.println("count=" + count);

    }
}
