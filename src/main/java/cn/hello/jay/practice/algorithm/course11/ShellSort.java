package cn.hello.jay.practice.algorithm.course11;

import com.alibaba.fastjson.JSON;

/**
 * @author 周健以
 * @Date 2020年04月11日
 */
public class ShellSort {

    public static void mainReplace(String[] args) {
        int count = 0;
        int[] arr = {4, 5, 6, 1, 3, 2};
        System.out.println(1 / 2);
        System.out.println("排序开始:" + JSON.toJSONString(arr));
        int len = arr.length;
        for (int gap = len / 2; gap > 0; gap = len / 2) {
            // 注意：这里和动图演示的不一样，动图是分组执行，实际操作是多个分组交替执行
            for (int i = gap; i < len; i++) {
                int j = i;
                int current = arr[i];
                while (j - gap >= 0 && current < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j = j - gap;
                }
                arr[j] = current;
            }
        }
        System.out.println("排序结束:" + JSON.toJSONString(arr));
        System.out.println("count=" + count);
    }
}
