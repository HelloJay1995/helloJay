package cn.hello.jay.practice.algorithm.course11;

/**
 * @author 周健以
 * @Date 2020年05月22日
 */
public class InsertSort {
    /**
     * 4,5,3,2,1,6
     * 插入排序
     * 第0次：4,5,3,2,1,6
     * 第1次：4,5,3,2,1,6
     * 第2次：3,4,5,2,1,6
     * 第3次：2,3,4,5,1,6
     * 第4次：1,2,3,4,5,6
     * 第5次：1,2,3,4,5,6
     */

    public static void main(String[] args) {
        int[] arr = {4, 5, 3, 2, 1, 6};

        sort(arr);
    }

    public static void sort(int[] arr) {
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }
}
