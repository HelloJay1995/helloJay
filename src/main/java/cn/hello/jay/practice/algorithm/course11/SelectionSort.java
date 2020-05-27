package cn.hello.jay.practice.algorithm.course11;

/**
 * @author 周健以
 * @Date 2020年05月22日
 */
public class SelectionSort {
    /**
     * 4,5,3,2,1,6
     * 选择排序
     * 第0次：4,5,3,2,1,6
     * 第1次：1,5,3,2,4,6
     * 第2次：1,2,3,5,4,6
     * 第3次：1,2,3,5,4,6
     * 第4次：1,2,3,4,5,6
     * 第5次：1,2,3,4,5,6
     */

    public static void main(String[] args) {
        int[] arr = {4, 5, 3, 2, 1, 6};

        sort(arr);
    }

    public static void sort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int min = arr[i];
            int index = i;
            for (int j = i + 1; j < length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    index = j;
                }
            }
            arr[index] = arr[i];
            arr[i] = min;
        }
    }
}
