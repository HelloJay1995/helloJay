package cn.hello.jay.practice.algorithm.course11;

import com.alibaba.fastjson.JSON;

/**
 * @author 周健以
 * @Date 2020年05月22日
 */
public class BubbleSort {
    /**
     * 4,5,3,2,1,6
     * 冒泡排序
     * 第0次：4,5,3,2,1,6
     * 第1次：4,3,2,1,5,6
     * 第2次：3,2,1,4,5,6
     * 第3次：2,1,3,4,5,6
     * 第4次：1,2,3,4,5,6
     * 第5次：1,2,3,4,5,6
     * 第6次：1,2,3,4,5,6
     */

    public static void main(String[] args) {
        int[] arr = {4, 5, 3, 2, 1, 6};

        sort(arr);
    }

    public static void sort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            boolean flag = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            System.out.println(JSON.toJSONString(arr));
            if (!flag) {
                break;
            }
        }
    }
}
